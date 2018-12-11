/*
By using tailrec we let the compiler know that it can replace
the method call with a for loop or goto statement.

You can only use it if the last call in a function is only calling
itself and only itself.
*/
tailrec fun findFixPoint(x: Double = 1.0): Double
		= if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))