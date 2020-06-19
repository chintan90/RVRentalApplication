package com.example.sampleapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleapplication.R
import com.example.sampleapplication.adapter.MyAdapter
import com.example.sampleapplication.client.APIInterface
import com.example.sampleapplication.client.ApiClient
import com.example.sampleapplication.model.VehicleData
import com.example.sampleapplication.model.VehicleModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private var dataSource = ArrayList<VehicleData>()
    private var adapter : MyAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(
            dataSource,
            applicationContext
        )
        recyclerview.adapter = adapter

        edt_search.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                var filterText = s.toString()
                loadVehicles(filterText)
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
    }

    private fun loadVehicles(filter: String) {
        var apiService : APIInterface = ApiClient.getApiClient()!!.create(APIInterface::class.java)
        var call : Call<VehicleModel> = apiService.getVehicles(ApiClient.getVehicleFilter(filter, "1"))

        call.enqueue(object : Callback<VehicleModel> {
            override fun onFailure(call: Call<VehicleModel>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<VehicleModel>,
                response: Response<VehicleModel>
            ) {
                if (response.code() == 200) {
                    val users = response.body()!!.vehicleModel

                    Log.d(TAG, "User response : $users")
                    dataSource.clear()
                    dataSource.addAll(users)

                    adapter!!.notifyDataSetChanged()
                }

            }
        })
    }
}
