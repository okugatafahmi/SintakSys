package com.okugata.sintaksys.core.utils

import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.core.data.source.remote.network.ApiResponse
import com.okugata.sintaksys.core.data.source.remote.response.TextResponse
import com.okugata.sintaksys.domain.model.Text

object DataMapper {
    fun apiResponseToResource(text: ApiResponse<TextResponse>): Resource<Text> =
        when(text) {
            is ApiResponse.Success -> Resource.Success(Text(text.data.message))
            is ApiResponse.Error -> Resource.Error(text.errorMessage)
            else -> Resource.Loading()
        }

}