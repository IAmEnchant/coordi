package com.assignment.coordi.global.config;

import com.assignment.coordi.global.serializer.BigDecimalCommaSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class JacksonConfig {

  @Bean
  public SimpleModule bigDecimalCustomModule() {
    SimpleModule module = new SimpleModule();
    module.addSerializer(BigDecimal.class, new BigDecimalCommaSerializer());
    return module;
  }
}