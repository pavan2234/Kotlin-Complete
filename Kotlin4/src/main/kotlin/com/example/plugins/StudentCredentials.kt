package com.example.plugins

import kotlinx.serialization.Serializable
import org.mindrot.jbcrypt.BCrypt


@Serializable
data class  StudentCredentials(val name:String,val password:String){
    fun encryptedpassword():String{
        return BCrypt.hashpw(password,BCrypt.gensalt())
    }
}
