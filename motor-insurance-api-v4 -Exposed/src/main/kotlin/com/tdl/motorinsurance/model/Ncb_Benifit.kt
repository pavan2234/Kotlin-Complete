package com.tdl.motorinsurance.model

data class Ncb_Benifit(
    val claimed_prev_year: Boolean,
    val prev_ncb: Int,
    val curr_ncb: Int
)
