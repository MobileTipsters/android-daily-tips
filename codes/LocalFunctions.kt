/*
Local functions are good for code reuse,
just be careful not to overuse them to avoid confusion.
*/
fun foo(a: Int) {
	fun local(b: Int) {
		return a + b
	}
	return local(1)
}