package com.luxbp.netsuite.application;

import com.netsuite.webservices.lists.relationships_2022_2.CustomerSearchAdvanced;
import com.netsuite.webservices.platform.core_2022_2.SearchResult;
import com.netsuite.webservices.platform_2022_2.NetSuitePortType;

public class TestPortSingleton {

    public String met() throws Exception{
        String ret = "";

        AccountDetails acct = new AccountDetails();
        acct.accountId = "736951";
        acct.consumerKey = "86903cdce578fe265f7a3c96a4df7152fb0c9b439d275914a751645bf12b3db4";
        acct.consumerSecret = "dd8aafdcd0bdb2c1838db237d0c95a85199a9b8fc347502e124f888ca429687c";
        acct.netsuiteToken = "aacf088013fe63163d1eddcc56ea3ec214c083fa2672a6949787eeb713ba3afb";
        acct.netsuiteSecret = "0c879ca38f56f7c7914a57595c20ac4f92cb59f82c921dd3a80fa1b73902f7d6";
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
