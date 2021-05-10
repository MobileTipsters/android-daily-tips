/*
 * Filtering Google Places Autocomplete Results
 */

/*
 * Field list to receive from the place instances
 */
val fields = listOf(
    Place.Field.NAME,
    Place.Field.ADDRESS,
    Place.Field.LAT_LNG
)

/*
 * Rectangular area bounds to filter place results
 */
val bounds = RectangularBounds.newInstance(
    LatLng(-33.880490, 151.184363),
    LatLng(-33.858754, 151.229596)
)

val placesBuilder = Autocomplete.IntentBuilder(
    AutocompleteActivityMode.OVERLAY,
    fields
)

/*
 * Filter places result by area bounds
 */
placesBuilder.setLocationBias(bounds)

/*
 * Filter places result by country code
 */
placesBuilder.setCountry("TR")

/*
 * Start places search intent
 */
startActivityForResult(placesBuilder.build(context), 1000)