package com.okugata.sintaksys.core.data.source.remote

import android.util.Log
import com.okugata.sintaksys.core.data.source.remote.network.ApiResponse
import com.okugata.sintaksys.core.data.source.remote.network.ApiService
import com.okugata.sintaksys.core.data.source.remote.response.TextResponse
import com.okugata.sintaksys.domain.model.Text
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getCorrectedText(text: Text): Flow<ApiResponse<TextResponse>> {
        return flow {
            try {
                val response = apiService.getCorrectedText(text)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        const val TAG = "RemoteDataSource"
    }
}