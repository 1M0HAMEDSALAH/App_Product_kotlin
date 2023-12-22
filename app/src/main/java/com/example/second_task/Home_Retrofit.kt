package com.example.second_task

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.myadapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home_Retrofit : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recccc)

        val myApis = RetrofitClient.retrofit.create(UserApis::class.java)
        val callProduct = myApis.GetProductById()
        var recyclerView = findViewById<RecyclerView>(R.id.rec);

        callProduct.enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                var respone = response.body()
                recyclerView.adapter = myadapter(respone!!)
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("Sorry Error Accured" , t.message.toString())
            }

        }
        )


    }
}