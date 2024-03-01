@file:Suppress("FunctionName")

// 🟠 Example 3 - Fix Deceptive Parameter Lists
// - If you have a function with many parameters, consider grouping them into a data class.



// 😕 Before
fun drawRect(
	x: Int,
	y: Int,
	width: Int,
	height: Int,
	fill: Boolean,
	color: String,
	border: Boolean,
	borderColor: String
) {
	// Draw the rectangle
	println("Drawing a rectangle at ($x, $y) with width $width and height $height")
	println("Fill: $fill, Color: $color, Border: $border, Border Color: $borderColor")
}

// The problem is the call side. It's hard to remember the order and meaning of the parameters.
fun example03_0_Before() {
	drawRect(10, 10, 100, 100, true, "blue", true, "black")
}



// 😊 Better
data class Rectangle(
	var x: Int,
	var y: Int,
	var width: Int,
	var height: Int,
	var fill: Boolean,
	var color: String,
	var border: Boolean,
	var borderColor: String
)

fun drawRect(rect: Rectangle) {
	// Draw the rectangle
	println("Drawing a rectangle at (${rect.x}, ${rect.y}) with width ${rect.width} and height ${rect.height}")
	println("Fill: ${rect.fill}, Color: ${rect.color}, Border: ${rect.border}, Border Color: ${rect.borderColor}")
}

fun example03_1_Better() {

	// Create a rectangle object.
	val rect = Rectangle(
		10,
		10,
		100,
		100,
		true,
		"blue",
		true,
		"black")

	// Pass in the object, instead of the parameters.
	drawRect(rect)
}

fun main() {
	example03_0_Before()

	example03_1_Better()
}