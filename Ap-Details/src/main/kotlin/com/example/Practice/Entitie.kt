package com.example.Practice

import kotlinx.serialization.json.Json
import org.ktorm.schema.Table
import org.ktorm.schema.blob
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Mobiles: Table<Nothing>("hello"){
    val Phone= blob("mobile")
}