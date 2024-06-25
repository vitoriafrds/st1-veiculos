package br.com.fiap.st1.veiculos.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoRequest {
    private String modelo;
    private String cor;

    @JsonProperty("ano_modelo")
    private String anoModelo;

    @JsonProperty("ano_fabricacao")
    private String anoFabricacao;

    @JsonProperty("tipo_combustivel")
    private String tipoCombustivel;

    private String placa;
    private String chassi;
    private String renavam;
    private String quilometragem;
}
