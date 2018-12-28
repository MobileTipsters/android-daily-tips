/*
random() extension functions for collections, ranges,
and arrays in Kotlin 1.3
*/

// Pick a random element from a List
val contestants = listOf("Todd", "Anna", "Emma")
println("Winner: ${contestants.random()}")

// Generate a String or random letters
val randomWordLetters = 'A' .. 'Z'
val randomWord = (0..10).map { randomWordLetters.random() }
						.joinToString(separator = "")
println(randomWord)						