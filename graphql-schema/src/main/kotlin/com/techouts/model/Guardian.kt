package com.techouts.model

import kotlinx.serialization.Serializable


@Serializable
data class Guardian(
    val name: String,
    val relationship: String
)
