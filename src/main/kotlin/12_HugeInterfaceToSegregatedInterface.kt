// 🟠 Example 12 - Huge Interface To Segregated Interface
// - Large number of definitions in a single interface makes the intent of the interface unclear.
// - "Segregate" (separate) the interface into smaller, more focused interfaces.

// 😕 Before - Huge Interface
// - The interface is huge and it's purpose is unclear.

interface Text {
	fun getX(): Int
	fun getY(): Int
	fun setX(x: Int)
	fun setY(y: Int)
	fun getForegroundColor(): Int
	fun getBackgroundColor(): Int
	fun setForegroundColor(color: Int)
	fun setBackgroundColor(color: Int)
	fun getFont(): String
	fun setFont(font: String)
	fun getText(): String
	fun setText(text: String)
}



// 🙂 After - Segregated Interface
// - The interface is now segregated into smaller, more focused interfaces.

interface Location {
	fun getX(): Int
	fun getY(): Int
	fun setX(x: Int)
	fun setY(y: Int)
}
interface Color {
	fun getForegroundColor(): Int
	fun getBackgroundColor(): Int
	fun setForegroundColor(color: Int)
	fun setBackgroundColor(color: Int)
}
interface Font {
	fun getFont(): String
	fun setFont(font: String)
}
interface Content {
	fun getText(): String
	fun setText(text: String)
}
