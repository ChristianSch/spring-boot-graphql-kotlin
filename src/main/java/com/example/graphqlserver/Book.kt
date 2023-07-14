package com.example.graphqlserver

import java.util.*

@JvmRecord
data class Book(val id: String, val name: String, val pageCount: Int, @JvmField val authorId: String) {
    companion object {
        private val books = Arrays.asList(
            Book("book-1", "Effective Java", 416, "author-1"),
            Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            Book("book-3", "Down Under", 436, "author-3")
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
