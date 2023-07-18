package com.example.graphqlserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookController.class)
@Import(GraphQlConfig.class)
public class BookControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstBook() {
        this.graphQlTester
				.documentName("bookDetails")
				.variable("id", "book-1")
                .execute()
                .path("bookById")
                .matchesJson("""
                    {
                        "id": "book-1",
                        "name": "Effective Java",
                        "pageCount": 416,
                        "published": "2017-12-27",
                        "author": {
                          "firstName": "Joshua",
                          "lastName": "Bloch",
                          "socialMedia": "iam.com/jb"
                        }
                    }
                """);
    }
}
