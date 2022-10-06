package com.tdl.motorinsurance.model

data class IDVDetails(
    val base_quote: String,
    val base_idv: String,
    val median_quote: String,
    val median_idv: String,
    val max_quote: String,
    val max_idv: String
)