package com.dishe.domain.uses_case

import com.dishe.common.Resource
import com.dishe.data.model.toDomainMeal
import com.dishe.domain.model.Meal
import com.dishe.domain.repository.MealSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchMealsUseCase @Inject constructor(private val repository: MealSearchRepository) {


    operator fun invoke(q: String): Flow<Resource<List<Meal>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getMealSearch(q)
            val domainData =
                if (data.meals != null) data.meals.map { it -> it.toDomainMeal() } else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }


}