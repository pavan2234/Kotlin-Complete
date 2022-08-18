package com.example.DatabaseConfiguration

import com.example.connection
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.ktorm.database.Database

object DatabaseConnection {
fun init(): Database {
    return Database.connect(hikari())
}
    private fun hikari():HikariDataSource{
        val config = HikariConfig()
        config.driverClassName = "com.mysql.cj.jdbc.Driver"
        config.jdbcUrl = "jdbc:mysql://localhost:3306/karate"
        config.username="root"
        config.password="root"
        config.maximumPoolSize = 10
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }
    suspend fun <T> dbQuery(block: () -> T): T = withContext(Dispatchers.IO) {
        getConnection().useTransaction {
            block()
        }
    }
    fun getConnection():Database{
        return connection!!

    }

}