package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLScalarType extendedScalarLong() {
        return ExtendedScalars.GraphQLLong;
    }

    @Bean
    public GraphQLScalarType extendedScalarDate() {
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType extendedScalarDateTime() {
        return ExtendedScalars.DateTime;
    }

    @Bean
    public GraphQLScalarType extendedScalarBigDecimal() {
        return ExtendedScalars.GraphQLBigDecimal;
    }

    @Bean
    public GraphQLScalarType extendedScalarBigInteger() {
        return ExtendedScalars.GraphQLBigInteger;
    }

    // Add other scalars as needed
}
