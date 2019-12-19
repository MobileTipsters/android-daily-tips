package katas.`3kyu`

import java.util.*
import kotlin.coroutines.*

fun plus(o1: Optional<Int>, o2: Optional<Int>): Optional<Int> = `for` {
    val i1: Int = bind(o1)
    val i2: Int = bind(o2)
    yield(i1 + i2)
}

suspend fun <T> bind(value: Optional<T>): T {
    return suspendCoroutine { cont ->
        if (value.isPresent)
            cont.resumeWith(Result.success(value.get()))
        else
            cont.resumeWith(Result.failure(fail()))
    }
}

fun <T> yield(value: T) = Optional.of(value)

fun <T> `for`(lambda: suspend () -> Optional<T>): Optional<T> {
    var ret: Optional<T> = Optional.empty()
    val completion: Continuation<Optional<T>> = object : Continuation<Optional<T>> {
        override val context: CoroutineContext = EmptyCoroutineContext

        override fun resumeWith(result: Result<Optional<T>>) {
            ret = result.getOrElse {
                when (it) {
                    is NoSuchElementException -> Optional.empty()
                    else -> throw it
                }
            }
        }
    }
    lambda.startCoroutine(completion)
    return ret
}

fun fail() = Exception()

