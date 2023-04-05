package com.luxbp.service.netsuite;

import com.luxbp.service.openfeign.NetsuiteConfigFeignService;
import com.netsuite.webservices.lists.relationships_2022_2.CustomerSearchAdvanced;
import com.netsuite.webservices.platform.core_2022_2.SearchResult;
import com.netsuite.webservices.platform_2022_2.NetSuitePortType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@RefreshScope
@Component
public class TestPortSingleton {
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

    @Resource
    private NetsuiteConfigFeignService netsuiteConfigFeignService;

    public String getCustomerSearchAdvanced() throws Exception{
        System.out.println(configInfo);
        System.out.println(configVersion);
        System.out.println(accountId);
        System.out.println(consumerKey);
        System.out.println(consumerSecret);
        System.out.println(netsuiteToken);
        System.out.println(netsuiteSecret);
        String ret = "";
        AccountDetails acct = new AccountDetails();
//        System.out.println(netsuiteConfigFeignService.getAccountId());//
//        acct.accountId = netsuiteConfigFeignService.getAccountId();
//        acct.consumerKey = netsuiteConfigFeignService.getConsumerKey();
//        acct.consumerSecret = netsuiteConfigFeignService.getConsumerSecret();
//        acct.netsuiteToken = netsuiteConfigFeignService.getNetsuiteToken();
//        acct.netsuiteSecret = netsuiteConfigFeignService.getNetsuiteSecret();

        System.out.println(accountId);//
        acct.accountId = accountId;
        acct.consumerKey = consumerKey;
        acct.consumerSecret = consumerSecret;
        acct.netsuiteToken = netsuiteToken;
        acct.netsuiteSecret = netsuiteSecret;

        NetSuitePortType port = (new NetsuiteServiceManager(acct)).getPort();

        CustomerSearchAdvanced customerSearchAdvanced = new CustomerSearchAdvanced();
        customerSearchAdvanced.setSavedSearchId("5376359");
        SearchResult result = port.search(customerSearchAdvanced);
        System.out.println("Hello world");//
        ret = result.toString();
        System.out.println(ret);//
        System.out.println("Hello world");//
        return ret;
    }
}
