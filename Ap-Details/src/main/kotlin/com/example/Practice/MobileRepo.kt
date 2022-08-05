package com.example.Practice

import com.example.dbconfig.DatabaseConnection
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

fun Application.MobleRepo(){
    val db=DatabaseConnection.database
    routing {
        get ("/MobileInsert"){
            val mobileDetails=call.receive<Phone>()
            val mobile=mobileDetails.mobile

            db.insert(Mobiles){
                set(it.Phone,mobile)
            }
            call.respondText("Success")
        }
    }
}// To parse the JSON, install jackson-module-kotlin and do:
//
//   val welcome = Welcome.fromJson(jsonString)

/*
import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.core.*
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.node.*
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.module.kotlin.*

val mapper = jacksonObjectMapper().apply {
    propertyNamingStrategy = PropertyNamingStrategy.LOWER_CAMEL_CASE
    setSerializationInclusion(JsonInclude.Include.NON_NULL)
}

data class Welcome (
    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val mobile: Mobile
) {
    fun toJson() = mapper.writeValueAsString(this)

    companion object {
        fun fromJson(json: String) = mapper.readValue<Welcome>(json)
    }
}

data class Mobile (
    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val id: String,

    @get:JsonProperty("Device", required=true)@field:JsonProperty("Device", required=true)
    val device: Device
)

data class Device (
    @get:JsonProperty("Device Name", required=true)@field:JsonProperty("Device Name", required=true)
    val deviceName: String,

    @get:JsonProperty("Price", required=true)@field:JsonProperty("Price", required=true)
    val price: String,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val rating: String,

    @get:JsonProperty("Category", required=true)@field:JsonProperty("Category", required=true)
    val category: String,

    @get:JsonProperty("Description", required=true)@field:JsonProperty("Description", required=true)
    val description: Description
)

data class Description (
    @get:JsonProperty("Network", required=true)@field:JsonProperty("Network", required=true)
    val network: List<String>,

    @get:JsonProperty("Launch", required=true)@field:JsonProperty("Launch", required=true)
    val launch: Launch,

    @get:JsonProperty("Body", required=true)@field:JsonProperty("Body", required=true)
    val body: Body
)

data class Body (
    @get:JsonProperty("Dimension", required=true)@field:JsonProperty("Dimension", required=true)
    val dimension: String,

    @get:JsonProperty("Weight", required=true)@field:JsonProperty("Weight", required=true)
    val weight: String,

    @get:JsonProperty("Build", required=true)@field:JsonProperty("Build", required=true)
    val build: String,

    @get:JsonProperty("Network", required=true)@field:JsonProperty("Network", required=true)
    val network: List<String>,

    @get:JsonProperty("Display", required=true)@field:JsonProperty("Display", required=true)
    val display: Display
)

data class Display (
    @get:JsonProperty("Type", required=true)@field:JsonProperty("Type", required=true)
    val type: String,

    @get:JsonProperty("Size", required=true)@field:JsonProperty("Size", required=true)
    val size: String,

    @get:JsonProperty("Resolution", required=true)@field:JsonProperty("Resolution", required=true)
    val resolution: String,

    @get:JsonProperty("Protection", required=true)@field:JsonProperty("Protection", required=true)
    val protection: List<String>
)

data class Launch (
    @get:JsonProperty("Announced Date", required=true)@field:JsonProperty("Announced Date", required=true)
    val announcedDate: String,

    @get:JsonProperty("Status", required=true)@field:JsonProperty("Status", required=true)
    val status: String
)
*/
