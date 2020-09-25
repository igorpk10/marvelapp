package com.example.marvelopenapp.webservice

import MarvelObject
import com.example.marvelopenapp.auth.AuthenticationKey
import com.example.marvelopenapp.utils.DateUtils
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelServicesInterface {

    @GET("characters")


    fun getHerosList(
        @Query("limit") limit: String = "100",
        @Query("offset") offset: String,
        @Query("ts") ts: String = DateUtils.getTimeMillisNow(),
        @Query("hash") hash: String = AuthenticationKey.getHash(),
        @Query("apikey") publicKey: String = AuthenticationKey.publicKey): Call<MarvelObject>
}