val spanned = spannable {
    bold("Sample Bold") +
    italic("And Italic Text") +
    color(Color.BLUE, "Blue Colored Text")
}

val nested = spannable{ bold(italic("nested ")) + url("www.google.com", "text") }

textView.text = spanned + nested

// Spannable.kt extension for further manipulations

import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.*

fun spannable(func: () -> SpannableString) = func()
private fun span(s: CharSequence, o: Any) = (if (s is String) SpannableString(s) else s as? SpannableString
    ?: SpannableString("")).apply { setSpan(o, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) }

operator fun SpannableString.plus(s: SpannableString) = SpannableString(TextUtils.concat(this, s))
operator fun SpannableString.plus(s: String) = SpannableString(TextUtils.concat(this, s))

fun bold(s: CharSequence) = span(s, StyleSpan(android.graphics.Typeface.BOLD))
fun italic(s: CharSequence) = span(s, StyleSpan(android.graphics.Typeface.ITALIC))
fun underline(s: CharSequence) = span(s, UnderlineSpan())
fun strike(s: CharSequence) = span(s, StrikethroughSpan())
fun sup(s: CharSequence) = span(s, SuperscriptSpan())
fun sub(s: CharSequence) = span(s, SubscriptSpan())
fun size(size: Float, s: CharSequence) = span(s, RelativeSizeSpan(size))
fun color(color: Int, s: CharSequence) = span(s, ForegroundColorSpan(color))
fun background(color: Int, s: CharSequence) = span(s, BackgroundColorSpan(color))
fun url(url: String, s: CharSequence) = span(s, URLSpan(url))
