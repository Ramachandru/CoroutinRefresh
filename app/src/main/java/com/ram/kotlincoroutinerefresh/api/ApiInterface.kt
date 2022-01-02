package com.ram.kotlincoroutinerefresh.api

import com.ram.kotlincoroutinerefresh.model.OrgModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface
{
    companion object{
        const val BASEURL : String ="https://api.github.com/users/hadley/"
    }
    @GET("orgs")
    suspend fun getOrgsData() : Response<MutableList<OrgModel>>
}