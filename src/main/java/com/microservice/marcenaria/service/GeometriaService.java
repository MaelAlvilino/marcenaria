package com.microservice.marcenaria.service;

import com.microservice.marcenaria.dto.response.TipoGeometria;
import com.microservice.marcenaria.dto.response.TipoMadeira;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GeometriaService {
    public List<TipoMadeira> getTiposMadeira() {
        return Arrays.asList(
            TipoMadeira.builder().nome("Pinho").precoBase(0.10).build(),
            TipoMadeira.builder().nome("Carvalho").precoBase(0.30).build(),
            TipoMadeira.builder().nome("Ébano").precoBase(5.00).build()
        );
    }

    public List<TipoGeometria> getTiposGeometria() {
        return Arrays.asList(
            TipoGeometria.builder().nome("Esfera").propriedades(Arrays.asList("Raio")).build(),
            TipoGeometria.builder().nome("Cubo").propriedades(Arrays.asList("Lado")).build(),
            TipoGeometria.builder().nome("Cilindro").propriedades(Arrays.asList("Raio Base", "Altura")).build(),
            TipoGeometria.builder().nome("Paralelepípedo").propriedades(Arrays.asList("Comprimento", "Largura", "Altura")).build()
        );
    }
}
