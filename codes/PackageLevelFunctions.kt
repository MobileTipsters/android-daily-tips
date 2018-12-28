// Kotlin provides package-level functions succeeding static methods in Java with a more practical way.

// Just create a .kt file in a convenient package. Then implement like below:
package com.example.app

fun sum(a: Int, b: Int) {
    return a + b
}

// Finally, call them from any classes 
// You need to import the function (IDE will help you):
import com.example.app.sum

sum(2 + 1)
