package extensions

//This method returns true if a string exists in an enum class. Otherwise, it returns false

inline fun <reified T : Enum<T>> enumContains(name: String): Boolean {
    return enumValues<T>().any { it.name == name }
}