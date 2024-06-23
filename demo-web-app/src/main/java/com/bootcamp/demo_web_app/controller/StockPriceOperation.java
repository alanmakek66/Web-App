package com.bootcamp.demo_web_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_web_app.dto.StockHomePageDto;
import com.bootcamp.demo_web_app.model.StockPrice;



public interface StockPriceOperation {

  @GetMapping(value = "/five-minute-hardcode")
  List<StockPrice> test();

  @GetMapping(value = "/five-minute-388")
  List<StockPrice> chart388fivemins();

  @GetMapping(value = "/five-minute-700")
  List<StockPrice> chart700fivemins();

  @GetMapping(value = "/five-minute-005")
  List<StockPrice> chart005fivemins();

  @GetMapping(value = "/stock/homepage/data")
  List<StockHomePageDto> stockhomepagedto();
  
}
