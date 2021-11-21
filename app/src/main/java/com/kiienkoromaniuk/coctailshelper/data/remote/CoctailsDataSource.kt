package com.kiienkoromaniuk.coctailshelper.data.remote

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class CoctailsDataSource @Inject constructor(
    private val service: CoctailsService
) {
    fun getCoctails(type: String) = service.getCoctails(type)
}