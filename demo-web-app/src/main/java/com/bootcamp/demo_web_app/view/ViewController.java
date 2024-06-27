package com.bootcamp.demo_web_app.view;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_web_app.controller.impl.StockPriceController;
import com.bootcamp.demo_web_app.dto.StockHomePageDto;

@Controller
public class ViewController {
  @Autowired
  private StockPriceController stockPriceController;

  @GetMapping("/test1")
    public String index() {
        return "index.html";
    }

  @GetMapping("/homepage")
  public String homepage(){
    return "homepage.html";
  }

  @GetMapping("/coinpage")
  public String coinpage(){
    return "coinpage.html";
  }
  @GetMapping("/stockpage")
  public String stockpage(Model model){
    List<StockHomePageDto> stockHomePageDtos=stockPriceController.stockhomepagedto();
    model.addAttribute("stockHomePageDtos", stockHomePageDtos);

    return "stockpage.html";
  }

  @GetMapping("/388/5min")
  public String fiveminOf388(){
    return "5minchartOf388.html";

  }

  @GetMapping("/700/5min")
  public String fiveminOf700(){
    return "5minchartOf700.html";

  }
  @GetMapping("/005/5min")
  public String fiveminOf005(){
    return "5minchartOf005.html";

  }

 @GetMapping("/candle/388/1day")
 public String candle388(){
  return "1daystickchartOf388.html";
 }
 @GetMapping("/candle/700/1day")
 public String candle700(){
  return "1daystickchartOf700.html";
 }
 @GetMapping("/candle/005/1day")
 public String candle005(){
  return "1daystickchartOf005.html";
 }

 @GetMapping("/ba")
 public String ba(){
  return "testindex.html";
 }

 @GetMapping("/candle/005/weekly")
 public String weeklycandle005(){
  return "weeklystickchartOf005";
 }
 @GetMapping("/candle/700/weekly")
 public String weeklycandle700(){
  return "weeklystickchartOf700";
 }
 @GetMapping("/candle/388/weekly")
 public String weeklycandle388(){
  return "weeklystickchartOf388";
 }
  
  
  
}
