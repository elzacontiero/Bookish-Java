package org.softwire.training.bookish.controllers;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.BooksModel;
import org.softwire.training.bookish.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    // constructor
     @Autowired
     public BooksController(BookService bookService)  {
         this.bookService = bookService;
     }

    @RequestMapping("")
    ModelAndView allBooks() {

        List<Book> allBooks = bookService.getAllBooks();

        BooksModel booksModel = new BooksModel();
        booksModel.setBooks(allBooks);

        return new ModelAndView("books", "model", booksModel);
    }

    @RequestMapping("/add-book")
    RedirectView addBook(@ModelAttribute Book book) {

        bookService.addBook(book);

        return new RedirectView("/books");
    }

    @RequestMapping("/delete-book")
    RedirectView deleteBook(@RequestParam int bookId) {

        bookService.deleteBook(bookId);

        return new RedirectView("/books");
    }

}
