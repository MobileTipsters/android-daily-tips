sealed class Operation {
    class Add(val value: Int) : Operation()
    class Substract(val value: Int) : Operation()
    class Multipy(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
}

fun execute(x: Int, operation: Operation) = when (operation) {
    is Operation.Add -> x + operation.value
    is Operation.Substract -> x - operation.value
    is Operation.Multipy -> x * operation.value
    is Operation.Divide -> x / operation.value
}