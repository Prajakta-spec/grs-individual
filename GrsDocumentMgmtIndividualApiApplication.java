package com.lmig.globalspecialty.surety.grsindividualdocmgmtapi;

import com.lmig.globalspecialty.surety.grsindividualdocmgmtapi.common.security.IdpProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableCaching
@EnableRedisRepositories(
        basePackages = {
                "com.lmig.globalspecialty.surety.grsindividualdocmgmtapi.common.countries.repository",
                "com.lmig.globalspecialty.surety.grsindividualdocmgmtapi.common.wbusers.repository"
        })
@EnableDynamoDBRepositories(
        basePackages = { "com.lmig.globalspecialty.surety.grsindividualdocmgmtapi.loa.metadata.repository",
                "com.lmig.globalspecialty.surety.grsindividualdocmgmtapi.obligee.metadata.repository"},
        amazonDynamoDBRef = "amazonDynamoDB",
        dynamoDBMapperConfigRef = "dynamoDBMapperConfig")
@OpenAPIDefinition(
        info =
        @Info(
                title = "GRS Individual document management API",
                version = "v1",
                contact =
                @Contact(name = "Team Spark", email = "TeamSpark@LibertyMutual.onmicrosoft.com")),
        security = {@SecurityRequirement(name = "bearer-key")})
@SecuritySchemes(
        value = {
                @SecurityScheme(
                        name = "bearer-key",
                        type = SecuritySchemeType.HTTP,
                        scheme = "bearer",
                        bearerFormat = "opaque")
        })
@EnableConfigurationProperties(IdpProperties.class)
public class GrsDocumentMgmtIndividualApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrsDocumentMgmtIndividualApiApplication.class, args);
    }
}
