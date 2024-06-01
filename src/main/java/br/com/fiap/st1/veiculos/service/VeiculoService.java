package br.com.fiap.st1.veiculos.service;

import br.com.fiap.st1.veiculos.mapper.VeiculoMapper;
import br.com.fiap.st1.veiculos.model.Veiculo;
import br.com.fiap.st1.veiculos.model.entity.VeiculoEntity;
import br.com.fiap.st1.veiculos.model.request.VeiculoRequest;
import br.com.fiap.st1.veiculos.repository.VeiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VeiculoService {
    private VeiculoRepository repository;
    private VeiculoMapper mapper;

    private ChaveVeiculoService chaveVeiculoService;

    @Autowired
    public VeiculoService(VeiculoRepository repository, VeiculoMapper mapper, ChaveVeiculoService chaveVeiculoService) {
        this.repository = repository;
        this.mapper = mapper;
        this.chaveVeiculoService = chaveVeiculoService;
    }

    public Veiculo cadastrar(VeiculoRequest request) {
        VeiculoEntity entityToSave = mapper.from(request);
        VeiculoEntity savedEntity = repository.save(entityToSave);

        criarChave(savedEntity.getId().toString());

        return mapper.from(savedEntity);
    }

    private void criarChave(String idVeiculo) {
        chaveVeiculoService.criarChave(idVeiculo);
    }
}
