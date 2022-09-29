package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.models.page.BooksModel;
import org.softwire.training.bookish.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    // constructor
     @Autowired
     public BooksController(BookService bookService) {
         this.bookService = bookService;
     }

    @RequestMapping("")
    ModelAndView allBooks() {

        List<Book> allBooks = bookService.getAllBooks();

        BooksModel abm = new BooksModel();
        abm.setBooks(allBooks);

        return new ModelAndView("books", "abm", abm);
    }

}


