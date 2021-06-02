package com.okugata.sintaksys.domain.usecase

import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.domain.model.Text
import kotlinx.coroutines.flow.Flow

interface SintaksysUseCase {
    fun getCorrectedText(text: Text): Flow<Resource<Text>>
}