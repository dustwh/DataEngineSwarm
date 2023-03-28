package com.luxbp.service;

public interface DeptService {
    // hystrix normal case
    public String deptInfo_Ok(Integer id);
    //hystrix time out case
    public String deptInfo_Timeout(Integer id);

    // Hystrix Circuit Breaker
    public String deptCircuitBreaker(Integer id);
}