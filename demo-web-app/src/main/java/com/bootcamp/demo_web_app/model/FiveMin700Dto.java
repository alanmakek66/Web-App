package com.bootcamp.demo_web_app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class FiveMin700Dto {
  @JsonProperty(value = "5MIN-0700.HK")
  private FiveMindata fiveMin700;

  
}
