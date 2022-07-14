package ihcl.com.entity

import org.jetbrains.exposed.sql.Table

object Vehicle : Table("vehicles") {
    private val vehicle_id = integer("vehicle_id").autoIncrement()
    private val vehicle_brand = varchar("vehicle_brand", 30)
    private val manifacture_year = varchar("manifacture_year", 30)
    override val primaryKey = PrimaryKey(vehicle_id)
}