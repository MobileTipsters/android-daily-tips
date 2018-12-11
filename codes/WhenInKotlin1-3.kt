/*
Starting in Kotlin 1.3, we can capture the value being
considered in when into a variable that is only in scope
for the when block! Now we can rewrite our example above 
into a single expression!
*/

when(val answer = theAnswer()){
	42 -> "You got the right answer!"
	else -> "Sorry, $answer is not correct"
}