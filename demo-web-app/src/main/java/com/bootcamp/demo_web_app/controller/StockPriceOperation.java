package com.bootcamp.demo_web_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_web_app.dto.LatestpriceDto;
import com.bootcamp.demo_web_app.dto.StockHomePageDto;
import com.bootcamp.demo_web_app.dto.WeeklyCandleHistoryData;
import com.bootcamp.demo_web_app.model.CandleHistoryData;
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

  @GetMapping(value = "/candle/388")
  List<CandleHistoryData> candle388();

  @GetMapping(value = "/candle/700")
  List<CandleHistoryData> candle700();

  @GetMapping(value = "/candle/005")
  List<CandleHistoryData> candle005();

  @GetMapping(value = "/askbid/388")
  LatestpriceDto askbid388();
  @GetMapping(value = "/askbid/005")
  LatestpriceDto askbid005();
  @GetMapping(value = "/askbid/700")
  LatestpriceDto askbid700();

  @GetMapping(value = "/weekly/005")
  List<CandleHistoryData> weekly005();
  @GetMapping(value = "/weekly/388")
  List<CandleHistoryData> weekly388();
  @GetMapping(value = "/weekly/700")
  List<CandleHistoryData> weekly700();

  

  
  
}
