package com.okugata.sintaksys.ui.submit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.domain.model.Text
import com.okugata.sintaksys.domain.usecase.SintaksysUseCase

class SubmitViewModel(private val sintaksysUseCase: SintaksysUseCase) : ViewModel() {
    fun getCorrectedText(text: Text): LiveData<Resource<Text>> =
        sintaksysUseCase.getCorrectedText(text).asLiveData()
}