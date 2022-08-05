package com.example.Interface

import org.ktorm.entity.Entity

interface nominee : Entity<nominee> {
    val nomineeid:Int
    val customerid:customer
    val name:String
    val relationship:String
    val age:Int
    val guardian_name:String
    val guardian_relationShip:String
    val created_at: String
    val updated_at: String
    val icustomer: customer
}
