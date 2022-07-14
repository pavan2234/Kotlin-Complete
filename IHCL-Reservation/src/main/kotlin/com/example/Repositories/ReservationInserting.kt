package com.example.Repositories

import com.example.DatabaseConfiguration.DataBaseConnection
import com.example.Entities.Reservation
import com.example.Entities.Reservation.tableNo
import com.example.Models.Reservations
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

fun Application.ReservationInserting(){
    val db =DataBaseConnection.database
    routing {
        get("/ReservationInserting") {
            val reservationDetails = call.receive<Reservations>()
            val restaurantId= reservationDetails.restaurantId
            val reservationTime= reservationDetails.reservationTime
            val reservationDate= reservationDetails.reservationDate
            val noOfPeople= reservationDetails.noOfPeople
            val customerId= reservationDetails.customerId
            val lastName= reservationDetails.lastName
            val firstName= reservationDetails.firstName
            val reservationNotes= reservationDetails.reservationNotes
            val mobile= reservationDetails.mobile
            val landline= reservationDetails.landline
            val email= reservationDetails.email
            val interfaceId= reservationDetails.interfaceId
            val occasion= reservationDetails.occasion
            val eatNowFlag= reservationDetails.eatNowFlag
            val sessionName= reservationDetails.sessionName
            val sessionId= reservationDetails.sessionId
            val sourceApp= reservationDetails.sourceApp
            val packageName= reservationDetails.packageName
            val tableNo = reservationDetails.tableNo
            val tableStatus= reservationDetails.tableStatus
            val waitListedFlag= reservationDetails.waitListedFlag
            val strLocTitle= reservationDetails.strLocTitle

            db.insert(Reservation){
                set(it.restaurantId,restaurantId)
                set(it.reservationTime,reservationTime)
                set(it.reservationDate,reservationDate)
                set(it.noOfPeople,noOfPeople)
                set(it.customerId,customerId)
                set(it.lastName,lastName)
                set(it.firstName,firstName)
                set(it.reservationNotes,reservationNotes)
                set(it.mobile,mobile)
                set(it.landline,landline)
                set(it.email,email)
                set(it.interfaceId,interfaceId)
                set(it.occasion,occasion)
                set(it.eatNowFlag,eatNowFlag)
                set(it.sessionName,sessionName)
                set(it.sessionId,sessionId)
                set(it.sourceApp,sourceApp)
                set(it.packageName,packageName)
                set(it.tableNo,tableNo)
                set(it.tableStatus,tableStatus)
                set(it.waitListedFlag,waitListedFlag)
                set(it.strLocTitle,strLocTitle)
            }
            call.respondText("Successfully inserted.....")
        }
    }
}