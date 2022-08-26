
import com.example.entities.Kungfu
import org.jetbrains.exposed.sql.Table

object KaratesE: Table("trainees"){
    val id = integer("id")
    val name = varchar("name",50)
    val age = varchar("age",50)
    val area = varchar("area",50)
    val kungfu_id = integer("kungfu_id").uniqueIndex().references(Kungfu.kungfu_id)
}