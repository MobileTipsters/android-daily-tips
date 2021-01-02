fun main() {

}

val data = mutableListOf<Int>()

fun initData() {
    data.clear()
    System.gc()
    for (i in 0..1_000_000) {
        data.add(i)
    }
}

// When you process a bigger collection with more than one processing step,
// it will take more time.
fun processCollectionWithoutSequence() {
    data.filter { it % 2 == 0 }.forEach {

    }
}

// Use Sequence for bigger collections with more than one processing.

// Sequence are more efficient and faster for collection processing
// with more than single processing step.
fun processCollectionWithSequence() {
    data.asSequence().filter { it % 2 == 0 }.forEach {

    }
}