package com.xl.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-producers")
public interface SchedualServieHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String syaHi();
}
