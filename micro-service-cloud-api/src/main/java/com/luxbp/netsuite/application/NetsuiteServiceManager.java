package com.luxbp.netsuite.application;

import com.netsuite.webservices.platform.core_2022_2.DataCenterUrls;
import com.netsuite.webservices.platform.core_2022_2.TokenPassport;
import com.netsuite.webservices.platform.core_2022_2.TokenPassportSignature;
import com.netsuite.webservices.platform.core_2022_2.types.SignatureAlgorithm;
import com.netsuite.webservices.platform_2022_2.NetSuiteBindingStub;
import com.netsuite.webservices.platform_2022_2.NetSuitePortType;
import com.netsuite.webservices.platform_2022_2.NetSuiteServiceLocator;
import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URL;

public class NetsuiteServiceManager {
    protected NetSuiteServiceLocator service;
    protected NetSuitePortType port;
    protected AccountDetails account;

    /**
     * Initializes the netsuite session
     *
     * @throws Exception
     */
    public NetsuiteServiceManager(AccountDetails account) throws Exception {
        this.account = account;

        service = new NetSuiteServiceLocator();
        service.setMaintainSession(true);

        this.port = createPort(account.accountId, new URL(service.getNetSuitePortAddress()));
        // Setting the token on the port
        NetSuiteBindingStub stub = ((NetSuiteBindingStub) this.port);
        stub.clearHeaders();
        stub.setHeader(
                String.format("urn:messages_%s.platform.webservices.netsuite.com", account.version),
                "tokenPassport",
                createPassport(account)
        );
    }

    public NetSuitePortType getPort() {
        return this.port;
    }

    protected TokenPassport createPassport(AccountDetails account) throws Exception {

        String nonce = RandomStringUtils.randomAlphanumeric(20);
        long timeStamp = System.currentTimeMillis() / 1000L;

        String signature = computeSignature(
                account.accountId,
                account.consumerKey,
                account.consumerSecret,
                account.netsuiteToken,
                account.netsuiteSecret,
                nonce,
                timeStamp);


        TokenPassportSignature sig = new TokenPassportSignature(signature);
        sig.setAlgorithm(SignatureAlgorithm._HMAC_SHA256);

        return new TokenPassport(
                account.accountId,
                account.consumerKey,
                account.netsuiteToken,
                nonce, // nonce
                timeStamp, // timestamp
                sig
        );
    }

    protected NetSuitePortType createPort(String account, URL defaultWsDomainURL) {
        try {
            NetSuitePortType _port = service.getNetSuitePort(defaultWsDomainURL);
            // Get the webservices domain for your account
            DataCenterUrls urls = _port.getDataCenterUrls(account).getDataCenterUrls();
            String wsDomain = urls.getWebservicesDomain();
            // Return URL appropriate for the specific account
            return service.getNetSuitePort(new URL(wsDomain.concat(defaultWsDomainURL.getPath())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String computeShaHash(String baseString, String key, String algorithm) throws Exception {

        byte[] bytes = key.getBytes();
        SecretKeySpec mySigningKey = new SecretKeySpec(bytes, algorithm);

        Mac messageAuthenticationCode = Mac.getInstance(algorithm);

        messageAuthenticationCode.init(mySigningKey);

        byte[] hash = messageAuthenticationCode.doFinal(baseString.getBytes());

        return new String(java.util.Base64.getEncoder().encode(hash));
    }

    protected String computeSignature(
            String account,
            String consumerKey,
            String consumerSecret,
            String token,
            String tokenSecret,
            String nonce,
            Long timeStamp
    ) throws Exception {
        String baseString = account + "&" + consumerKey + "&" + token + "&" + nonce + "&" + timeStamp;

        String key = consumerSecret + '&' + tokenSecret;

        return computeShaHash(baseString, key, "HmacSHA256");
    }
}
