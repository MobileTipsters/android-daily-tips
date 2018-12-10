fun foo(x: Any) {
    if (x is String) {
        print(x.length) // x is automatically cast to String
    }
}

// Such smart casts work for if statement or when-expressions as well:
if (x is String && x.length > 0) {
    print(x.length) // x is automatically cast to String
}

when (x) {
    is Int -> print(x+1)
    is String -> print(x.length+1)
    is IntArray -> print(x.sum())
}