/**
 * Marks the JVM backing field of the annotated property as transient,
 * meaning that it is not part of the default serialized form of the object.
 *
 * When to use?
 * For example it can be used for request classes.
 * Transient values will be ignored on your POST request.
 */

@Parcelize
@JsonClass(generateAdapter = true)
data class FilterRequest(
        @Json(name = "color")
        var color: String? = null,
        @Json(name = "sort")
        var sort: String? = null,
        @Json(name = "currency")
        val currency: String? = null,
        @Json(name = "lang")
        val lang: String? = null,
        @Transient // Ignored when converted to Json value.
        var selectedStartDate: LocalDate? = null,
        @Transient // Ignored when converted to Json value.
        var selectedEndDate: LocalDate? = null
) : Parcelable