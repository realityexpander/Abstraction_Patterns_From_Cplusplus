@file:Suppress("FunctionName")

import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.seconds

// 🟠 Example 0 - Magic Numbers
fun example00_0_magicNumbers() {

	// 😕 Before
	// ⚠️ Don't use magic numbers, use named constants instead.
	//    - Magic numbers are numbers that appear in code without explanation.
	val area = 3.14 * 5 * 5

	// 🙂 After
	val radius = 5
	val area2 = Math.PI * radius * radius
}

// 🟠 Example 1 - Single Character Variables & Naked 0's & 1's
fun example00_1_singleCharVars() {

	// 🙂👍 OK to use 0 or 1 as a naked value, when it's used as an initial value or a loop counter.
	// 🙂👍 OK to use single char `i` as a loop counter or index, the fact that its a single letter is a
	//      clue to the reader that it's not important.
	for(i in 1..10) {
		println(i)
	}
}

// 🟠 Example 2 - Use Standard Libraries
fun example00_2_UseStandardLibraries() {

	// 😕 Before
	// ⚠️ Look for standard units of measure in standard libraries, like kotlin's Time class `Duration`
	//    instead of making your own.
	val timeoutSeconds = 60
	val keepBackupDays = 7

	// 🙂 After
	val timeoutDuration = 60.seconds
	val keepBackupDuration = 7.days

	println("Timeout: $timeoutDuration, Keep Backup: $keepBackupDuration")
}

fun main() {
	example00_0_magicNumbers()

	example00_1_singleCharVars()

	example00_2_UseStandardLibraries()
}