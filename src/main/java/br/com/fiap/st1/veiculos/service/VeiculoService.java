package br.com.fiap.st1.veiculos.service;

import br.com.fiap.st1.veiculos.mapper.VeiculoMapper;
import br.com.fiap.st1.veiculos.model.Veiculo;
import br.com.fiap.st1.veiculos.model.entity.VeiculoEntity;
import br.com.fiap.st1.veiculos.model.request.VeiculoRequest;
import br.com.fiap.st1.veiculos.repository.VeiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class VeiculoService {
    private VeiculoRepository repository;
    private VeiculoMapper mapper;

    @Autowired
    public VeiculoService(VeiculoRepository repository, VeiculoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Veiculo cadastrar(VeiculoRequest request) {
        VeiculoEntity entityToSave = mapper.from(request);
        VeiculoEntity savedEntity = repository.save(entityToSave);

        return mapper.from(savedEntity);
    }

    public Optional<Veiculo> consultarPorId(String idVeiculo) {
        Optional<VeiculoEntity> veiculo = repository.findById(UUID.fromString(idVeiculo));

        return veiculo.map(veiculoEntity -> mapper.from(veiculoEntity));
    }
}
