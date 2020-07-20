package com.auth.jwt.iedss.iedss_security.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-user-services", url = "localhost:9002")
public interface MicroserviceUserServices {

}
