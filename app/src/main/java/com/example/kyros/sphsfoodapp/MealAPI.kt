package com.example.kyros.sphsfoodapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kyros on 2/17/2018.
 */
interface MealAPI {
    companion object {
        val baseURL = "http://www.themealdb.com/api/json/v1/1/"
    }

    @GET("random.php")
    fun getRandomOne(): Call<Meal>

    @GET("filter.php")
    fun filterByCategory(@Query("c") category: String) : Call<MealResponse>

    @GET("filter.php")
    fun filterByArea(@Query("a") area: String) : Call<MealResponse>

    @GET("filter.php")
    fun filterByIngredient(@Query("i") ingredient: String) : Call<MealResponse>

    @GET("categories.php")
    fun getAllCategories(): Call<CategoryResponse>
}
