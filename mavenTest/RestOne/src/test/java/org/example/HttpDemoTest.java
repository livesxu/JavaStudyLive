package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpDemoTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void demoOne() {

        DemoOneModel model =  restTemplate.getForObject("http://localhost:8888/mybt/5",DemoOneModel.class);

        System.out.println(model);
    }

    @Test
    public void demoOneAll() {

        DemoOneModel[] models = restTemplate.getForObject("http://localhost:8888/mybt/findAll",DemoOneModel[].class);

        for (DemoOneModel m:
             models) {

            System.out.println(m);
        }
        System.out.println(models.length);
    }
}