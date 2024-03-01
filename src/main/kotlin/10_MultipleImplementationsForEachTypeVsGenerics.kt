@file:Suppress("FunctionName", "SpellCheckingInspection")
// 🟠 Example 10 - Multiple Implementations For Each Type Vs Generics


// 😕 Before
// - The code has multiple implementations for each type.
// - This is a common pattern in Java & C++ and Generics were introduced to solve this problem.

// - The `GenericList` interface has multiple implementations for each type.
class IntList {
	private val list = mutableListOf<Int>()

	fun add(item: Int) {
		list.add(item)
	}

	fun remove(item: Int) {
		list.remove(item)
	}

	fun fetch(index: Int): Int {
		return list[index]
	}
}

class StringList {
	private val list = mutableListOf<String>()

	fun add(item: String) {
		list.add(item)
	}

	fun remove(item: String) {
		list.remove(item)
	}

	fun fetch(index: Int): String {
		return list[index]
	}
}

fun example10_0_BadStyle() {
	val intList = IntList()
	intList.add(1)
	intList.add(2)
	intList.add(3)
	println(intList.fetch(1))
	println() // Blank line

	val stringList = StringList()
	stringList.add("A")
	stringList.add("B")
	stringList.add("C")
	println(stringList.fetch(1))
}



// 🙂 After
// - Use Generics to create a single implementation for each type.

class GenericList<T> {
	private val list = mutableListOf<T>()

	fun add(item: T) {
		list.add(item)
	}

	fun remove(item: T) {
		list.remove(item)
	}

	fun fetch(index: Int): T {
		return list[index]
	}
}

fun example10_1_GoodStyle() {
	val intGenericList = GenericList<Int>()  // Use the type "Int" for the generic "T".
	intGenericList.add(1)
	intGenericList.add(2)
	intGenericList.add(3)
	println(intGenericList.fetch(1))  // prints 2
	println() // Blank line

	val stringGenericList = GenericList<String>()  // Use the type "String" for the generic "T".
	stringGenericList.add("A")
	stringGenericList.add("B")
	stringGenericList.add("C")
	println(stringGenericList.fetch(1))  // prints "B"
	println() // Blank line
}



fun main() {
	example10_0_BadStyle()
	println() // Blank line

	example10_1_GoodStyle()
}