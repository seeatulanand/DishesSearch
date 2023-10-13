package com.dishe.data.repository

import com.dishe.data.model.MealsDTO
import com.dishe.data.remote.MealSearchAPI
import com.dishe.domain.repository.MealSearchRepository

class MealSearchRepistoryImpl(private  val mealSearchAPI: MealSearchAPI):MealSearchRepository {
    override suspend fun getMealSearch(s: String): MealsDTO {
       return mealSearchAPI.getSearchMealList(s)
    }


}