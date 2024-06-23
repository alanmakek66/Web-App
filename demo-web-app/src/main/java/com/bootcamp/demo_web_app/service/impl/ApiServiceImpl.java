package com.bootcamp.demo_web_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_web_app.model.FiveMin005Dto;
import com.bootcamp.demo_web_app.model.FiveMin388Dto;
import com.bootcamp.demo_web_app.model.FiveMin700Dto;
import com.bootcamp.demo_web_app.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {
  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "https://dwtw4ns6vsnst.cloudfront.net")
  private String domain;


  @Override
  public FiveMin388Dto getFiveMin388Dto(){
    String path="/v1/388/data";
    String url= domain+path;
    FiveMin388Dto fiveMin388Dto=restTemplate.getForObject(url, FiveMin388Dto.class);
    return fiveMin388Dto;
    
  }
  public FiveMin700Dto getFiveMin700Dto(){
    String path="/v1/700/data";
    String url= domain+path;
    FiveMin700Dto fiveMin700Dto=restTemplate.getForObject(url, FiveMin700Dto.class);
    return fiveMin700Dto;

  }
  public FiveMin005Dto getFiveMin005Dto(){
    String path="/v1/005/data";
    String url= domain+path;
    FiveMin005Dto fiveMin005Dto=restTemplate.getForObject(url, FiveMin005Dto.class);
    return fiveMin005Dto;

  }
  
}
