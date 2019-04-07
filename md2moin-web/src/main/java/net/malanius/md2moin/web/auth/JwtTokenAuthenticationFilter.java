package net.malanius.md2moin.web.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;

    public JwtTokenAuthenticationFilter(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String jwt = request.getHeader(jwtConfig.getJwtHeader());
        String accessToken = request.getHeader(jwtConfig.getAccessTokenHeader());
        String identity = request.getHeader(jwtConfig.getIdentityHeader());

        log.debug("jwt={}", jwt);
        log.debug("accessToken={}", accessToken);
        log.debug("identity={}", identity);

        if (jwt == null) {
            chain.doFilter(request, response);
            return;
        }

        String unsignedJwt = jwt.substring(0, jwt.lastIndexOf('.') + 1);

        try {
            Claims claims = Jwts.parser().parseClaimsJwt(unsignedJwt).getBody();
            String username = (String) claims.get("email");
            username = username == null ? claims.getSubject() : username;
            log.debug("user={}", username);

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    username, null, null);

            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (Exception ex) {
            log.debug("Something wrong with the token!", ex);
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }

}
