package com.example.model


import kotlinx.serialization.Serializable

@Serializable
data class karateDTO(
    val id: Int,
    val name: String,
    val age: String,
    val area: String,
    val kungfu_id:Int,
    val kungfu:KungfuDTO
)
