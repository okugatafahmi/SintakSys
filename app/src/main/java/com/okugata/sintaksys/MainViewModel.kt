package com.okugata.sintaksys

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.domain.model.Text
import com.okugata.sintaksys.domain.usecase.SintaksysUseCase

class MainViewModel(private val sintaksysUseCase: SintaksysUseCase) : ViewModel() {
    fun getCorrectedText(text: Text): LiveData<Resource<Text>> =
        sintaksysUseCase.getCorrectedText(text).asLiveData()
}