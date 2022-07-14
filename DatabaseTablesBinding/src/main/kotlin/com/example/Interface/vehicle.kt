package com.example.Interface

import me.liuwj.ktorm.entity.Entity

interface vehicle:Entity<vehicle> {
    companion object:Entity.Factory<vehicle>()
    val vehicleid:Int
    val reg_number:String
    val customerid:customer
    val type:String
    val make:String
    val model:String
    val variant:String
    val reg_date:String
    val engine_number:String
    val chassis_number:String
    val created_at:customer
    val updated_at:customer
}