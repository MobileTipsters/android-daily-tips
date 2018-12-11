/*
    Type aliases provide alternative names for existing types. If the type name is too long you can introduce a different shorter name and use the new one instead.
 */

interface RestaurantPatron { // For example, take a gander at this.
    fun makeReservation(restaurant: Organization<(Currency, Coupon?) -> Sustenance>)
    fun visit(restaurant: Organization<(Currency, Coupon?) -> Sustenance>)
    fun complainAbout(restaurant: Organization<(Currency, Coupon?) -> Sustenance>)
}

// Create a typealias
typealias Restaurant = Organization<(Currency, Coupon?) -> Sustenance>

// That's all!!
interface RestaurantPatron {
    fun makeReservation(restaurant: Restaurant)
    fun visit(restaurant: Restaurant)
    fun complainAbout(restaurant: Restaurant)
}