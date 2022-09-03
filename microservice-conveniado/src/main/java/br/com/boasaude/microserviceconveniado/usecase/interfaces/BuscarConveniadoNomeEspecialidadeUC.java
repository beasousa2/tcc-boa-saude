package br.com.boasaude.microserviceconveniado.usecase.interfaces;

import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoNomeEspecialidadeDto;

public interface BuscarConveniadoNomeEspecialidadeUC {

   void execute(BuscarConveniadoNomeEspecialidadeDto dto, KafkaHeaderDto kafkaHeaderDto);
}
