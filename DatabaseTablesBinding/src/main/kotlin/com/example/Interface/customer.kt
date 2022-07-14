package com.example.Interface

import me.liuwj.ktorm.entity.Entity

interface customer:Entity<customer> {
    companion object:Entity.Factory<customer>()
    val customerid:Int
    val cust_hash:String
    val name:String
    val phone_number:String
    val email:String
    val created_at:String
    val updated_at:String
}