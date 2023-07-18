package com.example.graphqlserver

import java.time.LocalDate

@JvmRecord
data class Book(
    val id: String,
    val name: String,
    val pageCount: Int,
    val published: LocalDate,
    @JvmField val authorId: String
) {
    companion object {
        private val books = listOf(
            Book("book-1", "Effective Java", 416, LocalDate.of(2017, 12, 27), "author-1"),
            Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, LocalDate.of(1979, 10, 12), "author-2"),
            Book("book-3", "Down Under", 436, LocalDate.of(2000, 6, 6), "author-3")
        )

        @JvmStatic
        fun getById(id: String): Book? {
            return books.stream()
                .filter { book: Book? -> book!!.id == id }
                .findFirst()
                .orElse(null)
        }
    }
}
