package net.malanius.md2moin.web.auth;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JwtConfig {

    @Value("${security.jwt.region:eu-west-1}")
    private String region;

    @Value("${security.jwt.publicKeyUri:https://public-keys.auth.elb.eu-west-1.amazonaws.com/}")
    private String publicKeyUri;

    @Value("${security.jwt.jwt_header:x-amzn-oidc-data}")
    private String jwtHeader;

    @Value("${security.jwt.jwt_header:x-amzn-oidc-accesstoken}")
    private String accessTokenHeader;

    @Value("${security.jwt.jwt_header:x-amzn-oidc-identity}")
    private String identityHeader;

}
