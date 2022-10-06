package com.example.databaseconfig

import com.example.connection
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.ktorm.database.Database
import java.io.FileInputStream
import java.util.*

object DatabaseFactory{
    fun init():Database{
        return Database.connect(hikari())
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()

        //HARD CODING FOR DATABASE CONNECTION
//        config.jdbcUrl ="jdbc:mysql://localhost:3306/Practice"
//        config.driverClassName="com.mysql.cj.jdbc.Driver"
//        config.username="root"
//        config.password="root"
//        config.isAutoCommit = false
//        config.maximumPoolSize = 10
//        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"

//        ------------------------Property file database connection----------------------------------
        val fis = FileInputStream("C:/Users/d1/Kotlin-ktor/motor-insurance-api-v4 - PropertyFile/src/main/resources/dbconfig.properties")
        val prop = Properties()
        prop.load(fis)

        config.driverClassName = prop.getProperty("dataSourceClassName")
        config.jdbcUrl = prop.getProperty("dataSource.jdbcUrl")
        config.username = prop.getProperty("dataSource.user")
        config.password = prop.getProperty("dataSource.password")
        config.maximumPoolSize = 10
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.transactionIsolation = "TRANSACTION_READ_COMMITTED"
//        --------------------------------------------------------------------------------------------------


        config.validate()

        return HikariDataSource(config)
    }

    suspend fun <T> dbQuery(block: () -> T): T = withContext(Dispatchers.IO) {
        getConnection().useTransaction {
            block()
        }
    }

    fun getConnection(): Database {
        return connection!!
    }
}