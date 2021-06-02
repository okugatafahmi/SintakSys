package com.okugata.sintaksys.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TextResponse(

	@field:SerializedName("message")
	val message: String
)
