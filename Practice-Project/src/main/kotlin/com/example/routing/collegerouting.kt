package com.example.routing

import com.example.model.CollegeINDVDTO
import com.example.model_joins.collegedetailDTO
import com.example.service.collegeservice
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import jdk.vm.ci.common.InitTimer.timer
import kotlin.concurrent.timer

fun Application.collegerouting(){
    val collegeserv = collegeservice()
    routing {
        route("/api/route/college"){
            post("/saveCollegeDetails") {
                val params = call.receive<collegedetailDTO>()
                var effectedlines = collegeserv.saveCollegeDetails(params)
                if (effectedlines == 0 ) call.respond("No data inserted")
                else {
                    call.respond("----------------Data Inserted ---------------")
                }
            }
            get("/getCollegeDetails") {
                call.respond(collegeserv.getCollegeDetails())
            }
            post("/saveINDVCollegeDetails") {
                val params = call.receive<CollegeINDVDTO>()
                var effectedlines = collegeserv.saveINDVCollegeDetails(params)
                if (effectedlines == 0 ) call.respond("No data inserted")
                else {
                    call.respond("----------------Data Inserted ---------------")
                }
            }
            get("/getINDVCollegeDetails") {
                call.respond(collegeserv.getINDVCollegeDetails())
            }
        }
    }
}