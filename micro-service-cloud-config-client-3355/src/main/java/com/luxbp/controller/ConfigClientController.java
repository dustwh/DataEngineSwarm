package com.luxbp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Read the content of the specified configuration file in the configuration center and display it on the page
@RefreshScope //In order to get the latest git configuration dynamically (manually), add the actuator to monitor and load RefreshScope,
@RestController
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${config.info}")
    private String configInfo;
    @Value("${config.version}")
    private String configVersion;
    @Value("${netsuite.accountId}")
    private String accountId;
    @Value("${netsuite.consumerKey}")
    private String consumerKey;
    @Value("${netsuite.consumerSecret}")
    private String consumerSecret;
    @Value("${netsuite.netsuiteToken}")
    private String netsuiteToken;
    @Value("${netsuite.netsuiteSecret}")
    private String netsuiteSecret;
    @GetMapping(value = "/getTestConfig")
    public String getTestConfig() {
        return "info：" + configInfo + "<br/>version：" + configVersion + "<br/>port：" + serverPort;
    }
    @GetMapping(value = "/getAccountId")
    public String getAccountId() {
        return accountId;
    }

    @GetMapping(value = "/getConsumerKey")
    public String getConsumerKey() {
        return consumerKey;
    }

    @GetMapping(value = "/getConsumerSecret")
    public String getConsumerSecret() {
        return consumerSecret;
    }

    @GetMapping(value = "/getNetsuiteToken")
    public String getNetsuiteToken() {
        return netsuiteToken;
    }

    @GetMapping(value = "/getNetsuiteSecret")
    public String getNetsuiteSecret() {
        return netsuiteSecret;
    }
}