package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService extends DatabaseService {
    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM books")
                        .mapToBean(Book.class)
                        .list()
        );
    }
}

