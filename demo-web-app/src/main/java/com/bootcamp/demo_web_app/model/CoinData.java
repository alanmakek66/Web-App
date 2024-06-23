package com.bootcamp.demo_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoinData {
  private String id;
  //private String symbol;
  //private String name;
  private String image;
  private String current_price;
  
}
