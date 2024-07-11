package com.gb.lucena.todolist.persistence.data

import java.time.Instant
import java.util.UUID
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean

@DynamoDbBean
data class TodoData(
    @get:DynamoDbAttribute("todo_id")
    var id: UUID? = null,

    @get:DynamoDbAttribute("todo_name")
    var name: String? = null,

    @get:DynamoDbAttribute("todo_description")
    var description: String? = null,

    @get:DynamoDbAttribute("done")
    var done: Boolean? = false,

    @get:DynamoDbAttribute("created_at")
    var createdAt: Instant? = null,

    @get:DynamoDbAttribute("updated_at")
    var updatedAt: Instant? = null
)
