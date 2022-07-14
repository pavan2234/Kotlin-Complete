package com.example.Demo

import me.liuwj.ktorm.entity.Entity
//This is the entity reference.
interface Department:Entity<Department> {
    companion object: Entity.Factory<Department>()
    var id:Int
    var nam:String
    var locatio:String
}