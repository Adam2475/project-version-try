package com.example.stableproject

//  URL rest api
//  https://hackdb-473c.restdb.io

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiActivity : AppCompatActivity() {

    private val BASE_URL = "https://hackdb-473c.restdb.io/rest/"
    private val TAG: String = "CHECK_RESPONSE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_api)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getAllPhotos()
    }

//    val myDataItem = MyDataItem(
//        id = 1,
//        location = "Some Location",
//        timestamp = "NULL",
//        pos_x = 100,
//        pos_y = 200,
//        image_ref = "NULL",
//    )
//
//    val api = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        // Activity navigation
//        .create(MyApi::class.java)
//    val retrofitData = api.getPhotos()
//
//    RetrofitInstance.api.enqueue(object : Callback<MyDataItem> {
//        override fun onResponse(call: Call<MyDataItem>, response: Response<MyDataItem>) {
//            if (response.isSuccessful) {
//                Log.d("MainActivity", "Data posted successfully!")
//            } else {
//                Log.d("MainActivity", "Failed to post data")
//             }
//        }
//        override fun onFailure(call: Call<MyDataItem>, t: Throwable) {
//            Log.d("MainActivity", "onFailure:" +t.message)
//            Log.d("MainActivity", "onFailure:" +t.message)
//        }
//    })

    private fun getAllPhotos() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            // Activity navigation
            .create(MyApi::class.java)
        val retrofitData = api.getPhotos()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                for (myData in responseBody) {
                    myStringBuilder.append(myData.timestamp)
                    myStringBuilder.append("\n")
                }
                val textView: TextView = findViewById(R.id.txtId)
                textView.text = myStringBuilder
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure:" + t.message)
            }
        })
    }
}