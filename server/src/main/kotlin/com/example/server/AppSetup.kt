package com.example.server

import io.r2dbc.spi.ConnectionFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Configuration
class AppSetup {
    @Bean
    fun logger(): Logger = LoggerFactory.getLogger("bookshop-spring")

    @Bean
    fun initializer(@Qualifier("connectionFactory")connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
        logger().info("connection factory initialization")
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory)
        initializer.setDatabasePopulator(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
        return initializer
    }
}