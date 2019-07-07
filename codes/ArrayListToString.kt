//Easiest way to create string from array with separator

fun main(args: Array<String>) {
    val productIdsArray : ArrayList<String> = ArrayList<String>()
    productIdsArray.add("190")
    productIdsArray.add("191")
    productIdsArray.add("192")
    productIdsArray.add("193")
    productIdsArray.add("194")
    productIdsArray.add("195")

    val productIdsString = productIdsArray.joinToString(separator = ",")
    println(productIdsString)
}