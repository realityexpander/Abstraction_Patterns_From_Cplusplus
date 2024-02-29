// 🟠 Example 1 - Many Constants instead of a Enum or Sealed Class
// - When you have a small number of constants, it's OK to use them directly.
// - When you have a large number of constants, use an enum or sealed class.

// Before
const val RTB = 1000  // Basic report
const val RTC = 2001  // customer-requested report
const val RTBC = 2002  // customer-requested, for a big customer
//const val RTCC = 2003  // customer-requested, for a cheap customer  // what happens to the `else` branch?

// Better
enum class ReportKind1 {
	Basic,
	Customer,
	BigCustomer,
	//CheapCustomer  // what happens to the `else` branch?
}

// Best
sealed class ReportKind2 {
	data object Basic : ReportKind2()
	data object Customer : ReportKind2()
	data object BigCustomer : ReportKind2()
	//data object CheapCustomer : ReportKind2()  // what happens to the `when` expression?
}

fun constToEnumToSealedClass() {

	// 😕 Before
	// Using constants directly.
	val reports0 = listOf(RTB, RTC, RTBC)
	for(report in reports0) {
		when (report) {
			RTB -> println("Basic Report")
			RTC -> println("Customer-requested Report")
			RTBC -> println("Customer-requested, for a big customer Report")
			else -> throw IllegalArgumentException("Unknown report type") // Must have an `else` branch. Can break at runtime.
		}
	}
	println() // blank line

	// 😐 Better
	// Using an enum. Expects an `else` branch to be present, can cause error at runtime.
	val reports1 = listOf(
		ReportKind1.Basic,
		ReportKind1.Customer,
		ReportKind1.BigCustomer
	)
	for(report in reports1) {
		when (report) {
			ReportKind1.Basic -> println("Basic Report")
			ReportKind1.Customer -> println("Customer-requested Report")
			ReportKind1.BigCustomer -> println("Customer-requested, for a big customer Report")
			// ‼️ Must have an `else` branch. Can break at runtime.
			else -> throw IllegalArgumentException("Unknown report type")
		}
	}
	println() // blank line

	// 😊 Best
	// Using a sealed class to enforce exhaustive checks at compile time.
	val reports2 = listOf(
		ReportKind2.Basic,
		ReportKind2.Customer,
		ReportKind2.BigCustomer
	)
	for(report in reports2) {
		when(report) {
			ReportKind2.Basic -> println("Basic Report")
			ReportKind2.Customer -> println("Customer-requested Report")
			ReportKind2.BigCustomer -> println("Customer-requested, for a big customer Report")
			// ❤️ Notice: no `else` needed, all cases are checked at compile time.
		}
	}
	println() // blank line
}


fun main() {
	constToEnumToSealedClass()
}