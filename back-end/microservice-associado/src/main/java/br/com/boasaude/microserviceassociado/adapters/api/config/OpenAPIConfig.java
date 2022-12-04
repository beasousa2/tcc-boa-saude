package br.com.boasaude.microserviceassociado.adapters.api.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "microserviceassociado",
                version = "v2.0"
        ),
        servers = @Server(url = "http://microserviceassociado:8083")
)
@Configuration
public class OpenAPIConfig {
}
