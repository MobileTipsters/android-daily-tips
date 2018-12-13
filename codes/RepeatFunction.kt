/*inline fun repeat(times: Int, action: (Int) -> Unit)
Executes the given function action specified number of times.
A zero-based index of current iteration is passed as a parameter to action.
*/

// Say awesome ten times
repeat(10) {
    println("Kotlin is Awesome!")
}

repeat(0) {
    error(""" ¯\_(ツ)_/¯ """)
}