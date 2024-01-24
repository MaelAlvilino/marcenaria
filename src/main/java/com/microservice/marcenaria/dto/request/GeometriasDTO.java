package com.microservice.marcenaria.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeometriasDTO {
    String estrutura;
    String geometria;
    String raio_base;
    String altura;
    String comprimento;
    String largura;
}
