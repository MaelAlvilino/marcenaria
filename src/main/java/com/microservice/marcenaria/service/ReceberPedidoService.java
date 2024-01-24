package com.microservice.marcenaria.service;

import static com.microservice.marcenaria.util.CalcularGeometria.calcularPrecoCilindroIndividual;
import static com.microservice.marcenaria.util.CalcularGeometria.calcularPrecoComprimentoIndividual;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.marcenaria.dto.request.GeometriasDTO;
import com.microservice.marcenaria.dto.request.ReceberPedidoDTO;
import com.microservice.marcenaria.dto.response.ErroDTO;
import com.microservice.marcenaria.dto.response.GeometriaPrecoDTO;
import com.microservice.marcenaria.dto.response.RespostaPedidoDTO;
import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReceberPedidoService {
  public ResponseEntity<Object> post(ReceberPedidoDTO source) {
    Map<Boolean, List<GeometriasDTO>> geometriasPorTipo = Arrays.stream(source.getGeometrias())
        .collect(Collectors.partitioningBy(each -> "cilindro".equalsIgnoreCase(each.getGeometria())));

    List<GeometriasDTO> cilindroList = geometriasPorTipo.get(true);
    List<GeometriasDTO> comprimentoList = geometriasPorTipo.get(false);


    List<GeometriaPrecoDTO> geometriasDTOList = cilindroList.stream()
        .map(cilindro -> GeometriaPrecoDTO.builder()
            .estrutura(cilindro.getEstrutura())
            .precoFinal(formatarComoMoeda(calcularPrecoCilindroIndividual(cilindro,
                source.getMaterial())))
            .build())
        .collect(Collectors.toList());

    geometriasDTOList.addAll(comprimentoList.stream()
        .map(comprimento -> GeometriaPrecoDTO.builder()
            .estrutura(comprimento.getEstrutura())
            .precoFinal(formatarComoMoeda(calcularPrecoComprimentoIndividual(comprimento, source.getMaterial())))
            .build())
        .toList());


    RespostaPedidoDTO respostaPedidoDTO = RespostaPedidoDTO.builder()
        .movel(source.getMovel())
        .material(source.getMaterial())
        .geometrias(geometriasDTOList)
        .build();

    try {
      return ResponseEntity.status(HttpStatus.OK)
          .body(respostaPedidoDTO);
    } catch (Exception e) {
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(ErroDTO.builder()
              .mensagem("Erro ao processar o pedido.")
              .detalhes(e.getMessage())
              .build());
    }
  }

  private String formatarComoMoeda(double valor) {
    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    return formatoMoeda.format(valor);
  }
}

