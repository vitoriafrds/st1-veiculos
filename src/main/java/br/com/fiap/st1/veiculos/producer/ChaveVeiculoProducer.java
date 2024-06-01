package br.com.fiap.st1.veiculos.producer;

import br.com.fiap.st1.veiculos.model.Evento;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChaveVeiculoProducer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private AmqpTemplate template;

    @Autowired
    public ChaveVeiculoProducer(AmqpTemplate template) {
        this.template = template;
    }

    public void criar(Evento evento) {
        try {
            template.convertAndSend(
                    "gerenciamento-chave-exchange",
                    "gerenciamento-chave-rout-key",
                     objectMapper.writeValueAsString(evento));

            log.info("Mensagem enviada com sucesso");
        } catch (AmqpException | JsonProcessingException erro) {
            log.error("Um erro ocorreu durante a tentativa de envio de mensagem para a exchange: {}", erro.getMessage());
        }
    }
}
