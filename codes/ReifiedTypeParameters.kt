/*
 'reified' type is used to know the type without 
 passing the class as a parameter in a function.
*/

inline fun <reified T : Activity> Context.open() 
				= startActivity(Intent(this, T::class.java))

// usage
open<LoginActivity>()