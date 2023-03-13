package com.luxbp.service.impl;

import com.luxbp.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String info) {
        return "from remote:" + info;
    }
}
