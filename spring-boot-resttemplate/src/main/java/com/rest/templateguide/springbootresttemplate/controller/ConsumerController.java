package com.rest.templateguide.springbootresttemplate.controller;

import com.rest.templateguide.springbootresttemplate.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    //consuming GET API using restTemplate...
    @RequestMapping(value = "/rest-template/products")
    public String getProductList() {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

        return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
    }


    @RequestMapping(value = "/template/add/product", method = RequestMethod.POST)
    public String createProducts(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);

        return restTemplate.exchange(
                "http://localhost:8080/add/product", HttpMethod.POST, entity, String.class).getBody();
    }
}
