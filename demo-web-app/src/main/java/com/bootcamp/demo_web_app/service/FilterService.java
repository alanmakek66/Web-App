package com.bootcamp.demo_web_app.service;

import java.util.List;

import com.bootcamp.demo_web_app.model.CandleHistoryData;

public interface FilterService {
  List<CandleHistoryData> filter(List<CandleHistoryData> c1);

  List<CandleHistoryData> reOrder(List<CandleHistoryData> c1);
  
}
