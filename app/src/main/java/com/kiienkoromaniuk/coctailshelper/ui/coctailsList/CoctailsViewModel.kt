package com.kiienkoromaniuk.coctailshelper.ui.coctailsList

import androidx.lifecycle.*
import com.kiienkoromaniuk.coctailshelper.data.models.Drink
import com.kiienkoromaniuk.coctailshelper.data.repository.CoctailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CoctailsViewModel @Inject constructor(
    private val repository: CoctailsRepository
): ViewModel()  {

    fun getCoctails(type: String) = repository.getCoctails(type)
}