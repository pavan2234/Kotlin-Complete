package ihcl.com.entity

import org.jetbrains.exposed.sql.Table

object Reservation : Table("reservations") {

    val restaurantId = integer("restaurantId")
    val reservationTime = varchar("reservationTime", 50)
    val reservationDate = varchar("reservationDate", 50)
    val noOfPeople = integer("noOfPeople")
    val customerId = integer("customerId")
    val lastName = varchar("lastName", 50)
    val firstName = varchar("firstName", 50)
    val reservationNotes = varchar("reservationNotes", 50)
    val mobile = varchar("mobile", 50)
    val landline = varchar("landline", 50)
    val email = varchar("email", 50)
    val interfaceId = integer("interfaceId")
    val occasion = varchar("occasion", 50)
    val eatNowFlag = integer("eatNowFlag")
    val sessionName = varchar("sessionName", 50)
    val sessionId = integer("sessionId")
    val sourceApp = varchar("sourceApp", 50)
    val packageName = varchar("packageName", 50)
    val tableNo = varchar("tableNo", 50)
    val tableStatus = varchar("tableStatus", 50)
    val waitListedFlag = integer("waitListedFlag")
    val strLocTitle = varchar("strLocTitle", 50)

    override val primaryKey = PrimaryKey(restaurantId)
}