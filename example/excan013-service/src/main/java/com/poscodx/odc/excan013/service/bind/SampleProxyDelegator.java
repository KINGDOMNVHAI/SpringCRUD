package com.poscodx.odc.excan013.service.bind;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.poscdx.odc.excan013.domain.proxy.SampleProxyProxy;

@Service
@EnableFeignClients(basePackages = {"com.poscodx.odc"})
public class SampleProxyDelegator implements SampleProxyProxy {

}