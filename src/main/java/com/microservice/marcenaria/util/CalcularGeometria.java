package com.microservice.marcenaria.util;

import com.microservice.marcenaria.dto.request.GeometriasDTO;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CalcularGeometria {

  private static final double PRECO_BASE_PINHO = 0.10;
  private static final double PRECO_BASE_CARVALHO = 0.30;
  private static final double PRECO_BASE_EBANO = 5.00;


  public static double calcularPrecoCilindroIndividual(GeometriasDTO cilindro, String material) {
    double precoBase = obterPrecoBase(material);

    double raioBase = extrairValorNumerico(cilindro.getRaio_base());
    double altura = extrairValorNumerico(cilindro.getAltura());

    double volume = Math.PI * Math.pow(raioBase, 2) * altura;

    return precoBase * volume;
  }

  private static double extrairValorNumerico(String valor) {
    return Double.parseDouble(valor.replaceAll("[^\\d.]", ""));
  }

  private static double obterPrecoBase(String tipoMadeira) {
    return switch (tipoMadeira.toLowerCase()) {
      case "pinho" -> PRECO_BASE_PINHO;
      case "carvalho" -> PRECO_BASE_CARVALHO;
      case "ébano" -> PRECO_BASE_EBANO;
      default -> throw new IllegalArgumentException("Tipo de madeira desconhecido: " + tipoMadeira);
    };
  }

  public static double calcularPrecoComprimentoIndividual(GeometriasDTO comprimento,
      String material) {
    double precoBase = obterPrecoBase(material);

    double comprimentoValor = extrairValorNumerico(comprimento.getComprimento());
    double largura = extrairValorNumerico(comprimento.getLargura());
    double altura = extrairValorNumerico(comprimento.getAltura());

    double volume = comprimentoValor * largura * altura;

    return precoBase * volume;
  }
}
