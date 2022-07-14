package ihcl.com.repository

import ihcl.com.dbconfig.DatabaseFactory
import ihcl.com.entity.Reservation
import ihcl.com.model.Reservations
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement

class ReservationsRepository {

    suspend fun makeReservation(params: Reservations): Reservations? {
        var statement: InsertStatement<Number>? = null
        DatabaseFactory.dbQuery {
            statement = Reservation.insert {
                it[restaurantId] = params.restaurantId
                it[reservationTime] = params.reservationTime
                it[reservationDate] = params.reservationDate
                it[noOfPeople] = params.noOfPeople
                it[customerId] = params.customerId
                it[lastName] = params.lastName
                it[firstName] = params.firstName
                it[reservationNotes] = params.reservationNotes
                it[mobile] = params.mobile
                it[landline] = params.landline
                it[email] = params.email
                it[interfaceId] = params.interfaceId
                it[occasion] = params.occasion
                it[eatNowFlag] = params.eatNowFlag
                it[sessionName] = params.sessionName
                it[sessionId] = params.sessionId
                it[sourceApp] = params.sourceApp
                it[packageName] = params.packageName
                it[tableNo] = params.tableNo
                it[tableStatus] = params.tableStatus
                it[waitListedFlag] = params.waitListedFlag
                it[strLocTitle] = params.strLocTitle
            }
        }
        return convertToReservations(statement?.resultedValues?.get(0))
    }

    private fun convertToReservations(row: ResultRow?): Reservations? {
        return if (row == null) null
        else Reservations(
            restaurantId = row[Reservation.restaurantId],
            reservationTime = row[Reservation.reservationTime],
            reservationDate = row[Reservation.reservationDate],
            noOfPeople = row[Reservation.noOfPeople],
            customerId = row[Reservation.customerId],
            lastName = row[Reservation.lastName],
            firstName = row[Reservation.firstName],
            reservationNotes = row[Reservation.reservationNotes],
            mobile = row[Reservation.mobile],
            landline = row[Reservation.landline],
            email = row[Reservation.email],
            interfaceId = row[Reservation.interfaceId],
            occasion = row[Reservation.occasion],
            eatNowFlag = row[Reservation.eatNowFlag],
            sessionName = row[Reservation.sessionName],
            sessionId = row[Reservation.sessionId],
            sourceApp = row[Reservation.sourceApp],
            packageName = row[Reservation.packageName],
            tableNo = row[Reservation.tableNo],
            tableStatus = row[Reservation.tableStatus],
            waitListedFlag = row[Reservation.waitListedFlag],
            strLocTitle = row[Reservation.strLocTitle]
        )
    }

    suspend fun getBookingHistory(): List<Reservations?> {
        var reservations = DatabaseFactory.dbQuery {
            Reservation.selectAll().map { convertToReservations(it) }
        }
        return reservations
    }

    suspend fun getBookingHistoryByRestaurantId(restaurantId: Int): Reservations? {
        var reservations = DatabaseFactory.dbQuery {
            Reservation.select { Reservation.restaurantId.eq(restaurantId) }
                .map { convertToReservations(it) }.singleOrNull()
        }
        return reservations
    }
}