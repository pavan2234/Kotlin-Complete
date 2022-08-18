package com.example

import kotlinx.serialization.Serializable
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping

@Serializable
data class Reservation(
    val restaurantId: Int,
    val reservationTime: String,
    val reservationDate: String,
    val noOfPeople: Int,
    val customerId: Int,
    val lastName: String,
    val firstName: String,
    val reservationNotes: String,
    val mobile: String,
    val landline: String,
    val email: String,
    val interfaceId: Int,
    val occasion: String,
    val eatNowFlag: Int,
    val sessionName: String,
    val sessionId: Int,
    val sourceApp: String,
    val packageName: String,
    val tableNo: String,
    val tableStatus: String,
    val waitListedFlag: Int,
    val strLocTitle: String
)

