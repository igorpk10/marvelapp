package com.example.marvelopenapp.base

import android.content.Context
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

open class BaseCallback<T> (var context: Context): Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {
        try {
            Log.e("RetrofitError", t.localizedMessage)
        } catch (ex: Exception) {
        }
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if(!response.isSuccessful){
            Toast.makeText(context, "Network error", Toast.LENGTH_SHORT)
                .show()
        }
    }
}