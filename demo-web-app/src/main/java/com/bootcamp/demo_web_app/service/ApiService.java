package com.bootcamp.demo_web_app.service;

import java.util.List;

import com.bootcamp.demo_web_app.model.FiveMin005Dto;
import com.bootcamp.demo_web_app.model.FiveMin388Dto;
import com.bootcamp.demo_web_app.model.FiveMin700Dto;
import com.bootcamp.demo_web_app.model.HistoryData;
import com.bootcamp.demo_web_app.model2.Latestprice;

public interface ApiService {
  FiveMin388Dto getFiveMin388Dto();
  FiveMin700Dto getFiveMin700Dto();
  FiveMin005Dto getFiveMin005Dto();

  List<HistoryData> getHistoryDate388();
  List<HistoryData> getHistoryDate700();
  List<HistoryData> getHistoryDate005();

  Latestprice getLatest388();
  Latestprice getLatest700();
  Latestprice getLatest005();





  
  
  
  
}
