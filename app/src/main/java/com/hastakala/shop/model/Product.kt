package com.hastakala.shop.model

data class Product(
    val name: String,
    val emoji: String,
    val availableColors: List<String>
)

object ProductCatalog {
    val products = listOf(
        Product("Banana Fiber Bag", "👜", listOf("Red", "Blue", "Green", "Yellow", "Brown", "Black", "White", "Pink")),
        Product("Keychain", "🔑", listOf("Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Black", "White")),
        Product("Wallet", "💼", listOf("Brown", "Black", "Red", "Blue", "Green", "Tan")),
        Product("Basket", "🧺", listOf("Natural", "Red", "Blue", "Green", "Yellow", "Brown")),
        Product("Jewelry", "📿", listOf("Gold", "Silver", "Red", "Blue", "Green", "Multicolor")),
        Product("Mat", "🟫", listOf("Natural", "Red", "Blue", "Green", "Brown", "Multicolor")),
        Product("Pot Cover", "🏺", listOf("Natural", "Red", "Blue", "Green", "Yellow")),
        Product("Bookmark", "🔖", listOf("Red", "Blue", "Green", "Yellow", "Purple", "Orange"))
    )
}
