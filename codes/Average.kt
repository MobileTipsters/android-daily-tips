val list = arrayListOf<Double>(2.0, 3.0, 7.0)
var average = 0
list.forEach{
    average += it.toInt()
}
println(average/list.size) // 4
println(list.average().toInt()) // 4