//package com.luxbp.service.openfeign;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Component
//@FeignClient(value = "SPRING-CLOUD-CONFIG-CLIENT")
//public interface NetsuiteConfigFeignService {
//    @RequestMapping(value = "/getAccountId", method = RequestMethod.GET)
//    public String getAccountId();
//
//    @RequestMapping(value = "/getConsumerKey", method = RequestMethod.GET)
//    public String getConsumerKey();
//
//    @RequestMapping(value = "/getConsumerSecret", method = RequestMethod.GET)
//    public String getConsumerSecret();
//
//    @RequestMapping(value = "/getNetsuiteToken", method = RequestMethod.GET)
//    public String getNetsuiteToken();
//
//    @RequestMapping(value = "/getNetsuiteSecret", method = RequestMethod.GET)
//    public String getNetsuiteSecret();
//}
