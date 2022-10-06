package com.example

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.ktorm.database.Database


const val HIKARI_CONFIG_KEY = "ktor.hikariconfig"
object DBConfig {
    fun Application.initDB() {
        val configPath = environment.config.property(HIKARI_CONFIG_KEY).getString()
        val dbConfig = HikariConfig(configPath)
        val dataSource = HikariDataSource(dbConfig)
        val db = Database.connect(dataSource)
    }

//    fun getConnection(): Database {
//        return Database.connect(dataSource)
//    }
//    suspend fun <T> dbQuery(block: () -> T): T = withContext(Dispatchers.IO) {
//        getConnection().useTransaction {
//            block()
//        }
//    }

}