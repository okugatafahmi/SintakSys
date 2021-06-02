package com.okugata.sintaksys.domain.repository

import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.domain.model.Text
import kotlinx.coroutines.flow.Flow

interface ISintaksysRepository {
    fun getCorrectedText(text: Text): Flow<Resource<Text>>
}