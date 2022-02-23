package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContainerServiceTest {

    @Test
    @DisplayName("BookRepository 인스턴스 생성 - 성공")
    public void bookRepository_getObject() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    @DisplayName("BookService 인스턴스 생성 및 BookRepository 객체 주입 - 성공")
    public void bookServ_getObject() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }
}