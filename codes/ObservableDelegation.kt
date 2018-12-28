/* Kotlin Delegated Properties - Observable
Delegates.observable() takes two arguments: the initial value and a handler
for modifications.The handler gets called every time we assign to the property */
class User {
    var name: String by Delegates.observable("no name") {
        prop, old, new ->
        println("$old -> $new")
    }
}
fun main() {
    val user = User()
    user.name = "first"
    user.name = "second"
}
/* Output:
no name -> first
first -> second */
/* Users Adapter */
internal var userList: List<User> by Delegates.observable(emptyList()) {
    _, _, _ -> notifyDataSetChanged()
}
/* When your data reached or changed just assign the list.
It will call notifyDataSetChanged() */
