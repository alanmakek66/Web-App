package com.bootcamp.demo_web_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StockHomePageDto {
  private String symbol;
  private String price;
  private String updatetime;
  private String chart;
  
}
