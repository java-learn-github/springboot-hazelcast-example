package com.example.springcache.hazelcast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hazelcast")
public class CacheController {

    Logger logger = LoggerFactory.getLogger(CacheController.class);

    @GetMapping("/getcache")
    @Cacheable(value = "createCache", key = "#id")
    //value contains name of cache map storing cache
    //#id indicates that cache will be checked with id with each request, if not provided then it will consider all the values passed in the method argument
    public String getCaches(@RequestHeader String id) throws InterruptedException {
        logger.info("getCache enter");
        //insert service call/ business logic here
        Thread.sleep(5000);
        logger.info("getCache exit");
        return "Cache Created Successfully";
    }
}
