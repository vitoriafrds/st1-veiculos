package br.com.fiap.st1.veiculos.mapper;

import br.com.fiap.st1.veiculos.model.Veiculo;
import br.com.fiap.st1.veiculos.model.entity.VeiculoEntity;
import br.com.fiap.st1.veiculos.model.request.VeiculoRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    public Veiculo from(VeiculoEntity entity) {
        var veiculo = new Veiculo();
        BeanUtils.copyProperties(entity, veiculo);
        return veiculo;
    }

    public VeiculoEntity from(VeiculoRequest request) {
        var entity = new VeiculoEntity();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }
}
