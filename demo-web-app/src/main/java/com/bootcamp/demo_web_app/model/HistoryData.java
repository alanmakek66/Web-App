package com.bootcamp.demo_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class HistoryData {
  private String timestamp;
  
  private String open;
  private String high;
  private String low;
  private String close;
  private String volume;
  
}
