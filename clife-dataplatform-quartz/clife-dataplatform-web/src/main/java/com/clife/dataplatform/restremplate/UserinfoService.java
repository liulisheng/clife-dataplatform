package com.clife.dataplatform.restremplate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "clife-dataplatform-business")
public interface UserinfoService {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    Object sayHiFromClientOne(@RequestParam(value = "id") Integer id);
}
