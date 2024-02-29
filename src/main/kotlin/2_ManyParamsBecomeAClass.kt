@file:Suppress("FunctionName")
// 🟠 Example 2 - Many Parameters become a Data Class
// - If you have a function with many parameters, consider grouping them into a data class.

data class Person(
	var name: String,
	var age: Int,
	var address: String,
	var city: String,
	var state: String,
	var zip: String,
	var country: String
)

var person = Person(
	"John Doe",
	30,
	"123 Main St",
	"Anytown",
	"CA",
	"12345",
	"USA"
)

fun updatePerson(
	person: Person,
	updateName: Boolean,
	updateAge: Boolean,
	updateAddress: Boolean,
	updateCity: Boolean,
	updateState: Boolean,
	updateZip: Boolean,
	updateData: String
) {
	// Update the person (note: this is a simplified example, but code like this is common in the wild.)
	if(updateName) {
		person.name = updateData
	}
	if(updateAge) {
		person.age = updateData.toInt()
	}
	if(updateAddress) {
		person.address = updateData
	}
	if(updateCity) {
		person.city = updateData
	}
	if(updateState) {
		person.state = updateData
	}
	if(updateZip) {
		person.zip = updateData
	}
}

// 😕 Before
// - Note all the parameters, and the Kotlin compiler is complaining about calling with unnamed parameters.
fun example2_0_BadStyle() {
	updatePerson(person, true, false, false, false, false, false, "Jane Doe")

	println(person)
}

// 😐 A little better - use a data class for the parameters.
data class PersonUpdate(
	var name: Boolean,
	var age: Boolean,
	var address: Boolean,
	var city: Boolean,
	var state: Boolean,
	var zip: Boolean,
	var dataString: String,
	var dataInt: Int
)

fun updatePerson2(
	person: Person,
	update: PersonUpdate
) {
	// Update the person (note: this is a simplified example, but code like this is common in the wild.)
	if(update.name) {
		person.name = update.dataString
	}
	if(update.age) {
		person.age = update.dataInt
	}
	if(update.address) {
		person.address = update.dataString
	}
	if(update.city) {
		person.city = update.dataString
	}
	if(update.state) {
		person.state = update.dataString
	}
	if(update.zip) {
		person.zip = update.dataString
	}
}

fun example2_1_ALittleBetter() {
	val personUpdate = PersonUpdate(true, false, false, false, false, false, "Jane Doe", 0)
	updatePerson2(person, personUpdate)
}

// 😐 Better Still
// - Note the named parameters, but it's still a lot of parameters.
fun example2_2_BetterStyle() {
	updatePerson(
		person,
		updateName = true,
		updateAge = false,
		updateAddress = false,
		updateCity = false,
		updateState = false,
		updateZip = false,
		updateData = "Jane Doe"
	)

	println(person)
}

// 😊 Best
// - Because the `Person` class is a data class, we can use the `copy` method to create a new `Person` with the updated values.
fun example2_3_BestStyle() {
	person = person.copy(name = "Jane Doe")

	println(person)
}


fun main() {
	example2_0_BadStyle()

	example2_1_ALittleBetter()

	example2_2_BetterStyle()

	example2_3_BestStyle()
}
