package br.com.fiap.st1.veiculos.service;

import br.com.fiap.st1.veiculos.model.Evento;
import br.com.fiap.st1.veiculos.producer.ChaveVeiculoProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChaveVeiculoService {
    private ChaveVeiculoProducer chaveProducer;

    @Autowired
    public ChaveVeiculoService(ChaveVeiculoProducer producer) {
        this.chaveProducer = producer;
    }

    public void criarChave(String idVeiculo) {
        log.info("Enviando id para criacao da chave de acesso do veiculo: {}", idVeiculo);
        chaveProducer.criar(new Evento(idVeiculo));
    }
}
