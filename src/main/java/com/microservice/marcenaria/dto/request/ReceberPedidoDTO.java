package com.microservice.marcenaria.dto.request;

import com.microservice.marcenaria.dto.request.GeometriasDTO;
import lombok.Data;

@Data
public class ReceberPedidoDTO {
    String movel;
    String material;
    GeometriasDTO geometrias[];
}
