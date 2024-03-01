@file:Suppress("FunctionName")

// 🟠 Example 4 - Return Parameters Replaced With A Type
// - If you have a function that returns multiple parameters, consider returning a data class.

// 👎 From C++, writing result values into a class that is passed as a parameter is a common pattern.
// - This is should be avoided in modern languages. This was a hack in C++ to return multiple values due to language limitations.
// - In Kotlin, you can return a data class instead of multiple parameters.
data class OutParams( // Captures the result of a function.
	var value1: Double,
	var value2: Double,
)

fun calculateCircleStats0(radius: Double, outParams: OutParams) {
	val area = Math.PI * radius * radius
	val circumference = 2 * Math.PI * radius
	val diameter = 2 * radius

	outParams.value1 = area
	outParams.value2 = circumference
}

fun example04_0_CPlusPlusStyle() {
	val outParams = OutParams(0.0, 0.0)
	calculateCircleStats0(10.0, outParams)

	println("Area: ${outParams.value1}, Circumference: ${outParams.value2}")
}



// 😕 Before
// - Using a "Pair" or "Triple" is a common pattern in Kotlin, but it's not recommended.
fun calculateCircleStats1(radius: Double): Triple<Double, Double, Double> {
	val area = Math.PI * radius * radius
	val circumference = 2 * Math.PI * radius
	val diameter = 2 * radius

	return Triple(area, circumference, diameter)
}

fun example04_1_BadStyle() {
	val (area, circumference, diameter) = calculateCircleStats1(10.0)

	println("Area: $area, Circumference: $circumference, Diameter: $diameter")
}



// 🙂 Better
// - Instead of returning multiple parameters, return a data class.
data class CircleStats(
	var area: Double,
	var circumference: Double,
	var diameter: Double
)

fun calculateCircleStats2(radius: Double): CircleStats {
	val area = Math.PI * radius * radius
	val circumference = 2 * Math.PI * radius
	val diameter = 2 * radius

	return CircleStats(area, circumference, diameter)
}

fun example04_2_betterStyle() {
	val circleStats = calculateCircleStats2(10.0)

	println("Area: ${circleStats.area}, Circumference: ${circleStats.circumference}, Diameter: ${circleStats.diameter}")
}



// 👍 Bonus: The "Optional" idea
// - Instead of "throwing errors" the return type contains the error OR the value.
// - This is a common pattern in Kotlin, and it's called "Result, "Optional" or "Either".
data class Result<out T>(val value: T?, val error: String?)

fun divide(a: Double, b: Double): Result<Double> {
	if (b == 0.0) {
		return Result(null, "Cannot divide by zero")
	}
	return Result(a / b, null)
}

fun example04_3_Optional() {
	val result = divide(10.0, 0.0)

	if (result.error != null) {
		println("Error: ${result.error}") // Error handling is easier and faster than "throwing exceptions."
	} else {
		println("Result: ${result.value}")
	}
}




fun main() {
	example04_0_CPlusPlusStyle()

	example04_1_BadStyle()

	example04_2_betterStyle()

	example04_3_Optional()
}