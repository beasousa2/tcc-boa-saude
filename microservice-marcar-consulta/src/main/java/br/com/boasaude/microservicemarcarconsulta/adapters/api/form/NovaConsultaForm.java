package br.com.boasaude.microservicemarcarconsulta.adapters.api.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NovaConsultaForm {

    @NotNull
    private String matricula;
    private String codigoMedico;
    private String codigoConveniado;
//    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String dataHora;
    private String descricao;


}
