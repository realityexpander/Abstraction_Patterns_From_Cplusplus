@file:Suppress("FunctionName")
// 🟠 Example 5 - Variable With Similar Names Become A Class
// - If you have variables with similar names, consider grouping them into a data class.
// - This is more common in the wild than one would first assume and comes directly from
//   the Procedural Programming paradigm.

// 😕 Before Example 0
fun example5_0_BadStyle() {
	val employeeName = "John"
	val employeeAge = 30
	val employeeSalary = 100_000
	val employeeTitle = "Software Engineer"

	println("Name: $employeeName, Age: $employeeAge, Salary: $employeeSalary, Title: $employeeTitle")
}



// 🙂 Better Style Example 1
// - Instead of using multiple variables, use a data class.
data class Employee(
	var name: String,
	var age: Int,
	var salary: Int,
	var title: String
)

fun example5_1_BetterStyle() {
	val employee = Employee("John", 30, 100_000, "Software Engineer")

	println("Name: ${employee.name}, Age: ${employee.age}, Salary: ${employee.salary}, Title: ${employee.title}")
}


// 😕 Before Style Example 2
fun example5_2_BadStyle() {

	val startVal: Int
	val endVal: Int
	val numPoints: Int
	val avg: Double
	val tolerance: Double

	val lat: Double
	val lon: Double
	val isVisible: Boolean
	val isSecure: Boolean

	// ... more code
}

// 🙂 Better Style Example 3
// - Clumps of variables that are related can be grouped into a data class.
data class DataPoint(
	var startVal: Int,
	var endVal: Int,
	var numPoints: Int,
	var avg: Double,
	var tolerance: Double,
)

data class Location(
	var lat: Double,
	var lon: Double,
	var isVisible: Boolean,
	var isSecure: Boolean
)

fun example5_3_BetterStyle() {
	val dataPoint = DataPoint(0, 100, 10, 50.0, 0.1)
	val location = Location(37.7749, 122.4194, isVisible=true, isSecure=true)

	// ... more code
}



fun main() {
	example5_0_BadStyle()

	example5_1_BetterStyle()
}