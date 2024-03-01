@file:Suppress("FunctionName", "SpellCheckingInspection")

// 🟠 Example 7 - Comments On The Closing Brace
// - If you have a function becoming larger than a screenful, consider breaking it up into smaller functions.


// 😕 Before
// - Functions that are larger than a screenful are hard to understand and maintain.
fun example07_0_Before() {
	val x = 100
	val y = 200
	val z = 300
	val xyz = true

	// Prepare the calculation
	if(xyz) {
		val a = x * y
		val b = y * z
		val c = z * x
		// ... more than a screenful of code ...
		val e = x * y
		val d = a + b + c

		println("Preparation complete: $d")
	} // Prepare Calculation finished.

	// ... more than a screenful of code ...

	// Import the data
	if(xyz) {
		val xx = 100
		val yy = 200
		val zz = 300
		// ... more than a screenful of code ...
		val aa = x + y * z
		val bb = y * z

		// Scan Data for errors
		if(y > 100) {
			val a = x * y
			val b = y * z
			val c = z * x
			// ... more than a screenful of code ...
			val e = x * y
			val d = a + b + c
			val cc = z * x

			println("Data scanned: ${aa + bb + cc}")
		} // Scan Data finished.

		val a = x * y
		val b = y * z
		val c = z * x
		// ... more than a screenful of code ...
		val cc = z * x
		val dd = aa + bb + cc
		val ee = x * y

		println("Data imported: ${aa + bb + cc}")
	} // Import Data finished.
}



// 🙂 Better
// - Break the function into smaller functions.

fun prepareCalculation(x: Int, y: Int, z: Int, xyz: Boolean): Int {
	if(xyz) {
		val a = x * y
		val b = y * z
		val c = z * x
		// ... more than a screenful of code ...
		val e = x * y
		val d = a + b + c

		return d
	}

	return 0
}

fun scanDataForErrors(y: Int, xx: Int, yy: Int, zz: Int) {
	if(y > 100) {
		val a = xx * yy
		val b = yy * zz
		val c = zz * xx
		// ... more than a screenful of code ...
		val e = xx * yy
		val d = a + b + c
		val cc = zz * xx

		println("Data scanned: ${a + b + cc}")
	}
}

fun importData(xx: Int, yy: Int, zz: Int, xyz: Boolean): Int {
	if(xyz) {
		val aa = xx + yy * zz
		// ... more than a screenful of code ...
		val bb = yy * zz
		val cc2 = zz * xx

		// Scan Data for errors
		if(yy > 100) {
			val a = xx * yy
			val b = yy * zz
			val c = zz * xx

			scanDataForErrors(yy, xx, yy, zz)
		}
		val a = xx * yy
		val b = yy * zz
		val c = zz * xx
		// ... more than a screenful of code ...
		val cc = zz * xx
		val dd = aa + bb + cc
		val ee = xx * yy

		return aa + bb + cc
	}

	return 0
}

fun example07_1_Better() {
	val x = 100
	val y = 200
	val z = 300
	val xyz = true

	val d = prepareCalculation(x, y, z, xyz)
	println("Preparation complete: $d")

	val xx = 100
	val yy = 200
	val zz = 300
	val dd = importData(xx, yy, zz, xyz)
	println("Data imported: $dd")
}


fun main() {
	example07_0_Before()
	println() // Add a blank line

	example07_1_Better()
}


