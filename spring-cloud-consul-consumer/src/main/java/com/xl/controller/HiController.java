package com.xl.controller;

import com.xl.service.IHiService;
import jdk.internal.dynalink.support.AutoDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {
    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IHiService hiService;

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("consul-miya");
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @RequestMapping("/discover")
    public Object discover() {

        return loadBalancer.choose("consul-miya").getUri().toString();
    }

    @RequestMapping("/call")
    public String call(){
        ServiceInstance serviceInstance = loadBalancer.choose("consul-miya");
        String call = new RestTemplate().getForObject(serviceInstance.getUri().toString()+"/hi",String.class);
        return call;
    }

    /***
     * fegin 调用服务
     * @return
     */
    @RequestMapping("/callable")
    public String callable(){
       return hiService.call();
    }
}
