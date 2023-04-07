package com.luxbp.service.netsuite;

import com.netsuite.webservices.lists.relationships_2022_2.CustomerSearchAdvanced;
import com.netsuite.webservices.platform.core_2022_2.SearchResult;
import com.netsuite.webservices.platform_2022_2.NetSuitePortType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class TestPortSingleton {

    //config info from config server, and pass value to local var
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

    public String getCustomerSearchAdvanced() throws Exception{

        System.out.println(configVersion);

        String ret = "";
        //construct account
        AccountDetails acct = new AccountDetails();

        acct.accountId = accountId;
        acct.consumerKey = consumerKey;
        acct.consumerSecret = consumerSecret;
        acct.netsuiteToken = netsuiteToken;
        acct.netsuiteSecret = netsuiteSecret;

        NetSuitePortType port = (new NetsuiteServiceManager(acct)).getPort();

        CustomerSearchAdvanced customerSearchAdvanced = new CustomerSearchAdvanced();
        customerSearchAdvanced.setSavedSearchId("5376359");
        SearchResult result = port.search(customerSearchAdvanced);

        ret = result.toString();
        return ret;
    }
}
