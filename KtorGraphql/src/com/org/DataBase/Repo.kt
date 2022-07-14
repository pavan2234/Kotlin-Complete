package com.example.com.org.DataBase
import com.example.com.org.models.Employee
import com.example.com.org.models.UserInput

interface Repo {
    fun createEmployee(employee: Employee)
    fun deleteEmployee(id: String)
    fun AllEmployees(): List<Employee>
    fun employeeById(id: String): List<Employee>
    fun employeeByName(name: String): List<Employee>
    fun employeeBySalary(salary: Int): List<Employee>
    fun updateEmployee(id: String, userinput: UserInput)
}

class SubEmployee:Repo{
    override fun createEmployee(employee: Employee) {
        employees.add(employee)
    }

    override fun deleteEmployee(id: String) {
        employees.removeIf{it.id == id}
    }

    override fun AllEmployees(): List<Employee> {
        return employees
    }

    override fun employeeById(id: String): List<Employee> {
        return employees.filter { it.id==id }
    }

    override fun employeeByName(name: String): List<Employee> {
        return employees.filter { it.name==name }
    }

    override fun employeeBySalary(salary: Int): List<Employee> {
        return  employees.filter { it.salary==salary }
    }

    override fun updateEmployee(id: String,Userinput:UserInput) {
        employees.find { it.id==id }?.apply {
          name=Userinput.Name
            salary=Userinput.Salary
        }
    }
}