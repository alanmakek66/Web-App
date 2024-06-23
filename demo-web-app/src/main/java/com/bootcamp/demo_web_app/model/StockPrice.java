package com.bootcamp.demo_web_app.model;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice {
  private String timestamp;
  private double price;

  public StockPrice(int year, int month, int day, int hour, int minute,
      double price) {
    this.timestamp = LocalDateTime.of(year, month, month, hour, minute, minute) //
        .atZone(ZoneId.of("Asia/Hong_Kong")) //
        .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    System.out.println(timestamp);
    this.price = price;
  }

  public StockPrice(LocalDateTime timestamp, double price) {
    this.timestamp = timestamp.atZone(ZoneId.of("Asia/Hong_Kong"))
        .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    this.price = price;
  }
  
}
