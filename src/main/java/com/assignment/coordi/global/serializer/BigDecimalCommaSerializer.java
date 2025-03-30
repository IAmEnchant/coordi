package com.assignment.coordi.global.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalCommaSerializer extends JsonSerializer<BigDecimal> {
  private static final NumberFormat formatter = NumberFormat.getNumberInstance(
    Locale.KOREA);

  @Override
  public void serialize(
    BigDecimal value, JsonGenerator gen, SerializerProvider serializers
  ) throws
    IOException {
    if (value == null) {
      gen.writeNull();
    } else {
      gen.writeString(formatter.format(value));
    }
  }
}