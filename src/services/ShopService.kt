package at.stefangaller.services



import at.stefangaller.data.Shop
import at.stefangaller.data.ShopEntity
import org.jetbrains.exposed.sql.transactions.transaction

class ShopService {

    fun getAllShops(): Iterable<Shop> = transaction {
        ShopEntity.all().map(ShopEntity::toShop)
    }

    fun addShop(shop: Shop) = transaction {
        ShopEntity.new {
            this.shopname = shop.shopname
            this.location = shop.location
            this.bookprice = shop.bookprice
        }
    }
    fun deleteShop(shopid: Int) = transaction {
        ShopEntity[shopid].delete()
    }
}