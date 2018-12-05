// Using Parcelable in Kotlin

@Parcelize
data class Student(val id: String, val name: String, val grade: String) : Parcelable

//For Using @Parcelize annotation add the code below into your gradle.

androidExtensions {
    experimental = true
}
