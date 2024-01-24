package com.microservice.marcenaria.controller;

import com.microservice.marcenaria.dto.response.TipoGeometria;
import com.microservice.marcenaria.dto.response.TipoMadeira;
import com.microservice.marcenaria.service.GeometriaService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GeometriaController {
    private final GeometriaService service;
    @GetMapping("/tipos-madeira")
    public List<TipoMadeira> getTiposMadeira() {
        return service.getTiposMadeira();
    }

    @GetMapping("/tipos-geometria")
    public List<TipoGeometria> getTiposGeometria() {
        return service.getTiposGeometria();
    }
}
