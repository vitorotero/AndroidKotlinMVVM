package br.com.tecapp.personproject.shared.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("") var id: Long,
    @SerializedName("") var format: String,
    @SerializedName("") var fileName: String,
    @SerializedName("") var author: String,
    @SerializedName("") var authorUrl: String,
    @SerializedName("") var postUrl: String
)