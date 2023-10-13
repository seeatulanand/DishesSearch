package com.dishe.domain.repository

import com.dishe.data.model.MealsDTO

interface MealSearchRepository {
    suspend fun getMealSearch(s:String): MealsDTO
}