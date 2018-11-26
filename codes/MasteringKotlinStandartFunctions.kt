class MyClass {
    fun test() {
        val str = "..."

        val result = str.xxx {
            print(this) //Receiver
            print(it) //Argument
            42 //Block return value
        }
    }
}