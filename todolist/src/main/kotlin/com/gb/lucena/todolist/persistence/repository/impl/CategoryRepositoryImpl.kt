package com.gb.lucena.todolist.persistence.repository.impl

import com.gb.lucena.todolist.persistence.data.CategoryData
import com.gb.lucena.todolist.persistence.repository.CategoryRepository
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Expression
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.model.DeleteItemEnhancedRequest
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest
import software.amazon.awssdk.enhanced.dynamodb.model.UpdateItemEnhancedRequest
import java.time.Instant

@Repository
class CategoryRepositoryImpl(
    private val categoryTable: DynamoDbTable<CategoryData>,
) : CategoryRepository {

    private companion object {
        private val EMAIL_NOT_EXISTS_EXPRESSION = Expression.builder().expression("attribute_not_exists(email)").build()
        private val EMAIL_EXISTS_EXPRESSION = Expression.builder().expression("attribute_exists(email)").build()
        private val CATEGORY_ID_EXISTS_EXPRESSION = Expression.builder().expression("atrribute_exists(category_id)").build()
    }

    override fun create(categoryData: CategoryData) {
        val request = PutItemEnhancedRequest
            .builder(CategoryData::class.java)
            .item(categoryData)
            .build()

        categoryTable.putItem(request)
    }

    override fun existsByEmailAndName(email: String, name: String): Boolean {
        val condition = QueryConditional.keyEqualTo(
            Key.builder()
                .partitionValue(email)
                .sortValue(name)
                .build()
        )

        val request = QueryEnhancedRequest
            .builder()
            .queryConditional(condition)
            .limit(1)
            .build()

        return categoryTable.index("CategoryNameIndex")
            .query(request)
            .first()
            .items()
            .any()
    }

    override fun listByEmail(email: String): List<CategoryData> {
        val condition = QueryConditional.keyEqualTo(
            Key.builder()
                .partitionValue(email)
                .build()
        )

        val request = QueryEnhancedRequest
            .builder()
            .queryConditional(condition)
            .build()

        return categoryTable.query(request)
            .items()
            .toList()
    }

    override fun deleteCategoryById(email: String, id: String) {
        val request = DeleteItemEnhancedRequest
            .builder()
            .key(
                Key.builder()
                    .partitionValue(email)
                    .sortValue(id)
                    .build()
            )
            .conditionExpression(EMAIL_EXISTS_EXPRESSION)
            .conditionExpression(CATEGORY_ID_EXISTS_EXPRESSION)
            .build()

        categoryTable.deleteItem(request)
    }

    override fun updateCategory(data: CategoryData): CategoryData {
        val condition = QueryConditional.keyEqualTo(
            Key.builder()
                .partitionValue(data.email)
                .sortValue(data.id.toString())
                .build()
        )

        val requestCategory = QueryEnhancedRequest
            .builder()
            .queryConditional(condition)
            .build()

        val category = categoryTable.query(requestCategory)
            .items()
            .firstOrNull()
            ?: throw NoSuchElementException("Category not found")

        val requestUpdate = UpdateItemEnhancedRequest
            .builder(CategoryData::class.java)
            .item(
                category.copy(
                    name = data.name,
                    description = data.description,
                    todos = data.todos,
                    sequence = data.sequence,
                    updatedAt = Instant.now()
                )
            )
            .ignoreNulls(true)
            .conditionExpression(EMAIL_EXISTS_EXPRESSION)
            .conditionExpression(CATEGORY_ID_EXISTS_EXPRESSION)
            .build()

        return categoryTable.updateItem(requestUpdate)
    }

    override fun getCategoryById(email: String, id: String): CategoryData {
        val condition = QueryConditional.keyEqualTo(
            Key.builder()
                .partitionValue(email)
                .sortValue(id)
                .build()
        )

        val request = QueryEnhancedRequest
            .builder()
            .queryConditional(condition)
            .build()

        return categoryTable.query(request).items().firstOrNull() ?: throw NoSuchElementException("Category not found")
    }
}
