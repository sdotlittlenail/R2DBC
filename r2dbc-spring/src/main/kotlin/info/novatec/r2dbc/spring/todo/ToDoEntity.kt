package info.novatec.r2dbc.spring.todo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class ToDoEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: String,
        val name: String,
        val category: String,
        val complete: Boolean)