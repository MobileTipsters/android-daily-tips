val list = arrayListOf<Double>(2.0, 3.0, 7.0)
var sum = 0
list.forEach{
    sum += it.toInt()
}
println(sum/list.size) // 4
println(list.average().toInt()) // 4