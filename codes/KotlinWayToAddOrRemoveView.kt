inline operator fun ViewGroup.minusAssign(child: View) = removeView(child)

inline operator fun ViewGroup.plusAssign(child: View) = addView(child)