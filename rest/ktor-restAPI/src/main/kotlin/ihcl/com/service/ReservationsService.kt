package ihcl.com.service

import ihcl.com.model.Reservations
import ihcl.com.repository.ReservationsRepository

class ReservationsService {

    private val reservationsRepository = ReservationsRepository()

    suspend fun makeReservation(params: Reservations): Reservations? {
        return reservationsRepository.makeReservation(params)
    }

    suspend fun getBookingHistory(): List<Reservations?> {
        return reservationsRepository.getBookingHistory()
    }

    suspend fun getBookingHistoryByRestaurantId(restaurantId: Int): Reservations? {
        return reservationsRepository.getBookingHistoryByRestaurantId(restaurantId)
    }
}

