package com.kiienkoromaniuk.coctailshelper.data.repository

import com.kiienkoromaniuk.coctailshelper.data.remote.CoctailsDataSource
import javax.inject.Inject

class CoctailsRepository @Inject constructor(
    private val remote: CoctailsDataSource
) {
    fun getCoctails(type: String)= remote.getCoctails(type)
}