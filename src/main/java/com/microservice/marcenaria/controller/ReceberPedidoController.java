package com.microservice.marcenaria.controller;

import com.microservice.marcenaria.dto.request.ReceberPedidoDTO;
import com.microservice.marcenaria.service.ReceberPedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ReceberPedidoController {
    private final ReceberPedidoService service;

    @PostMapping("/receberPedido")
    public ResponseEntity<Object> post(@RequestBody ReceberPedidoDTO source){
        return this.service.post(source);
    }
}
