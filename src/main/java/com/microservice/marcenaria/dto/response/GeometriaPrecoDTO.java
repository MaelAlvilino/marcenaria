package com.microservice.marcenaria.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeometriaPrecoDTO {
  private String estrutura;
  private String precoFinal;

}
