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
public class WeeklyCandleHistoryData {
  private long wtimestamp;
    
    private double wopen;
   
    private double whigh;
   
    private double wlow;
    
    private double wclose;
    
    private long wvolume;
  
}
