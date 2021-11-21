package com.kiienkoromaniuk.coctailshelper.data.remote

import com.kiienkoromaniuk.coctailshelper.data.models.CoctailsListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CoctailsService {
    @GET("/api/json/v1/1/filter.php")
    fun getCoctails(@Query(value = "a")type: String): Single<CoctailsListResponse>
}