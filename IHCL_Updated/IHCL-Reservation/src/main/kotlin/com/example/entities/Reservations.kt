package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface ReservationsI:Entity<ReservationsI> {
    val restaurantId: Int
    val reservationTime: String
    val reservationDate: String
    val noOfPeople: Int
    val customerId: Int
    val lastName: String
    val firstName: String
    val reservationNotes: String
    val mobile: String
    val landline: String
    val email: String
    val interfaceId: Int
    val occasion: String
    val eatNowFlag: Int
    val sessionName: String
    val sessionId: Int
    val sourceApp: String
    val packageName: String
    val tableNo: String
    val tableStatus: String
    val waitListedFlag: Int
    val strLocTitle: String
}

object Reservations: Table<ReservationsI>("reservations") {
    val restaurantId=int("restaurantId").primaryKey().bindTo { it.restaurantId }
    val reservationTime=varchar("reservationTime").bindTo { it.reservationTime }
    val reservationDate=varchar("reservationDate").bindTo { it.reservationDate }
    val noOfPeople=int("noOfPeople").bindTo { it.noOfPeople }
    val customerId=int("customerId").bindTo { it.customerId }
    val lastName=varchar("lastName").bindTo { it.lastName }
    val firstName=varchar("firstName").bindTo { it.firstName }
    val reservationNotes=varchar("reservationNotes").bindTo { it.reservationNotes }
    val mobile=varchar("mobile").bindTo { it.mobile }
    val landline=varchar("landline").bindTo { it.landline }
    val email=varchar("email").bindTo { it.email }
    val interfaceId=int("interfaceId").bindTo { it.interfaceId }
    val occasion=varchar("occasion").bindTo { it.occasion }
    val eatNowFlag=int("eatNowFlag").bindTo { it.eatNowFlag }
    val sessionName=varchar("sessionName").bindTo { it.sessionName }
    val sessionId=int("sessionId").bindTo { it.sessionId }
    val sourceApp=varchar("sourceApp").bindTo { it.sourceApp}
    val packageName=varchar("packageName").bindTo { it.packageName }
    val tableNo=varchar("tableNo").bindTo { it.tableNo }
    val tableStatus=varchar("tableStatus").bindTo { it.tableStatus }
    val waitListedFlag=int("waitListedFlag").bindTo { it.waitListedFlag }
    val strLocTitle=varchar("strLocTitle").bindTo { it.strLocTitle }
}