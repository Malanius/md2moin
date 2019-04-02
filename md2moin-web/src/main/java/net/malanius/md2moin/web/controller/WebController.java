package net.malanius.md2moin.web.controller;

import lombok.extern.slf4j.Slf4j;
import net.malanius.md2moin.web.entity.ConvertRequest;
import net.malanius.md2moin.web.service.ConvertService;
import net.malanius.md2moin.web.util.ViewNames;
import net.malanius.md2moin.web.util.WebMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class WebController {

    private final ConvertService convertService;

    @Autowired
    public WebController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @GetMapping(WebMappings.HOME)
    public String getHome() {
        log.trace("getHome() - start.");
        return ViewNames.HOME;
    }

    @PostMapping(value = WebMappings.HOME, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String postMd(@ModelAttribute("request") ConvertRequest request) {
        log.trace("postMd({}) - start.", request);
        return convertService.convert(request);
    }

}
