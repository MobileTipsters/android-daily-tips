fun commitAllowingStateLoss(): Int = commitInternal(true)

fun commit() = commitInternal(false)

fun commitInternal(allowStateLoss: Boolean): Int {
    //...
    if (!allowStateLoss) {
        checkStateLoss()
    }
}
