package at.stefangaller.data

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Books : IntIdTable() {
    val title = varchar("title", 255)
    val author = varchar("author", 255)
    val shopidb = integer("shopidb")
}

class BookEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BookEntity>(Books)

    var title by Books.title
    var author by Books.author
    var shopidb by Books.shopidb

    override fun toString(): String = "Book($title, $author,$shopidb)"

    fun toBook() = Book(id.value, title, author,shopidb)
}

data class Book(
    var id: Int,
    val title: String,
    val author: String,
    val shopidb: Int
)