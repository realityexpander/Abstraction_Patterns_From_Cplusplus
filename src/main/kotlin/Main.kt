package com.realityexpander

import constToEnumToSealedClass
import magicNumbers
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.seconds

// Based on this talk:
// Keynote: Abstraction Patterns - Kate Gregory - NDC TechTown 2022
// - https://www.youtube.com/watch?v=rfIX0FzKHF0

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
	magicNumbers()

	constToEnumToSealedClass()
}
