package edu.cc231008.bookstoreapp.data.repo



data class BookTemplate(
    val title: String,
    val subtitle: String,
    val isbn13: String,
    val price: String,
    val image: String,
    val url: String,
    val desc: String,
    val authors: String,
    val pages: String,
    val rating: String
)

data class WishlistTemplate(
    val id: Int,
    val isbn13: String,
    val title: String,
    val subtitle: String,
    val price: String,
    val image: String,
    val url: String
)

data class CartTemplate(
    val id: Int,
    val isbn13: String,
    val title: String,
    val subtitle: String,
    val price: String,
    val image: String,
    val url: String
)


data class CommentTemplate(
    val id: Int,
    val isbn13: String,
    val comment: String,
    val createdAt: Long
)
