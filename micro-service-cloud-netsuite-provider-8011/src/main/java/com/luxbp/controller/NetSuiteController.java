package com.luxbp.controller;

import com.luxbp.netsuite.application.AccountDetails;
import com.luxbp.netsuite.application.NetsuiteServiceManager;
import com.luxbp.netsuite.application.TestPortSingleton;
import com.netsuite.webservices.lists.relationships_2022_2.CustomerSearchAdvanced;
import com.netsuite.webservices.platform.core_2022_2.SearchResult;
import com.netsuite.webservices.platform.faults_2022_2.*;
import com.netsuite.webservices.platform_2022_2.NetSuitePortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;

import static org.junit.Assert.assertTrue;

/**
 * Service Provider Control Layer / 服务提供者的控制层
 * author:
 */
@RestController
@Slf4j
public class NetSuiteController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/port", method = RequestMethod.GET)
    public String getTestResult(@PathVariable("id") int id) {
        String ret = "";
        TestPortSingleton instance = new TestPortSingleton();
        try {
            ret += instance.met();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

}