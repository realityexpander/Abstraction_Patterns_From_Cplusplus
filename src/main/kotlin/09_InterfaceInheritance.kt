@file:Suppress("FunctionName", "SpellCheckingInspection")
// 🟠 Example 9 - Interface Inheritance
// - In general, this is a bad idea as the subclasses can become
//   tightly coupled to the base class, and difficult to change as time goes on.
// - But if you need to do it, here's how:

// 😕 Before
// - 2 different functions used in the same way.

fun sum(a: Int, b: Int): Int {
	return a + b
}

fun add2(a: Int, b: Int, c: Int): Int {
	return a + b + c
}


fun example9_0_BadStyle() {

	// Two similar functions, used in the same way.
	println(sum(1, 2))
	println(add2(1, 2, 3))
}




// 🙂 Better - COP Style (But still "Class Oriented Programming")
// - Create an `base` class with the common function. Extend the class if you need specific functionality.
open class Adder {
	open fun add(a: Int, b: Int, c: Int): Int {
		return a + b
	}
}

class FancyAdder : Adder() {
	override fun add(a: Int, b: Int, c: Int): Int {
		return a + b + c
	}
}

open class SimpleAdder : Adder() {
	open fun add(a: Int, b: Int): Int {
		return super.add(a, b, 0)
	}
}

// This is OK for small project, but as soon as the project grows, this pattern leads
// to fragile code that is hard to maintain and understand.
//
// Coder Takes - Code Re-Use via Inheritance is ALWAYS BAD
// - https://youtu.be/DSGVejHG8MA


fun example9_1_BetterCOPStyle() {

	// The `FancyAdder` class uses the common base class `Adder` implementation.
	val fancyAdder = FancyAdder()
	println(fancyAdder.add(1, 2, 3))

	// The `SimpleAdder` class uses the common base class `Adder` implementation.
	val simpleAdder = SimpleAdder()
	println(simpleAdder.add(1, 2))
}




// ❤️ Best - BOOP Style (Back-to Object Oriented Programming)
// - Use interfaces to define common functionality.

interface CanSum {
	fun sum(a: Int, b: Int, c: Int): Int { // Kotlin allows for default implementations.
		return a + b + c
	}
}

interface HasNumberResult {
	fun result(): Int  // Anyone implementing this interface must provide a numerical result.
}

// - Create a class that implements the interface.
class FancySum(
	val a: Int,
	val b: Int,
	val c: Int
) : CanSum, HasNumberResult {

	override fun result(): Int {
		return sum(a, b, c)
	}

}

class SimpleSum(
	val a: Int,
	val b: Int
) : CanSum, HasNumberResult {

	override fun result(): Int {
		return sum(a, b, 0)
	}
}

fun example9_2_BestBOOPStyle() {

	// The `SimpleSum` class uses the common interface `CanSum` implementation.
	val simpleSum = SimpleSum(1, 2)
	println(simpleSum.result())

	// The `FancySum` class uses the common interface `CanSum` implementation.
	val fancySum = FancySum(1, 2, 3)
	println(fancySum.result())
}






































