package com.luxbp.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Read the content of the specified configuration file in the configuration center and display it on the page
@RestController
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${config.info}")
    private String configInfo;
    @Value("${config.version}")
    private String configVersion;
    @GetMapping(value = "/getConfig")
    public String getConfig() {
        return "info：" + configInfo + "<br/>version：" + configVersion + "<br/>port：" + serverPort;
    }
}