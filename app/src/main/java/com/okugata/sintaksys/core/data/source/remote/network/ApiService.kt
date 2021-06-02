package com.okugata.sintaksys.core.data.source.remote.network

import com.okugata.sintaksys.core.data.source.remote.response.TextResponse
import com.okugata.sintaksys.domain.model.Text
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("grammar-api/")
    suspend fun getCorrectedText(
        @Body text: Text
    ): TextResponse
}