package br.com.fiap.st1.veiculos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalheVeiculo {
    @JsonProperty("id_veiculo")
    private String idVeiculo;
}
