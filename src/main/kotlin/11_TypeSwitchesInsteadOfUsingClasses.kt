@file:Suppress("FunctionName", "SpellCheckingInspection")

import java.util.*
import kotlin.collections.List

// 🟠 Example 11 - "Type Switches" into Classes


// 😕 Before - 100% Procedural Style
// - The code uses classes to represent different types.
// - This is a common pattern in Java & C++ and is pure Procedural style code.

// Create an enum class to represent the different types of reports.
enum class ReportType {
	Basic,
	Customer,
	BigCustomer
}

// Create a class to represent the report data.
data class ReportData(
	val header: String = "",
	val isHeaderNeeded: Boolean,
	val bodyLines: List<String> = emptyList(),
	val footer: String = "",
	val isFooterNeeded: Boolean,
	private val reportType: ReportType = ReportType.Basic
) {
	fun fetchReportType(): ReportType {
		return reportType
	}
}

// Create report data.
val salesReports = listOf(
	ReportData(
		"ReportData 1",
		isHeaderNeeded = true,
		bodyLines = listOf("Line 1", "Line 2", "Line 3"),
		"Footer 1",
		isFooterNeeded = true
	),
	ReportData(
		isHeaderNeeded = false,
		bodyLines = listOf("Line A", "Line B", "Line C"),
		isFooterNeeded = false
	)
)

fun printHeader(report: ReportData) {
	when(report.fetchReportType()) {
		ReportType.Basic -> {
			println("Header: ${report.header.uppercase()}")
		}
		ReportType.Customer -> {
			println("Header: ${report.header.lowercase()}")
		}
		ReportType.BigCustomer -> {
			println("Header: ${report.header.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}")
		}
		else -> throw IllegalArgumentException("Unknown report type")
	}
}

fun printBody(report: ReportData) {
	report.bodyLines.forEach { line ->
		when(report.fetchReportType()) {
			ReportType.Basic -> {
				println("Body: ${line.uppercase()}")
			}
			ReportType.Customer -> {
				println("Body: ${line.lowercase()}")
			}
			ReportType.BigCustomer -> {
				println("Body: ${line.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}")
			}
			else -> throw IllegalArgumentException("Unknown report type")
		}
	}
}

fun printFooter(report: ReportData) {
	when(report.fetchReportType()) {
		ReportType.Basic -> {
			println("Footer: ${report.footer.uppercase()}")
		}
		ReportType.Customer -> {
			println("Footer: ${report.footer.lowercase()}")
		}
		ReportType.BigCustomer -> {
			println("Footer: ${report.footer.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}")
		}
		else -> throw IllegalArgumentException("Unknown report type")
	}
}

fun example11_0_Before() {
	// Generate the reports.
	salesReports.forEach { report ->
		if(report.isHeaderNeeded) {
			printHeader(report)
		}

		printBody(report)

		if(report.isFooterNeeded) {
			printFooter(report)
		}

		println() // Add a new line between reports.
	}
}



// 🙂 Better - COP Style (Class Oriented Programming)
// - Use class structures & inheritance to represent the different types.

abstract class BaseReport(
	private val header: String = "",
	private val bodyLines: List<String> = emptyList(),
	private val footer: String = "",
) {
	fun generate() {
		if(isHeaderNeeded()) {
			doHeader()
		}

		bodyLines.forEach { line ->
			doLine(line)
		}

		if(isFooterNeeded()) {
			doFooter()
		}
	}

	open fun doHeader() {
		println("Header: $header")
	}

	open fun doLine(line: String) {
		println("Body: $line")
	}

	open fun doFooter() {
		println("Footer: $footer")
	}

	abstract fun isHeaderNeeded(): Boolean
	abstract fun isFooterNeeded(): Boolean
}

class BasicReport(
	header: String = "",
	bodyLines: List<String> = emptyList(),
	footer: String = "",
) : BaseReport(header, bodyLines, footer) {

	override fun isHeaderNeeded(): Boolean {
		return true
	}

	override fun isFooterNeeded(): Boolean {
		return true
	}
}

