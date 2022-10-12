package at.stefangaller.data
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

data class Shop(
    val shopid:Int,
    val shopname: String,
    val location: String,
    val bookprice: String
)

object Shops:IntIdTable(){
    val shopid = integer("shopid")
    val shopname = varchar("shopname",450)
    val location = varchar("location",450)
    val bookprice = varchar("bookprice",450)
}

class ShopEntity(shopid: EntityID<Int>):IntEntity(shopid){
    companion object : IntEntityClass<ShopEntity>(Shops)
    var shopid by Shops.shopid
    var shopname by Shops.shopname
    var location by Shops.location
    var bookprice by Shops.bookprice

    override fun toString(): String = "Shop($shopid,$shopname,$location,$bookprice)"
    fun toShop() = Shop(shopid,shopname,location,bookprice)
}