@file:Suppress("FunctionName", "SpellCheckingInspection")
// 🟠 Example 10 - Multiple Implementations For Each Type Vs Generics

// 😕 Before
// - The code has multiple implementations for each type.
// - This is a common pattern in Java & C++ and Generics were introduced to solve this problem.

// - The `List2` interface has multiple implementations for each type.
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

	 val stringList = StringList()
	 stringList.add("A")
	 stringList.add("B")
	 stringList.add("C")

	 println(stringList.fetch(1))
}

// 🙂 After
// - Use Generics to create a single implementation for each type.

class List2<T> {
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
	 val intList2 = List2<Int>()  // Use the type "Int" for the generic "T".
	 intList2.add(1)
	 intList2.add(2)
	 intList2.add(3)

	 println(intList2.fetch(1))  // prints 2

	 val stringList2 = List2<String>()  // Use the type "String" for the generic "T".
	 stringList2.add("A")
	 stringList2.add("B")
	 stringList2.add("C")

	 println(stringList2.fetch(1))  // prints "B"
}