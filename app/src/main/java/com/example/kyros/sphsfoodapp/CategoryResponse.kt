package com.example.kyros.sphsfoodapp

/**
 * Created by per6 on 2/20/18.
 */

data class CategoryResponse(
		val categories: List<Category>
)

data class Category(
		val idCategory: String? = "",
		val strCategory: String? = "",
		val strCategoryThumb: String?  = "",
		val strCategoryDescription: String?  = ""
)