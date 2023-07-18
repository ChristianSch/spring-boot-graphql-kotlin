package com.example.graphqlserver

import java.util.*

@JvmRecord
data class Author(val id: String, val firstName: String, val lastName: String, val socialMedia: String) {
    companion object {
        private val authors = Arrays.asList(
            Author("author-1", "Joshua", "Bloch", "iam.com/jb"),
            Author("author-2", "Douglas", "Adams", "iam.com/da"),
            Author("author-3", "Bill", "Bryson", "iam.com/bb")
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