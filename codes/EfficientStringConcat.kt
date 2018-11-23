val names = listOf("John", "Jane", "Micheal")
var allNames = ""

//WRONG WAY
names.forEach { name ->
    allNames += name
}

//RIGHT WAY
val nameBuilder = StringBuilder()
names.forEach { name ->
    nameBuilder.append(name)
}
