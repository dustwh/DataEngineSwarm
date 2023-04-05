package com.luxbp.controller;

import com.luxbp.service.netsuite.TestPortSingleton;
//import com.netsuite.webservices.lists.relationships_2022_2.CustomerSearchAdvanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
//import static org.junit.Assert.assertTrue;

@RestController
@Slf4j
public class NetSuiteController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private TestPortSingleton testPortSingleton;
    @RequestMapping(value = "/port", method = RequestMethod.GET)
    public String getCustomerSearchAdvanced() {
        String ret = "";
//        TestPortSingleton instance = new TestPortSingleton();
        try {
            //System.out.println("8011 controller");
            ret += testPortSingleton.getCustomerSearchAdvanced();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

}