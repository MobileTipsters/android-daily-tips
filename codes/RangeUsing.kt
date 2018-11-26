// iterating in the range 1 to 100
for(i in 1..100) {..}

//iterating backwards, in the range 100 to 1
for(i in 100 downTo 1) {..}

//iterating over an array, getting every other element
val array = arrayOf("a", "b", "x")
for(i in 1 until array.size step 2) {..}

//iterating over an array with the item index and destructuring
for((index, element) in array.withIndex()) {..}

//iterating over a map
val map = mapOf(1 to "one", 2 to "two")
for ((key, value) in map) {..}
