interface Mapper<T, R> {
    operator fun invoke(input: T): R
}

data class UserRaw(
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("age") val age: Int,
    @SerializedName("height") val height: Int
)

data class User(
    val name: String,
    val surname: String,
    val age: Int,
    val height: Int
)

data class UserViewItem(
    val name: String,
    val surname: String,
    val age: String
)

class UserDomainMapper : Mapper<UserRaw, User> {
    override fun invoke(input: UserRaw) = with(input) {
        User(name, surname, age, height)
    }
}

class UserViewItemMapper : Mapper<User, UserViewItem> {
    override fun invoke(input: User) = with(input) {
        UserViewItem(name, surname, age.toString())
    }
}
