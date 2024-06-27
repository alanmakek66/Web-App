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
@Setter
@Getter
@Builder
public class FiveMindata {
  @JsonProperty(value = "data")
  private List<Data1Dto> data1Dtos;

  
}
