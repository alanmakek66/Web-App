package com.bootcamp.demo_web_app.dto.mapper;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_web_app.dto.WeeklyCandleHistoryData;
import com.bootcamp.demo_web_app.holiday.Holiday;
import com.bootcamp.demo_web_app.model.CandleHistoryData;

@Component
public class WeeklyCandleHistoryDataMapper {

  private static Holiday h1;

  public List<WeeklyCandleHistoryData> map(List<CandleHistoryData> c1){

    List<WeeklyCandleHistoryData> weeklyData = new ArrayList<>();
    WeeklyCandleHistoryData currentWeek = null;

        for (CandleHistoryData daily : c1) {
            LocalDate date = LocalDate.ofEpochDay(daily.getTimestamp() / 1000 / 86400);
            if (h1.isWeekStart(date)) {
                if (currentWeek != null) {
                    weeklyData.add(currentWeek);
                }
                currentWeek = new WeeklyCandleHistoryData();
                currentWeek.setWtimestamp((date.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000));
            }

            if (h1.isHoliday(date)) {
                continue;
            }

            currentWeek.setWopen(daily.getOpen());
            currentWeek.setWhigh(Math.max(currentWeek.getWhigh(), daily.getHigh()));
            currentWeek.setWlow(currentWeek.getWlow() == 0 ? daily.getLow() : Math.min(currentWeek.getWlow(), daily.getLow()));
            currentWeek.setWclose(daily.getClose());
            currentWeek.setWvolume(currentWeek.getWvolume() + daily.getVolume());
        }

        if (currentWeek != null) {
            weeklyData.add(currentWeek);
        }

        return weeklyData;
  
}
}