class CustomerReport(
	bodyLines: List<String> = emptyList(),
) : BaseReport(bodyLines = bodyLines) {

	override fun doLine(line: String) {
		println("Body: ${line.lowercase()}")
	}

	override fun isHeaderNeeded(): Boolean {
		return false
	}

	override fun isFooterNeeded(): Boolean {
		return false
	}
}

class BigCustomerReport(
	header: String = "",
	bodyLines: List<String> = emptyList(),
	footer: String = "",
) : BaseReport(header, bodyLines) {

	override fun doLine(line: String) {
		println("Body: ${line.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}")
	}

	override fun isHeaderNeeded(): Boolean {
		return true
	}

	override fun isFooterNeeded(): Boolean {
		return false
	}
}

// Create report data.
val salesReports2 = listOf(
	BasicReport(
		"ReportData 1",
		listOf("Line 1", "Line 2", "Line 3"),
		"Footer 1"
	),
	CustomerReport(
		listOf("Line A", "Line B", "Line C"),
	),
	BigCustomerReport(
		"ReportData for the Big Guy",
		listOf("Line X", "Line Y", "Line Z"),
	)
)

fun example11_1_BetterCOPStyle() {
	// Generate the reports.
	salesReports2.forEach { report ->
		report.generate()
		println() // Add a new line between reports.
	}
}



// ❤️ BOOP Style (Back-to Oriented Object Programming)
// - Use interfaces to define common functionality.
// - Operations are done lazily.
// - No need to pass data around like in the COP style.
// - No implementation inheritance is used, so it's easier to understand and maintain.

interface CanGenerate {
	fun generate()
}
interface CanDoHeader {
	fun doHeader()
}
interface CanDoLine {
	fun doLine(line: String)
}
interface CanDoFooter {
	fun doFooter()
}

open class BaseReport2(
	protected val header: String = "",
	private val bodyLines: List<String> = emptyList(),
	protected val footer: String = "",
) : CanGenerate, CanDoLine {

	override fun generate() {
		bodyLines.forEach { line ->
			doLine(line)
		}
	}

	override fun doLine(line: String) {
		println("Body: $line")
	}
}

class BasicReport2(
	header: String = "",
	bodyLines: List<String> = emptyList(),
	footer: String = "",
) : BaseReport2(header, bodyLines, footer),
	CanDoHeader,
	CanDoFooter
{
	override fun doHeader() {
		println("Header: $header")
	}

	override fun doFooter() {
		println("Footer: $footer")
	}

	override fun doLine(line: String) {
		println("Body: ${line.uppercase()}")
	}

	override fun generate() {
		println("Generating Basic Report")
		doHeader()
		super.generate()
		doFooter()
	}
}

class CustomerReport2(
	bodyLines: List<String> = emptyList(),
) : BaseReport2(bodyLines = bodyLines) {
	override fun doLine(line: String) {
		println("Body: ${line.lowercase()}")
	}

	override fun generate() {
		println("Generating Customer Report")
		super.generate()
	}
}

class BigReport2Customer(
	header: String = "",
	bodyLines: List<String> = emptyList(),
) : BaseReport2(header, bodyLines),
	CanDoHeader
{
	override fun doHeader() {
		println("Header: ${header.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}")
	}

	override fun doLine(line: String) {
		println("Body: ${line.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}")
	}

	override fun generate() {
		println("Generating Big Customer Report")
		doHeader()
		super.generate()
	}
}

// Create report data.
val salesReports3 = listOf(
	BasicReport2(
		"ReportData 1",
		listOf("Line 1", "Line 2", "Line 3"),
		"Footer 1"
	),
	CustomerReport2(
		listOf("Line A", "Line B", "Line C"),
	),
	BigReport2Customer(
		"ReportData for the Big Guy",
		listOf("Line X", "Line Y", "Line Z"),
	)
)

fun example11_2_BetterBOOPStyle() {

	// Generate the reports.
	salesReports3.forEach { report ->
		report.generate()
		println() // Add a new line between reports.R
	}
}


fun main() {
	example11_0_Before()
	println() // Add a blank line

	example11_1_BetterCOPStyle()
	println() // Add a blank line

	example11_2_BetterBOOPStyle()
	println() // Add a blank line
}


























































