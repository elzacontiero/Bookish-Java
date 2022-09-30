package org.softwire.training.bookish.models.database;

public class Book {

    private Integer BookID;
    private String title;
    private String author;
    private String isbn;
    private String category;

    public Integer getBookID() {
        return BookID;
    }

    public void setBookID(Integer bookID) {
        BookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookID='" + BookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
