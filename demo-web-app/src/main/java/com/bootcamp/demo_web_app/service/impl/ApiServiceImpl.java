package com.bootcamp.demo_web_app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_web_app.model.FiveMin005Dto;
import com.bootcamp.demo_web_app.model.FiveMin388Dto;
import com.bootcamp.demo_web_app.model.FiveMin700Dto;
import com.bootcamp.demo_web_app.model.HistoryData;
import com.bootcamp.demo_web_app.model2.Latestprice;
import com.bootcamp.demo_web_app.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {
  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "https://dwtw4ns6vsnst.cloudfront.net")
  private String domainaws;

  @Value(value = "http://localhost:8080")
  private String localhost;


  @Override
  public FiveMin388Dto getFiveMin388Dto(){
    String path="/v1/388/data";
    String url= localhost+path;
    FiveMin388Dto fiveMin388Dto=restTemplate.getForObject(url, FiveMin388Dto.class);
    return fiveMin388Dto;
    
  }
  @Override
  public FiveMin700Dto getFiveMin700Dto(){
    String path="/v1/700/data";
    String url= localhost+path;
    FiveMin700Dto fiveMin700Dto=restTemplate.getForObject(url, FiveMin700Dto.class);
    return fiveMin700Dto;

  }
  @Override
  public FiveMin005Dto getFiveMin005Dto(){
    String path="/v1/005/data";
    String url= localhost+path;
    FiveMin005Dto fiveMin005Dto=restTemplate.getForObject(url, FiveMin005Dto.class);
    return fiveMin005Dto;

  }

  @Override
  public List<HistoryData> getHistoryDate388(){
    String path="/histroy/data/388";
    String url=localhost+path;

    HistoryData[] h1=restTemplate.getForObject(url,HistoryData[].class);

    return  Arrays.asList(h1);

  }
  @Override
  public List<HistoryData> getHistoryDate700(){
    String path="/histroy/data/700";
    String url=localhost+path;

    HistoryData[] h1=restTemplate.getForObject(url,HistoryData[].class);

    return  Arrays.asList(h1);

  }
  @Override
  public List<HistoryData> getHistoryDate005(){
    String path="/histroy/data/005";
    String url=localhost+path;

    HistoryData[] h1=restTemplate.getForObject(url,HistoryData[].class);

    return   Arrays.asList(h1);

  }
  @Override
  public Latestprice getLatest388(){
    String path="/latest388";
    String url=localhost+path;
    
    Latestprice L1=restTemplate.getForObject(url,Latestprice.class);
    return L1;

  }

  @Override
  public Latestprice getLatest700(){
    String path="/latest700";
    String url=localhost+path;
    
    Latestprice L1=restTemplate.getForObject(url,Latestprice.class);
    return L1;

  }
  @Override
  public Latestprice getLatest005(){
    String path="/latest005";
    String url=localhost+path;
    
    Latestprice L1=restTemplate.getForObject(url,Latestprice.class);
    return L1;

  }

  
}
