package com.example.graphqlserver

import graphql.Scalars.GraphQLString
import graphql.scalars.ExtendedScalars.Date
import graphql.scalars.ExtendedScalars.newAliasedScalar
import graphql.schema.idl.RuntimeWiring
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.RuntimeWiringConfigurer


@Configuration
class GraphQlConfig {
    @Bean
    fun runtimeWiringConfigurer(): RuntimeWiringConfigurer {
        val socialMediaLink = newAliasedScalar("SocialMediaLink")
            .aliasedScalar(GraphQLString)
            .build()

        return RuntimeWiringConfigurer { wiringBuilder: RuntimeWiring.Builder ->
            wiringBuilder
                .scalar(Date)
                .scalar(socialMediaLink)
        }
    }
}