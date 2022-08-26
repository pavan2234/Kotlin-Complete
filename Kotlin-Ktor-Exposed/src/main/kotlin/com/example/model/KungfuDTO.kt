package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class KungfuDTO(
    val kungfu_id: Int,
    val name: String,
    val age: String,
    val area: String
)