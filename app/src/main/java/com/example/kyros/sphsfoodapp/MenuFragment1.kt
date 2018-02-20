package com.example.kyros.sphsfoodapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.menu_fragment_1.*
import kotlinx.android.synthetic.main.menu_fragment_1_child.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Kyros on 2/17/2018.
 */
class MenuFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.menu_fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //json response
        val categoriesList = arrayListOf<Category>()
        val retrofit = Retrofit.Builder()
                .baseUrl(MealAPI.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = retrofit.create(MealAPI::class.java)
        val call = api.getAllCategories()
        call.enqueue(object : Callback<CategoryResponse> {

            override fun onFailure(call: Call<CategoryResponse>?, t: Throwable?) {
                Toast.makeText(context, "Call Failed", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<CategoryResponse>?, response: Response<CategoryResponse>?) {
                categoriesList.clear()
                categoriesList.addAll(response?.body()!!.categories)
                categoriesRecyclerView.adapter.notifyDataSetChanged()
            }
        })

        //RecyclerView
        with(categoriesRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = GenericRecyclerAdapter<Category>(categoriesList, R.layout.menu_fragment_1_child,
                    {
                        if (menuFragment1Child == null) Toast.makeText(context, "fragment is null", Toast.LENGTH_SHORT).show()
                        (menuFragment1Child as MenuFragment1Child).category = it
                    }, { _, _ ->
            })
        }
    }
}