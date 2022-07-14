package com.example.Repositories

import com.example.DatabaseConfiguration.DataBaseConnection
import com.example.Entities.ReservationBinding
import com.example.Models.ReservationsI
import org.ktorm.dsl.*
import org.ktorm.schema.Column

interface ReservartionRepository {
    fun gettingReservations():List<ReservationsI>
    fun ReservationById(restaurantId: Column<Int>):List<ReservationsI>
}
class subReservation:ReservartionRepository{
    val db = DataBaseConnection.database
    override fun gettingReservations(): List<ReservationsI> {
        val gettingReservations = db.from(ReservationBinding).select().
                map { row -> ReservationBinding.createEntity(row) }
        return gettingReservations
    }

    override fun ReservationById(restaurantId: Column<Int>): List<ReservationsI> {
        val gettingById = db.from(ReservationBinding).select().where{ReservationBinding.restaurantId eq restaurantId}.
                map { row -> ReservationBinding.createEntity(row) }
        return gettingById
    }
}