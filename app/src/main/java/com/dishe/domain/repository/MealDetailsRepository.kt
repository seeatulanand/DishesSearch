package com.dishe.domain.repository

import com.dishe.data.model.MealsDTO

interface MealDetailsRepository {
    suspend fun getMealDetails(id:String):MealsDTO
}