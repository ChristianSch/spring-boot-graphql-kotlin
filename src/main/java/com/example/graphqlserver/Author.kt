package com.example.graphqlserver

import java.util.*

@JvmRecord
data class Author(val id: String, val firstName: String, val lastName: String) {
    companion object {
        private val authors = Arrays.asList(
            Author("author-1", "Joshua", "Bloch"),
            Author("author-2", "Douglas", "Adams"),
            Author("author-3", "Bill", "Bryson")
        )

        @JvmStatic
        fun getById(id: String): Author? {
            return authors.stream()
                .filter { author: Author? -> author!!.id == id }
                .findFirst()
                .orElse(null)
        }
    }
}