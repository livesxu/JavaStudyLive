package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HttpDemo {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("demoOne")
    public void demoOne() {

        DemoOneModel model = restTemplate.getForObject("http://localhost:8888/mybt/findOne",DemoOneModel.class);

        System.out.println(model);
    }
}
