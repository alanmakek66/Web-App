package com.bootcamp.demo_web_app.model.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_web_app.model.CandleHistoryData;
import com.bootcamp.demo_web_app.model.HistoryData;

@Component
public class CandleHistoryDataMapper {
  public CandleHistoryData map(HistoryData h1){
    return CandleHistoryData.builder()
    .high(Double.valueOf(h1.getHigh()))
    .low(Double.valueOf(h1.getLow()))
    .open(Double.valueOf(h1.getOpen()))
    .timestamp(Long.valueOf(h1.getTimestamp()))
    .close(Double.valueOf(h1.getClose()))
    .volume(Long.valueOf(h1.getVolume()))
    .build();
  }
  
}
