package com.okugata.sintaksys.core.data

import com.okugata.sintaksys.core.data.source.remote.RemoteDataSource
import com.okugata.sintaksys.core.utils.DataMapper
import com.okugata.sintaksys.domain.model.Text
import com.okugata.sintaksys.domain.repository.ISintaksysRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class SintaksysRepository(
    private val remoteDataSource: RemoteDataSource
) : ISintaksysRepository {
    override fun getCorrectedText(text: Text): Flow<Resource<Text>> = flow {
        emit(remoteDataSource.getCorrectedText(text).map {
            DataMapper.apiResponseToResource(it)
        }.first())
    }


}