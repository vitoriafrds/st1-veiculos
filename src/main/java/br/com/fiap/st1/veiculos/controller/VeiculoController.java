package br.com.fiap.st1.veiculos.controller;

import br.com.fiap.st1.veiculos.model.Veiculo;
import br.com.fiap.st1.veiculos.model.request.VeiculoRequest;
import br.com.fiap.st1.veiculos.model.response.DataResponse;
import br.com.fiap.st1.veiculos.service.VeiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {
    private VeiculoService service;

    @Autowired
    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DataResponse<Veiculo>> cadastrar(@RequestBody VeiculoRequest request) {
        log.info("Iniciando processamento de cadastro de veiculos: {}", LocalDateTime.now());

        Veiculo veiculoCadastrado = service.cadastrar(request);

        log.info("Veiculo cadastrado com sucesso");
        log.info("id_veiculo: {}", veiculoCadastrado.getId());
        return ResponseEntity.ok(DataResponse.of(veiculoCadastrado));
    }
}
