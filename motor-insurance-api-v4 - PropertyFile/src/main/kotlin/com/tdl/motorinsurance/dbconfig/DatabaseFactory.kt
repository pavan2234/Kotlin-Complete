package com.tdl.motorinsurance.dbconfig

import com.tdl.motorinsurance.connection
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.ktorm.database.Database
import java.io.FileInputStream
import java.util.*


object DatabaseFactory {

    fun init(): Database {
        return Database.connect(hikari())
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()

//       val config = HikariConfig("C:/Users/d1/Kotlin-ktor/motor-insurance-api-v4 - PropertyFile/src/main/resources/dbconfig.properties")
//        Doesn't read the driver class directly due to lack of mapping

//-----------------------------PROPERTY FILE------------------------------------------------------------------------
        val fis = FileInputStream("C:/Users/d1/Kotlin-ktor/motor-insurance-api-v4 - PropertyFile/src/main/resources/dbconfig.properties")
        val prop = Properties()
        prop.load(fis)

        println(prop.getProperty("dataSourceClassName"))
        println(prop.getProperty("dataSource.jdbcUrl"))
        println(prop.getProperty("dataSource.user"))
        println(prop.getProperty("dataSource.password"))


        config.driverClassName = prop.getProperty("dataSourceClassName")
        config.jdbcUrl = prop.getProperty("dataSource.jdbcUrl")
        config.username = prop.getProperty("dataSource.user")
        config.password = prop.getProperty("dataSource.password")
        config.maximumPoolSize = 10
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.transactionIsolation = "TRANSACTION_READ_COMMITTED"
//-----------------------------------------------------------------------------------------------------------------

//-----------------------HARD CODING-------------------------------------------------------------------------------
//        config.driverClassName = "com.mysql.cj.jdbc.Driver"
//        config.jdbcUrl = "jdbc:mysql://localhost:3306/apidetails"
//        config.username="root"
//        config.password="root"
//        config.maximumPoolSize = 10
//        config.isAutoCommit = false
//        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
//        config.transactionIsolation = "TRANSACTION_READ_COMMITTED"
//----------------------------------------------------------------------------------------------------------------

//--------------------DOESNT READS THE PROPERTIES-----------------------------------------------------------------
//        config.driverClassName = "dataSourceClassName"
//        config.jdbcUrl = "dataSource.jdbcUrl"
//        config.username="dataSource.user"
//        config.password="dataSource.password"
//        config.maximumPoolSize = 10
//        config.isAutoCommit = false
//        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
//---------------------------------------------------------------------------------------------------------------



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

