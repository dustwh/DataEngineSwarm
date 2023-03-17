package com.luxbp.netsuite.application;

import lombok.Getter;
import lombok.Setter;

public class AccountDetails {

    @Setter
    @Getter
    public String accountId;

    @Setter
    @Getter
    public String consumerKey;

    @Setter
    @Getter
    public String consumerSecret;

    @Setter
    @Getter
    public String netsuiteToken;

    @Setter
    @Getter
    public String netsuiteSecret;

    @Setter
    @Getter
    public String algorithm = "HmacSHA256";

    @Setter
    @Getter
    public String version = "2022_2";

    public void AccountDetails(String accountId, String consumerKey, String consumerSecret, String netsuiteToken, String netsuiteSecret) {
        this.accountId = accountId;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.netsuiteToken = netsuiteToken;
        this.netsuiteSecret = netsuiteSecret;
    }
}
