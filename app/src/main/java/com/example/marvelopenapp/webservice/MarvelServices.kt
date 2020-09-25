package com.example.marvelopenapp.webservice

import MarvelObject
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelopenapp.base.BaseCallback
import com.example.marvelopenapp.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Response

class MarvelServices {

    // This method call a marvel api
    // The marvel api return a list of your heroes :D
    fun callHeroesList(
        context: AppCompatActivity,
        offset: Int,
        callback: (list: MarvelObject) -> Unit
    ) {
        val retrofit = NetworkUtils.instance.getRetrofitInstance()
        val endpoint = retrofit.create(MarvelServicesInterface::class.java)

        endpoint.getHerosList(offset = offset.toString()).enqueue(object: BaseCallback<MarvelObject>(context){
            override fun onResponse(call: Call<MarvelObject>, response: Response<MarvelObject>) {
                super.onResponse(call, response)
                response.body()?.let {
                    callback(it)
                }
            }
        })
    }

}