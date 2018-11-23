//It can be more concise
val textView = TextView(this)
textview.visibility = View.VISIBLE
textview.text = "test"

//Efficient approach
val textView = TextView(this).apply {
    visibility = View.VISIBLE
    text = "test"
}