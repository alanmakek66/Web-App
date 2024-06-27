package com.bootcamp.demo_web_app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CandleHistoryData {
   
    private long timestamp;
    
    private double open;
   
    private double high;
   
    private double low;
    
    private double close;
    
    private long volume;

    public static long getEarliestTimestamp(List<CandleHistoryData> data) {
        return data.stream()
                    .mapToLong(CandleHistoryData::getTimestamp)
                    .min()
                    .orElse(0L);
    }

    public static long getLatestTimestamp(List<CandleHistoryData> data) {
        return data.stream()
                    .mapToLong(CandleHistoryData::getTimestamp)
                    .max()
                    .orElse(0L);
    }
  
}
