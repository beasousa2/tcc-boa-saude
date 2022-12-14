package br.com.boasaude.microservicemarcarconsulta.adapters.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "microservicemarcarconsulta",
                version = "v1.0"
        ),
        servers = @Server(url = "http://microservicemarcarconsulta:8085")
)
public class OpenAPIConfig {
}
