package info.novatec.r2dbc.spring.todo.db

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class PostgresqlConfiguration(
        @Value("\${spring.r2dbc.username}") private val username: String,
        @Value("\${spring.r2dbc.password}") private val password: String) : AbstractR2dbcConfiguration() {

    override fun connectionFactory() = PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
            .host("127.0.0.1")
            .database("r2dbc_spring_todo_db")
            .username(username)
            .password(password)
            .build())

}