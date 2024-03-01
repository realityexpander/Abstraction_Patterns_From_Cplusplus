@file:Suppress("FunctionName", "SpellCheckingInspection")

// 🟠 Example 6 - One Hundred Lines To A Function
// - If you have a function becoming larger than a screenful, consider breaking it up into smaller functions.

// 😕 Before
// - Functions that are larger than a screenful are hard to understand and maintain.
fun example06_0_Before() {

	// Prepare the calculation
	val x = 100
	val y = 200
	val z = 300
	// ... more than a screenful of code ...
	val a = x * y
	val b = y * z
	val c = z * x
	val d = a + b + c
	println("Preparation complete: $d")

	// Import the data
	val xx = 100
	val yy = 200
	val zz = 300
	val aa = x + y * z
	// ... more than a screenful of code ...
	val bb = y * z
	val cc = z * x
	println("Data imported: ${aa + bb + cc}")

	// Setup the configuration
	val xxx = 100
	val yyy = 200
	val zzz = 300
	val aaa = x + y * z
	// ... more than a screenful of code ...
	val bbb = y * z
	val ccc = z * x
	println("Configuration complete: ${aaa + bbb + ccc}")

	// Output to the database
	val xxxx = 100
	val yyyy = 200
	val zzzz = 300
	val aaaa = x + y * z
	// ... more than a screenful of code ...
	val bbbb = y * z
	val cccc = z * x
	println("Output to the database: ${aaaa + bbbb + cccc}")
}


// 🙂 After
// - Break the function into smaller functions.
fun example06_1_Better() {
	val x = 100
	val y = 200
	val z = 300
	val d = prepareCalculation(x, y, z)
	println("Preparation complete: $d")

	val xx = 100
	val yy = 200
	val zz = 300
	val dd = importData(xx, yy, zz)
	println("Data imported: $dd")

	val xxx = 100
	val yyy = 200
	val zzz = 300
	val ddd = setupConfiguration(xxx, yyy, zzz)
	println("Configuration complete: $ddd")

	val xxxx = 100
	val yyyy = 200
	val zzzz = 300
	val dddd = outputToDatabase(xxxx, yyyy, zzzz)
	println("Output to the database: $dddd")
}

fun prepareCalculation(x: Int, y: Int, z: Int): Int {
	// ... more than a screenful of code ...
	val a = x * y
	val b = y * z
	val c = z * x
	return a + b + c
}

fun importData(xx: Int, yy: Int, zz: Int): Int {
	val aa = xx + yy * zz
	// ... more than a screenful of code ...
	val bb = yy * zz
	val cc = zz * xx
	return aa + bb + cc
}

fun setupConfiguration(xxx: Int, yyy: Int, zzz: Int): Int {
	val aaa = xxx + yyy * zzz
	// ... more than a screenful of code ...
	val bbb = yyy * zzz
	val ccc = zzz * xxx
	return aaa + bbb + ccc
}

fun outputToDatabase(xxxx: Int, yyyy: Int, zzzz: Int): Int {
	val aaaa = xxxx + yyyy * zzzz
	// ... more than a screenful of code ...
	val bbbb = yyyy * zzzz
	val cccc = zzzz * xxxx
	return aaaa + bbbb + cccc
}



fun main() {
	example06_0_Before()
	println() // Add a blank line

	example06_1_Better()
}