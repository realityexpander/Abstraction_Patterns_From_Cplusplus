import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.seconds

// 🟠 Example 0 - Magic Numbers
fun example00_magicNumbers() {

	// ⚠️ Don't use magic numbers, use named constants instead.
	//    - Magic numbers are numbers that appear in code without explanation.
	// Before
	val area = 3.14 * 5 * 5

	// After
	val pi = 3.14
	val radius = 5
	val area2 = pi * radius * radius


	// 🙂👍 OK to use 0 or 1 as a naked value, when it's used as an initial value or a loop counter.
	// 🙂👍 OK to use `i` as a loop counter, the fact that its a single letter is a clue that it's not important.
	for(i in 1..10) {
		println(i)
	}


	// ⚠️ Look for standard units of measure in libraries, like `Duration` instead of making your own.
	// Before
	val timeoutSeconds = 60
	val keepBackupDays = 7

	// After
	val timeoutDuration = 60.seconds
	val keepBackupDuration = 7.days
}

fun main() {
	example00_magicNumbers()
}