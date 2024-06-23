package com.bootcamp.demo_web_app.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_web_app.dto.StockHomePageDto;
import com.bootcamp.demo_web_app.model.Data1Dto;

@Component
public class StockHomePageDtoMapper {

  public StockHomePageDto map(Data1Dto d1){
    return StockHomePageDto.builder()
    .symbol(d1.getSymbol())
    .price(d1.getRegularMarketPrice())
    .updatetime(d1.getMarkTime())
    .chart("Enter to Chart Page")
    .build();
  }
  
}
