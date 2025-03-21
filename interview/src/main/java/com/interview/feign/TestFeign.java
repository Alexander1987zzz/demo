package com.interview.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "testFeign", url = "localhost:8082")
public interface TestFeign {

    @PostMapping(
            consumes = {"application/x-www-form-urlencoded"}
    )
    String getUnits(@RequestBody MultiValueMap<String, ?> form);

}
