package com.example.Entities

import com.example.Entities.Reservation.primaryKey
import com.example.Models.ReservationsI
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object ReservationBinding: Table<ReservationsI>("reservations") {
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