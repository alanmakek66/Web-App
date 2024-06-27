package com.bootcamp.demo_web_app.dto.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_web_app.dto.LatestpriceDto;
import com.bootcamp.demo_web_app.model2.Latestprice;

@Component
public class LatestpriceDtoMapper {

  public LatestpriceDto map(Latestprice l1){



    return LatestpriceDto.builder()
    .ask(Double.valueOf(l1.getAsk()))
    .bid(Double.valueOf(l1.getBid()))
    .build();

  }
  
}
