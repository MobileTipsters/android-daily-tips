fun getPrimaryColor(context: Context): Int {
    val typedValue = TypedValue()
    val typedArray = context.obtainStyledAttributes(typedValue.data, intArrayOf(R.attr.colorPrimary))
    val color = typedArray.getColor(0, 0)
    typedArray.recycle()
    return color
}