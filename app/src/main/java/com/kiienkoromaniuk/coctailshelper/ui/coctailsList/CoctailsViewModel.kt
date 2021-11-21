package com.kiienkoromaniuk.coctailshelper.ui.coctailsList

import androidx.lifecycle.ViewModel
import com.kiienkoromaniuk.coctailshelper.data.repository.CoctailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoctailsViewModel @Inject constructor(
    repository: CoctailsRepository
): ViewModel()  {
}