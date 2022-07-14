package com.example.com.org.grapql

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.com.Server.DataBaseConnection
import com.example.com.Server.Employe
import com.example.com.Server.employetableobj
import com.example.com.org.DataBase.Repo
import com.example.com.org.DataBase.SubEmployee
import com.example.com.org.models.Employee
import com.example.com.org.models.UserInput

fun SchemaBuilder.schemaValues(){
    val db = DataBaseConnection.database
    val employeeobj:Repo= SubEmployee()
    /*
   type<Employee>(){
       description="Employees details"
   }
    inputType<UserInput> {
        description="hellooo"
    }
    type<Employee> {
        description="Heee"
    }*/
   /* query("Emp"){
        description="All Employees Details..."
        resolver { ->

        }
    }*/

    query("AllEmployee"){
        description="Getting all the employees details..."
        resolver { ->
            employeeobj.AllEmployees()
//            "Hii Babu"
         }
    }
    query("employeeById"){
        description="getting Employee details By Id reference..."
        resolver { id:String->employeeobj.employeeById(id) }
    }
    query("employeeByName"){
        description="getting Employee details By Name reference..."
        resolver { name:String->
            employeeobj.employeeByName(name)
        }
    }
    query("employeeBySalary"){
        description="getting Employee details By Salary reference..."
        resolver { salary:Int->
            employeeobj.employeeBySalary(salary)
        }
    }
    mutation("CreateEmployee"){
        description="Create A new Employee...."
        resolver { Userinput:UserInput->
           // val id=java.util.UUID.randomUUID().toString()
            val employee=Employee(Userinput.id,Userinput.Name,Userinput.Salary)
            employeeobj.createEmployee(employee)
            true
        }
    }
//    mutation("DeleteEmployee"){
//        description="Reoving a employee....."
//        resolver { Userinput:UserInput->
//            val employee=Employee(Userinput.id,Userinput.Name,Userinput.Salary)
//            employeeobj.deleteEmployee()
//        }
//    }
}