package com.microservice.marcenaria.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespostaPedidoDTO {
  private String movel;
  private String material;
  private List<GeometriaPrecoDTO> geometrias;
}
