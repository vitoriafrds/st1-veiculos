package br.com.fiap.st1.veiculos.repository;

import br.com.fiap.st1.veiculos.model.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, UUID> {
}
