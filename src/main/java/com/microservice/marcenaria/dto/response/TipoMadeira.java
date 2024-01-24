package com.microservice.marcenaria.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoMadeira {
  private String nome;
  private double precoBase;
}
