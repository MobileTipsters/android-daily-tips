/* hashcode() for Nullable Types in Kotlin 1.3 */
public inline fun Any?.hashcode(): Int = this?.hashcode() ?: 0
val myHashCode: Int myObject.hashcode()