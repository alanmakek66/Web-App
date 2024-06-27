package com.bootcamp.demo_web_app.controller.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_web_app.controller.StockPriceOperation;
import com.bootcamp.demo_web_app.dto.LatestpriceDto;
import com.bootcamp.demo_web_app.dto.StockHomePageDto;
import com.bootcamp.demo_web_app.dto.WeeklyCandleHistoryData;
import com.bootcamp.demo_web_app.dto.mapper.LatestpriceDtoMapper;
import com.bootcamp.demo_web_app.dto.mapper.StockHomePageDtoMapper;
import com.bootcamp.demo_web_app.dto.mapper.StockPriceMapper;
import com.bootcamp.demo_web_app.dto.mapper.WeeklyCandleHistoryDataMapper;
import com.bootcamp.demo_web_app.model.CandleHistoryData;
import com.bootcamp.demo_web_app.model.StockPrice;
import com.bootcamp.demo_web_app.model.mapper.CandleHistoryDataMapper;
import com.bootcamp.demo_web_app.service.ApiService;
import com.bootcamp.demo_web_app.service.FilterService;

@RestController
public class StockPriceController implements StockPriceOperation {

  @Autowired
  private ApiService apiService;

  @Autowired
  private StockPriceMapper stockPriceMapper;

  @Autowired
  private StockHomePageDtoMapper stockHomePageDtoMapper;

  @Autowired
  private CandleHistoryDataMapper candleHistoryDataMapper;

  @Autowired
  private LatestpriceDtoMapper latestpriceDtoMapper;
  @Autowired
  private FilterService filterService;

  @Autowired
  private WeeklyCandleHistoryDataMapper weeklyCandleHistoryDataMapper;

  @Override
  public List<StockPrice> test() {
    return Arrays.asList( //
        new StockPrice(2024, 6, 27, 9, 0, 150.0), //
        new StockPrice(2024, 6, 27, 9, 5, 151.0), //
        new StockPrice(2024, 6, 27, 9, 10, 152.0), //
        new StockPrice(2024, 6, 27, 9, 15, 153.0), //
        new StockPrice(2024, 6, 27, 9, 20, 154.0), //
        new StockPrice(2024, 6, 27, 9, 25, 155.0), //
        new StockPrice(2024, 6, 27, 9, 30, 156.0), //
        new StockPrice(2024, 6, 27, 9, 35, 157.0), //
        new StockPrice(2024, 6, 27, 9, 40, 158.0), //
        new StockPrice(2024, 6, 27, 9, 45, 159.0), //
        new StockPrice(2024, 6, 27, 9, 50, 159.0), //
        new StockPrice(2024, 6, 27, 9, 55, 159.0)//

    );

  }

  @Override
  public List<StockPrice> chart388fivemins() {
    return apiService.getFiveMin388Dto().getFiveMin388().getData1Dtos()
        .stream().map(e -> stockPriceMapper.map(e)).collect(Collectors.toList());

  }

  @Override
  public List<StockPrice> chart700fivemins() {
    return apiService.getFiveMin700Dto().getFiveMin700().getData1Dtos()
        .stream().map(e -> stockPriceMapper.map(e)).collect(Collectors.toList());

  }

  @Override
  public List<StockPrice> chart005fivemins() {
    return apiService.getFiveMin005Dto().getFiveMin005().getData1Dtos()
        .stream().map(e -> stockPriceMapper.map(e)).collect(Collectors.toList());

  }

  @Override
  public List<StockHomePageDto> stockhomepagedto() {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm[:ss]");

    List<StockHomePageDto> list1 = apiService.getFiveMin005Dto().getFiveMin005().getData1Dtos()
        .stream().map(e -> stockHomePageDtoMapper.map(e)).collect(Collectors.toList());
    StockHomePageDto lastest005 = list1.stream()
        .max((obj1, obj2) -> LocalDateTime.parse(obj1.getUpdatetime(), formatter)
            .compareTo(LocalDateTime.parse(obj2.getUpdatetime(), formatter)))
        .orElse(null);

    List<StockHomePageDto> list2 = apiService.getFiveMin388Dto().getFiveMin388().getData1Dtos()
        .stream().map(e -> stockHomePageDtoMapper.map(e)).collect(Collectors.toList());
    StockHomePageDto lastest388 = list2.stream()
        .max((obj1, obj2) -> LocalDateTime.parse(obj1.getUpdatetime(), formatter)
            .compareTo(LocalDateTime.parse(obj2.getUpdatetime(), formatter)))
        .orElse(null);

    List<StockHomePageDto> list3 = apiService.getFiveMin700Dto().getFiveMin700().getData1Dtos()
        .stream().map(e -> stockHomePageDtoMapper.map(e)).collect(Collectors.toList());
    StockHomePageDto lastest700 = list3.stream()
        .max((obj1, obj2) -> LocalDateTime.parse(obj1.getUpdatetime(), formatter)
            .compareTo(LocalDateTime.parse(obj2.getUpdatetime(), formatter)))
        .orElse(null);

    List<StockHomePageDto> stockHomePageDtos = new ArrayList<>(List.of(lastest005, lastest388, lastest700));

    return stockHomePageDtos;

  }

  @Override
  public List<CandleHistoryData> candle388() {
    return filterService.filter(apiService.getHistoryDate388().stream()
        .map(e -> candleHistoryDataMapper.map(e)).collect(Collectors.toList()));

  }

  @Override
  public List<CandleHistoryData> candle700() {
    return filterService.filter(apiService.getHistoryDate700().stream()
        .map(e -> candleHistoryDataMapper.map(e)).collect(Collectors.toList()));
  }

  @Override
  public List<CandleHistoryData> candle005() {
    return filterService.filter(apiService.getHistoryDate005().stream()
        .map(e -> candleHistoryDataMapper.map(e)).collect(Collectors.toList()));

  }

  @Override
  public LatestpriceDto askbid388() {

    return latestpriceDtoMapper.map(apiService.getLatest388());
  }

  @Override
  public LatestpriceDto askbid005() {
    return latestpriceDtoMapper.map(apiService.getLatest005());
  }

  @Override
  public LatestpriceDto askbid700() {
    return latestpriceDtoMapper.map(apiService.getLatest700());
  }

  @Override
  public List<CandleHistoryData> weekly005() {

    return filterService
        .reOrder(apiService.getHistoryDate005().stream()
            .map(e -> candleHistoryDataMapper.map(e)).collect(Collectors.toList()));

  }
  @Override
  public List<CandleHistoryData> weekly700() {

    return filterService
        .reOrder(apiService.getHistoryDate700().stream()
            .map(e -> candleHistoryDataMapper.map(e)).collect(Collectors.toList()));

  }
  @Override
  public List<CandleHistoryData> weekly388() {

    return filterService
        .reOrder(apiService.getHistoryDate388().stream()
            .map(e -> candleHistoryDataMapper.map(e)).collect(Collectors.toList()));

  }

}
