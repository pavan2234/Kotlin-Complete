package com.example.Practice

import kotlinx.serialization.Serializable

@Serializable
data class Phone (
    val mobile: PhoneList?=null
)

@Serializable
data class PhoneList (
    val id: String,
    val device: DeviceInfo?=null
)
@Serializable
data class DeviceInfo (
    val device_name: String?=null
)


