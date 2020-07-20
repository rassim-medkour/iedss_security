package com.auth.jwt.iedss.iedss_security.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-notification-cache", url = "localhost:9003")
public interface MicroserviceNotificationCache {

}
