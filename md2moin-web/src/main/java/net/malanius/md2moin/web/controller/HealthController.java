package net.malanius.md2moin.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthController {

    @GetMapping("/healthcheck")
    @ResponseStatus(HttpStatus.OK)
    public String checkHealth() {
        return "Running...";
    }

}
