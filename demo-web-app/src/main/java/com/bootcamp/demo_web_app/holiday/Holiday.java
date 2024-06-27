package com.bootcamp.demo_web_app.holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Holiday {
  private List<LocalDate> holiday2024List;

  public Holiday() {
    this.holiday2024List = new ArrayList<>(List.of(LocalDate.of(2024, 1, 1),
        LocalDate.of(2024, 1, 22),
        LocalDate.of(2024, 1, 23),
        LocalDate.of(2024, 1, 24),
        LocalDate.of(2024, 1, 25),
        LocalDate.of(2024, 4, 5),
        LocalDate.of(2024, 5, 1),
        LocalDate.of(2024, 5, 13),
        LocalDate.of(2024, 6, 19),
        LocalDate.of(2024, 7, 1),
        LocalDate.of(2024, 9, 16),
        LocalDate.of(2024, 10, 1),
        LocalDate.of(2024, 10, 2),
        LocalDate.of(2024, 10, 10),

        LocalDate.of(2023, 1, 1),
        LocalDate.of(2023, 1, 22), LocalDate.of(2023, 1, 23),
        LocalDate.of(2023, 1, 24),
        LocalDate.of(2023, 4, 5),
        LocalDate.of(2023, 5, 1),
        LocalDate.of(2023, 5, 28),
        LocalDate.of(2023, 6, 22),
        LocalDate.of(2023, 7, 1),
        LocalDate.of(2023, 9, 29),
        LocalDate.of(2023, 10, 1),
        LocalDate.of(2023, 10, 23),
        LocalDate.of(2023, 12, 25),
        LocalDate.of(2023, 12, 26),

        LocalDate.of(2022, 1, 1),
        LocalDate.of(2022, 1, 31), LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 2),
        LocalDate.of(2022, 4, 5),
        LocalDate.of(2022, 5, 1),
        LocalDate.of(2022, 5, 8),
        LocalDate.of(2022, 6, 3),
        LocalDate.of(2022, 7, 1),
        LocalDate.of(2022, 9, 10),
        LocalDate.of(2022, 10, 1),
        LocalDate.of(2022, 10, 4),
        LocalDate.of(2022, 12, 25),
        LocalDate.of(2022, 12, 26),

        LocalDate.of(2021, 1, 1),
        LocalDate.of(2021, 2, 12), LocalDate.of(2021, 2, 13), LocalDate.of(2021, 2, 14),
        LocalDate.of(2021, 4, 5),
        LocalDate.of(2021, 5, 1),
        LocalDate.of(2021, 5, 19),
        LocalDate.of(2021, 6, 14),
        LocalDate.of(2021, 7, 1),
        LocalDate.of(2021, 9, 21),
        LocalDate.of(2021, 10, 1),
        LocalDate.of(2021, 10, 14),
        LocalDate.of(2021, 12, 25),
        LocalDate.of(2021, 12, 26),

        LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 25), LocalDate.of(2020, 1, 26), LocalDate.of(2020, 1, 27),
        LocalDate.of(2020, 4, 4),
        LocalDate.of(2020, 5, 1),
        LocalDate.of(2020, 5, 30),
        LocalDate.of(2020, 6, 25),
        LocalDate.of(2020, 7, 1),
        LocalDate.of(2020, 10, 1),
        LocalDate.of(2020, 10, 1),
        LocalDate.of(2020, 10, 25),
        LocalDate.of(2020, 12, 25),
        LocalDate.of(2020, 12, 26)

    ));
  }

  public boolean isHoliday(LocalDate date) {
    if (this.holiday2024List.contains(date)) {
      return true;
    }

    DayOfWeek dayOfWeek = date.getDayOfWeek();
    return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
  }

  public boolean isWeekStart(LocalDate date) {
    return date.getDayOfWeek() == DayOfWeek.MONDAY;
}



  public LocalDate getPreviousWorkingDay(LocalDate date) {
    LocalDate prevDate = date.minusDays(1);
    while (this.isHoliday(prevDate) || prevDate.getDayOfWeek() == DayOfWeek.SATURDAY
        || prevDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
      prevDate = prevDate.minusDays(1);
    }
    return prevDate;
  }

}
