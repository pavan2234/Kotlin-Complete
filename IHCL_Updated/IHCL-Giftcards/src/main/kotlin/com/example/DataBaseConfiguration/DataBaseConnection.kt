package com.example.DataBaseConfiguration

import com.example.connection
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.ktorm.database.Database

//object DataBaseConnection {
//    val url="jdbc:mysql://localhost:3306/ihcl"
//    val driver="com.mysql.cj.jdbc.Driver"
//    val user="root"
//    val password="root"
//    val database= Database.connect(url, driver, user, password)
//}

object DataBaseConnection {

    fun init():Database{
        return Database.connect(hikari())
    }

    private fun hikari():HikariDataSource{
        val config = HikariConfig()
        config.driverClassName="com.mysql.cj.jdbc.Driver"
        config.jdbcUrl="jdbc:mysql://localhost:3306/ihcl"
        config.username="root"
        config.password="root"
        config.maximumPoolSize=10
        config.isAutoCommit=false
        config.transactionIsolation="TRANSACTION_REPEATABLE_READ"
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
