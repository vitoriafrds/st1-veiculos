package br.com.fiap.st1.veiculos.service;

import br.com.fiap.st1.veiculos.mapper.VeiculoMapper;
import br.com.fiap.st1.veiculos.model.Veiculo;
import br.com.fiap.st1.veiculos.model.entity.VeiculoEntity;
import br.com.fiap.st1.veiculos.model.request.VeiculoRequest;
import br.com.fiap.st1.veiculos.repository.VeiculoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VeiculoServiceTest {

    @Mock
    private VeiculoRepository repository;

    @Mock
    private VeiculoMapper mapper;

    private VeiculoService serviceMock;

    @BeforeEach
    public void setUp() {
        this.serviceMock = new VeiculoService(this.repository, this.mapper);
    }

    @Test
    void test_DeveCadastrar_VeiculoCorretamente() {
        when(repository.save(any(VeiculoEntity.class))).thenReturn(construirVeiculoEntity());
        when(mapper.from(any(VeiculoRequest.class))).thenReturn(construirVeiculoEntity());
        when(mapper.from(any(VeiculoEntity.class))).thenReturn(construirVeiculo());

        VeiculoRequest request = construirVeiculoRequest();
        Veiculo veiculo = serviceMock.cadastrar(request);

        assertNotNull(veiculo);
    }

    @Test
    void test_DeveConsultarVeiculo_PorId() {
        var id = UUID.randomUUID().toString();
        when(repository.findById(eq(UUID.fromString(id))))
                .thenReturn(Optional.of(construirVeiculoEntity()));
        when(mapper.from(any(VeiculoEntity.class))).thenReturn(construirVeiculo());

        Optional<Veiculo> veiculo = serviceMock.consultarPorId(id);

        assertNotNull(veiculo.get());
    }

    private static VeiculoEntity construirVeiculoEntity() {
        VeiculoEntity entity = new VeiculoEntity();
        entity.setId(UUID.randomUUID());
        entity.setPlaca("PLACA");
        entity.setModelo("MODELO");
        return entity;
    }

    private static VeiculoRequest construirVeiculoRequest() {
        VeiculoRequest request = new VeiculoRequest();
        request.setPlaca("PLACA");
        request.setModelo("MODELO");

        return request;
    }

    private static Veiculo construirVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("PLACA");
        veiculo.setModelo("MODELO");

        return veiculo;
    }
}
