@file:Suppress("FunctionName", "SpellCheckingInspection")
// 🟠 Example 8 - Hide Complexity Within Classes
// - Mixing procedural code with object-oriented code can make the code harder to understand and maintain.


// 😕 Before
// - The code mixes procedural code with object-oriented code.

class Report(
	val header: String = "",
	val isHeaderNeeded: Boolean,
	val bodyLines: kotlin.collections.List<String>,
	val footer: String = "",
	val isFooterNeeded: Boolean
) {
	fun doHeader() {
		println("Header: ${header.uppercase()}") // Make the header uppercase.
	}

	fun doLine(line: String) {
		println("Body: ${line.uppercase()}") // Make the line uppercase.
	}

	fun doFooter() {
		println("Footer: ${footer.uppercase()}") // Make the footer uppercase.
	}
}

val reports = listOf(
	Report(
		"Report 1",
		isHeaderNeeded = true,
		listOf("Line 1", "Line 2", "Line 3"),
		"Footer 1",
		isFooterNeeded = true
	),
	Report(
		isHeaderNeeded = false,
		bodyLines = listOf("Line A", "Line B", "Line C"),
		isFooterNeeded = false
	)
)

// Create a function to generate the report.
fun example08_0_BadStyle() {
	// Generate the reports.
	reports.forEach { report ->
		if(report.isHeaderNeeded) {  // <-- Procedural style code, why not encapsulate this in the class?
			report.doHeader()
		}

		report.bodyLines.forEach { line ->
			report.doLine(line) // <-- Procedural style code, why not encapsulate this in the class?
		}

		if(report.isFooterNeeded) {
			report.doFooter() // <-- Procedural style code, why not encapsulate this in the class?
		}
	}
}


// 🙂 Better
// - Encapsulate the procedural code inside the class.
class Report2(
	val header: String = "",
	val isHeaderNeeded: Boolean,
	val bodyLines: List<String>,
	val footer: String = "",
	val isFooterNeeded: Boolean
) {
	fun generate() {
		if(isHeaderNeeded) {
			doHeader()
		}

		bodyLines. forEach { line ->
			doLine(line)
		}

		if(isFooterNeeded) {
			doFooter()
		}
	}

	fun doHeader() {
		println("Header: ${header.uppercase()}") // Make the header uppercase.
	}

	fun doBody() {
		bodyLines.forEach { line ->
			doLine(line)
		}
	}

	private fun doLine(line: String) {
		println("Body: ${line.uppercase()}") // Make the line uppercase.
	}

	fun doFooter() {
		println("Footer: ${footer.uppercase()}") // Make the footer uppercase.
	}
}

val reports2 = listOf(
	Report2(
		"Report 1",
		isHeaderNeeded = true,
		listOf("Line 1", "Line 2", "Line 3"),
		"Footer 1",
		isFooterNeeded = true
	),
	Report2(
		isHeaderNeeded = false,
		bodyLines = listOf("Line A", "Line B", "Line C"),
		isFooterNeeded = false
	)
)

fun example08_1_BetterStyle() {
	// Generate the reports but still using procedural style.
	reports2.forEach { report ->
		report.doHeader()
		report.doBody()
		report.doFooter()
	}

	// This is more OOP style.
	reports2.forEach { report ->
		report.generate()
	}
}



fun main() {
	example08_0_BadStyle()
	println() // Add a blank line

	example08_1_BetterStyle()
}










































