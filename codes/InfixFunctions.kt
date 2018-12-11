/*
Infix functions are good for readability, because it allows
typing something like "test" foo "x" for example.
*/
infix fun String.foo(s: String) {
	// do stg
}

// Call extension function
"test".foo("x")

// Or call extension function using infix notation.
"test" foo "x"