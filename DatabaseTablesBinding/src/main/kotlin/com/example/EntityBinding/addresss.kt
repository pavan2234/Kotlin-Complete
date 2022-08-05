package com.example.EntityBinding

import com.example.Interface.address
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object addresss:Table<address>("address") {
    val addressid=int("addressid").primaryKey().bindTo { it.addressid }
    val customerid=int("customer_id").references(customers){it.customerid}
    val vehicleid=int("vehicle_id").references(vehicles){it.vehicleid}
    val addr_line1=varchar("addr_line1").bindTo { it.addr_line1 }
    val addr_line2=varchar("addr_line2").bindTo { it.addr_line2 }
    val pincode=varchar("pincode").bindTo { it.pincode }
    val created_at=varchar("created_at").references(customers){it.created_at}
    val updated_at=varchar("updated_at").references(customers){it.updated_at}
}