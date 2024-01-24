package com.microservice.marcenaria.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErroDTO {
  String mensagem;
  String detalhes;
}
