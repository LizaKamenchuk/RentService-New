package org.kamenchuk.security.jwt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "GateWay API", version = "3.0", description = "GateWay Service"))
@SecurityScheme(name = "bearerToken", scheme = "bearer", type = SecuritySchemeType.HTTP, bearerFormat = "bearerToken")
public class SwaggerConfig {
}
