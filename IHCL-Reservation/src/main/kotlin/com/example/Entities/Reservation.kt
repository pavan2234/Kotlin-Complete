package com.example.Entities
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Reservation:Table<Nothing>("reservations") {
    val restaurantId=int("restaurantId").primaryKey()
    val reservationTime=varchar("reservationTime")
    val reservationDate=varchar("reservationDate")
    val noOfPeople=int("noOfPeople")
    val customerId=int("customerId")
    val lastName=varchar("lastName")
    val firstName=varchar("firstName")
    val reservationNotes=varchar("reservationNotes")
    val mobile=varchar("mobile")
    val landline=varchar("landline")
    val email=varchar("email")
    val interfaceId=int("interfaceId")
    val occasion=varchar("occasion")
    val eatNowFlag=int("eatNowFlag")
    val sessionName=varchar("sessionName")
    val sessionId=int("sessionId")
    val sourceApp=varchar("sourceApp")
    val packageName=varchar("packageName")
    val tableNo=varchar("tableNo")
    val tableStatus=varchar("tableStatus")
    val waitListedFlag=int("waitListedFlag")
    val strLocTitle=varchar("strLocTitle")
}