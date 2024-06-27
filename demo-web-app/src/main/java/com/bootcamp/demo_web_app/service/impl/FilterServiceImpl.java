package com.bootcamp.demo_web_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bootcamp.demo_web_app.model.CandleHistoryData;
import com.bootcamp.demo_web_app.service.FilterService;

@Service
public class FilterServiceImpl implements FilterService {

  @Override
  public List<CandleHistoryData> filter(List<CandleHistoryData> c1){
    
 return c1.stream()
 .sorted((c, d) -> Long.compare(c.getTimestamp(), d.getTimestamp()))
 .skip(c1.size() - 365)
 .collect(Collectors.toList());
  }

  @Override
  public List<CandleHistoryData> reOrder(List<CandleHistoryData> c1){
    return c1.stream()
 .sorted((c, d) -> Long.compare(c.getTimestamp(), d.getTimestamp()))
 
 .collect(Collectors.toList());

  }
  
}
