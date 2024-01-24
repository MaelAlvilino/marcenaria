package com.microservice.marcenaria.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoGeometria {

  private String nome;
  private List<String> propriedades;

}
