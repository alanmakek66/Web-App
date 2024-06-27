package com.bootcamp.demo_web_app.dto.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_web_app.model.Data1Dto;
import com.bootcamp.demo_web_app.model.StockPrice;

@Component
public class StockPriceMapper {
  
  public StockPrice map(Data1Dto d1){
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm[:ss]");
    LocalDateTime ddd=LocalDateTime.parse(d1.getMarkTime(),formatter);
    
    int year=ddd.getYear();
    int month=ddd.getMonthValue();
    int day=ddd.getDayOfMonth();
    int hour=ddd.getHour();
    int minute=ddd.getMinute();
    double price=Double.valueOf(d1.getRegularMarketPrice());
    
 return new StockPrice(year, month, day, hour, minute, price);

  }
  
}
