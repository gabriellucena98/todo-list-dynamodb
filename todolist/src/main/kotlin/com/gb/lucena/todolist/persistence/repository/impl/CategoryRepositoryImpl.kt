package com.gb.lucena.todolist.persistence.repository.impl

import com.gb.lucena.todolist.persistence.data.CategoryData
import com.gb.lucena.todolist.persistence.repository.CategoryRepository
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Expression
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest

@Repository
class CategoryRepositoryImpl(
    private val categoryTable: DynamoDbTable<CategoryData>,
): CategoryRepository {

    private companion object {
        private val EMAIL_NOT_EXISTS_EXPRESSION = Expression.builder().expression("attribute_not_exists(email)").build()
        private val EMAIL_EXISTS_EXPRESSION = Expression.builder().expression("attribute_exists(email)").build()

    }

    override fun create(categoryData: CategoryData) {
        val request = PutItemEnhancedRequest
            .builder(CategoryData::class.java)
            .item(categoryData)
            .build()

        categoryTable.putItem(request)
    }
}