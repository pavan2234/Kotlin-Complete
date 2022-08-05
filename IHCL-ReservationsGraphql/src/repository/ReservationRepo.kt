package com.example.repository

import com.example.Models.Reservation
import com.example.DatabaseConfiguration.DatabaseConnection
import com.example.Entities.Reservations
import org.ktorm.database.Database
import org.ktorm.dsl.*

interface ReservartionRepo {
    fun gettingReservations():List<Reservation>
    //fun ReservationById(restaurantId: Column<Int>):List<Reservation>

    fun puttingReservations(reser: Reservation):List<Reservation>
}
class subReservation:ReservartionRepo{
    val db = DatabaseConnection.database
    override fun gettingReservations(): List<Reservation> {
        val gettingReservations = db.from(Reservations).select().map{
            row -> Reservations.createEntity(row)
        }
        return gettingReservations
    }

    override fun puttingReservations(reser: Reservation): List<Reservation> {
        val putres = db.insert(Reservations)

        return puttingReservations(reser)
    }


//    override fun ReservationById(restaurantId: Column<Int>): List<Reservation> {
//        val gettingById = db.from(Reservations).select().where{Reservations.restaurantId eq restaurantId}.
//        map { row -> Reservations.createEntity(row) }
//        return gettingById
//    }
}

private fun Database.insert(table: Reservations) {

}
