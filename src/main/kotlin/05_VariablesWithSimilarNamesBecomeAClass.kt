@file:Suppress("FunctionName")

// 🟠 Example 5 - Variable With Similar Names Become A Class
// - If you have variables with similar names, consider grouping them into a data class.
// - This is more common in the wild than one would first assume and comes directly from
//   the Procedural Programming paradigm.


// 😕 Before Example 0
fun example05_0_Before() {
	val employeeName = "John"
	val employeeAge = 30
	val employeeSalary = 100_000
	val employeeTitle = "Software Engineer"

	println("Name: $employeeName, Age: $employeeAge, Salary: $employeeSalary, Title: $employeeTitle")
}


// 🙂 Better Example 0
// - Instead of using multiple variables, use a data class.
data class Employee(
	var name: String = "",
	var age: Int = 0,
	var salary: Int = 0,
	var title: String = ""
)

fun example05_0_Better() {
	val employee = Employee("John", 30, 100_000, "Software Engineer")

	println("Name: ${employee.name}, Age: ${employee.age}, Salary: ${employee.salary}, Title: ${employee.title}")
}



// 😕 Before Example 1
fun example05_1_Before() {

	val startVal: Int = 0
	val endVal: Int = 100
	val numPoints: Int = 10
	val avg: Double = 50.0
	val tolerance: Double = 0.1

	val lat: Double = 37.7749
	val lon: Double = 122.4194
	val isVisible: Boolean = true
	val isSecure: Boolean = false

	// ... more code

	println("startVal: $startVal, endVal: $endVal, numPoints: $numPoints, avg: $avg, tolerance: $tolerance")
	println("lat: $lat, lon: $lon, isVisible: $isVisible, isSecure: $isSecure")
}


// 🙂 Better Example 1
// - Clumps of variables that are related can be grouped into a data class.
data class DataPoint(
	var startVal: Int,
	var endVal: Int,
	var numPoints: Int,
	var avg: Double,
	var tolerance: Double
)

data class Position(
	var lat: Double = 0.0,
	var lon: Double = 0.0,
	var isVisible: Boolean = false,
	var isSecure: Boolean = false
)

fun example05_1_Better() {
	val dataPoint = DataPoint(0, 100, 10, 50.0, 0.1)
	val position = Position(37.7749, 122.4194, isVisible=true, isSecure=true)

	// ... more code
	println("startVal: ${dataPoint.startVal}, endVal: ${dataPoint.endVal}, numPoints: ${dataPoint.numPoints}, avg: ${dataPoint.avg}, tolerance: ${dataPoint.tolerance}")
	println("lat: ${position.lat}, lon: ${position.lon}, isVisible: ${position.isVisible}, isSecure: ${position.isSecure}")
}



fun main() {
	example05_0_Before()
	example05_0_Better()
	println() // Add a blank line

	example05_1_Before()
	example05_1_Better()
}