package com.gb.lucena.todolist.persistence.data

import java.time.Instant
import java.util.UUID
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
data class CategoryData(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("email")
    var email: String? = null,

    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("category_id")
    var id: UUID? = null,

    @get:DynamoDbAttribute("category_name")
    var name: String? = null,

    @get:DynamoDbAttribute("category_description")
    var description: String? = null,

    @get:DynamoDbAttribute("todos")
    var todos: List<TodoData>? = null,

    @get:DynamoDbAttribute("created_at")
    var createdAt: Instant? = null,

    @get:DynamoDbAttribute("updated_at")
    var updatedAt: Instant? = null
)
