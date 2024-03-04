@file:Suppress("FunctionName", "SpellCheckingInspection")

// 🟠 Example 9 - Implementation Inheritance should only be used with extreme caution
// - In general, this is a bad idea as the subclasses can become
//   tightly coupled to the base class, and difficult to change as time goes on.
// - But if you need to do it, here's how:


// 😕 Before - Procedural Style with 2 different functions used in the same way.

fun sum(a: Int, b: Int): Int {
	return a + b
}

fun add3(a: Int, b: Int, c: Int): Int {
	return a + b + c
}


fun example09_0_Before() {
	// Two similar functions, used in the same way.
	println(sum(1, 2))

	println(add3(1, 2, 3))
}



// 🙂 Better - COP Style (But still "Class Oriented Programming")
// - Create an `base` class with the common function. Extend the class if you need specific functionality.
// - The `class` is simply a container for the function, and it encapsulates no data. This is COP style.
open class Adder {
	open fun add(a: Int, b: Int, c: Int): Int {
		return a + b
	}
}

class FancyAdder : Adder() {
	override fun add(a: Int, b: Int, c: Int): Int {
		return super.add(a, b, c)  // uses the common base class `Adder` implementation.
	}
}

class SimpleAdder : Adder() {
	fun add(a: Int, b: Int): Int {
		return super.add(a, b, 0)  // uses the common base class `Adder` implementation.
	}
}

// This is OK for small project, but as soon as the project grows, this pattern leads
// to fragile code that is hard to maintain and understand.
//
// Coder Takes - Code Re-Use via Inheritance is ALWAYS BAD
// - https://youtu.be/DSGVejHG8MA


fun example09_1_BetterCOPStyle() {

	// The `FancyAdder` class uses the common base class `Adder` implementation.
	val fancyAdder = FancyAdder()
	println(fancyAdder.add(1, 2, 3))

	// The `SimpleAdder` class uses the common base class `Adder` implementation.
	val simpleAdder = SimpleAdder()
	println(simpleAdder.add(1, 2))
}



// ❤️ Best - BOOP Style (Back-to Object Oriented Programming)
// - Use interfaces to define common functionality.
// - Calculations are done lazily.
// - Data is encapsulated in the class, and not passed around like in the COP style.

interface CanSum {
	fun sum(a: Int, b: Int, c: Int): Int { // Kotlin allows for default implementations.
		return a + b + c
	}
}

interface HasIntegerResult {
	fun result(): Int  // Any class implementing this interface must provide an integer result.
}

// - Create a class that implements the interface.
class FancySum(
	private val a: Int,
	private val b: Int,
	private val c: Int
) : CanSum, HasIntegerResult {

	override fun result(): Int {
		return sum(this.a, this.b, this.c)  // uses implementation from the CanSum interface.
	}
}

class SimpleSum(
	val a: Int,
	val b: Int
) : CanSum, HasIntegerResult {

	override fun result(): Int {
		return sum(this.a, this.b, 0)   // uses implementation from the CanSum interface.
	}
}

fun example09_2_BestBOOPStyle() {

	// The `SimpleSum` class uses the common interface `CanSum` implementation.
	val simpleSum = SimpleSum(1, 2)
	println(simpleSum.result())

	// The `FancySum` class uses the common interface `CanSum` implementation.
	val fancySum = FancySum(1, 2, 3)
	println(fancySum.result())
}

fun main() {
	example09_0_Before()
	println() // Blank line

	example09_1_BetterCOPStyle()
	println() // Blank line

	example09_2_BestBOOPStyle()
	println() // Blank line
}




































