package com.dishe.data.repository

import com.dishe.data.model.MealsDTO
import com.dishe.data.remote.MealSearchAPI
import com.dishe.domain.repository.MealDetailsRepository
import com.dishe.domain.repository.MealSearchRepository

class MealDetailsRepositoryImpl(private val mealSearchAPI: MealSearchAPI) : MealDetailsRepository {
    override suspend fun getMealDetails(id: String): MealsDTO {
       return mealSearchAPI.getMealDetails(id)
    }


}