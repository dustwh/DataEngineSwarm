package com.luxbp.service;


import org.springframework.stereotype.Component;

/**
 * Hystrix service fallback
 * Decoupling fallback logic
 */

@Component
public class DeptHystrixFallBackService implements DeptHystrixService {
    @Override
    public String deptInfo_Ok(Integer id) {
        return "--------------------fall back in DeptHystrixFallBackService 1-----------------------";
    }

    @Override
    public String deptInfo_Timeout(Integer id) {
        return "--------------------fall back in DeptHystrixFallBackService 2-----------------------";
    }
}
