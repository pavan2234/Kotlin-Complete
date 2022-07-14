package com.example.Interface

import me.liuwj.ktorm.entity.Entity

interface address:Entity<address> {
    companion object:Entity.Factory<address>()
    val addressid:Int
    val customerid:customer
    val vehicleid:vehicle
    val addr_line1:String
    val addr_line2:String
    val pincode:String
    val created_at:customer
    val updated_at:customer
}