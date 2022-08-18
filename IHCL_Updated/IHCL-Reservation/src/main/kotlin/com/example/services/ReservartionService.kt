package com.example.repositories


import com.example.entities.ReservationsI
import com.example.model.ReservationsDTO

class ReservartionService {
    private val ReservationRepo = ReservationRepository()

suspend fun ReservationInserting(params: ReservationsDTO):Int{
    return ReservationRepo.ReservationInserting(params)
}
    suspend fun getReservation():List<ReservationsI>{
        return ReservationRepo.getReservation()
    }
    suspend fun updateReservation(params: ReservationsDTO):Int{
        return ReservationRepo.updateReservation(params)
    }
    suspend fun deleteReservationByID(params: ReservationsDTO):Int{
        return ReservationRepo.deleteReservationByID(params)
    }
    suspend fun deleteByLastName(params: ReservationsDTO):Int{
        return ReservationRepo.deleteByName(params)
    }
}