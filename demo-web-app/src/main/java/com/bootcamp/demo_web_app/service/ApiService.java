package com.bootcamp.demo_web_app.service;

import com.bootcamp.demo_web_app.model.FiveMin005Dto;
import com.bootcamp.demo_web_app.model.FiveMin388Dto;
import com.bootcamp.demo_web_app.model.FiveMin700Dto;

public interface ApiService {
  FiveMin388Dto getFiveMin388Dto();
  FiveMin700Dto getFiveMin700Dto();
  FiveMin005Dto getFiveMin005Dto();
  
  
  
}
