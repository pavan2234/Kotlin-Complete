package com.example.Entities

import com.example.Models.Reservation
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Reservations: BaseTable<Reservation>("reservations") {
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
    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean)=Reservation(
        restaurantId=row[restaurantId]?:0,
        reservationTime = row[reservationTime].toString(),
        reservationDate=row[reservationDate].toString(),
        noOfPeople=row[noOfPeople]?:0,
        customerId=row[customerId]?:0,
        lastName=row[lastName].toString(),
        firstName=row[firstName].toString(),
        reservationNotes=row[reservationNotes].toString(),
        mobile=row[mobile].toString(),
        landline=row[landline].toString(),
        email=row[email].toString(),
        interfaceId=row[interfaceId]?:0,
        occasion=row[occasion].toString(),
        eatNowFlag=row[eatNowFlag]?:0,
        sessionName=row[sessionName].toString(),
        sessionId=row[sessionId]?:0,
        sourceApp=row[sourceApp].toString(),
        packageName=row[packageName].toString(),
        tableNo=row[tableNo].toString(),
        tableStatus=row[tableStatus].toString(),
        waitListedFlag=row[waitListedFlag]?:0,
        strLocTitle=row[strLocTitle].toString()

    )
}