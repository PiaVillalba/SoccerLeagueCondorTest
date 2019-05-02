package com.condorlabs.soccerleagues.data.api.retrofit

import com.condorlabs.soccerleagues.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

abstract class RetrofitClient {

    private var mApiService: RetrofitService? = null

    init {
        initRetrofit()
    }

    private fun initRetrofit() {
        val retrofit = retrofitBuilder()
        mApiService = retrofit.create(RetrofitService::class.java)
    }

    private fun retrofitBuilder(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    protected fun getApiService(): RetrofitService? {
        return mApiService
    }
}

