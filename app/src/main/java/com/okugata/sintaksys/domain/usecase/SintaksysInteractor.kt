package com.okugata.sintaksys.domain.usecase

import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.domain.model.Text
import com.okugata.sintaksys.domain.repository.ISintaksysRepository
import kotlinx.coroutines.flow.Flow

class SintaksysInteractor(private val sintaksysRepository: ISintaksysRepository) :
    SintaksysUseCase {
    override fun getCorrectedText(text: Text): Flow<Resource<Text>> =
        sintaksysRepository.getCorrectedText(text)

}