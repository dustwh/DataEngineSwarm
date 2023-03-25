package com.luxbp.service.netsuite;

import com.luxbp.service.openfeign.NetsuiteConfigFeignService;
import com.netsuite.webservices.lists.relationships_2022_2.CustomerSearchAdvanced;
import com.netsuite.webservices.platform.core_2022_2.SearchResult;
import com.netsuite.webservices.platform_2022_2.NetSuitePortType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TestPortSingleton {

    @Resource
    private NetsuiteConfigFeignService netsuiteConfigFeignService;

    public String getCustomerSearchAdvanced() throws Exception{
        String ret = "";

        AccountDetails acct = new AccountDetails();
        acct.accountId = netsuiteConfigFeignService.getAccountId();
        acct.consumerKey = netsuiteConfigFeignService.getConsumerKey();
        acct.consumerSecret = netsuiteConfigFeignService.getConsumerSecret();
        acct.netsuiteToken = netsuiteConfigFeignService.getNetsuiteToken();
        acct.netsuiteSecret = netsuiteConfigFeignService.getNetsuiteSecret();
        NetSuitePortType port = (new NetsuiteServiceManager(acct)).getPort();

        CustomerSearchAdvanced customerSearchAdvanced = new CustomerSearchAdvanced();
        customerSearchAdvanced.setSavedSearchId("5376359");
        SearchResult result = port.search(customerSearchAdvanced);
        System.out.println("Hello world");
        ret = result.toString();
        System.out.println(ret);
        System.out.println("Hello world");
        return ret;
    }
}
