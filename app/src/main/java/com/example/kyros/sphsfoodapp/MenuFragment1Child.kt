package com.example.kyros.sphsfoodapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.category_recyclerview_item_layout.*
import kotlinx.android.synthetic.main.item_in_nested_recycler_view.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.properties.Delegates

/**
 * Created by per6 on 2/20/18.
 */
class MenuFragment1Child : Fragment(), Callback<MealResponse> {

    val api by lazy {
        Retrofit.Builder()
                .baseUrl(MealAPI.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MealAPI::class.java)
    }
    var category: Category by Delegates.observable(Category()) { _, old, new ->
        if (view != null && old != new) {
            bindHolder()
        }
    }

    private fun bindHolder() {
        val call = api.filterByCategory(category.strCategory!!)
        call.enqueue(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.category_recyclerview_item_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindHolder()
    }

    override fun onFailure(call: Call<MealResponse>?, t: Throwable?) {
        Toast.makeText(context, "Meal API Call Failed", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<MealResponse>?, response: Response<MealResponse>?) {

        with(itemsInCategoryRecyclerView) {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = GenericRecyclerAdapter<Meal>(response?.body()!!.meals!!, R.layout.item_in_nested_recycler_view,
                    {
                        mealName.text = it.strMeal
                        Glide.with(context).load(it.strMealThumb).into(mealImageView)
                    }, { itemView, position ->
                //TODO: launch fragment
            }
            )
        }
    }
}