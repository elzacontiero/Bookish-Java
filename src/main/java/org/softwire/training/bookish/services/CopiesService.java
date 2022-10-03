package org.softwire.training.bookish.services;

import org.springframework.stereotype.Service;
import org.softwire.training.bookish.models.database.Copies;
import java.util.List;

@Service
public class CopiesService extends DatabaseService {
    public List<Copies> getAllCopies() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT\n" +
                                "    CopyID, CopyNumber, COPIES.BookID, books.title, Users.UserID, FirstName, LastName,IsBorrowed, DueBackDate\n" +
                                "FROM copies\n" +
                                "join Books\n" +
                                "    on COPIES.BookID = Books.BookID\n" +
                                "join Users\n" +
                                "     on COPIES.UserID = Users.UserID")
                        .mapToBean(Copies.class)
                        .list()
        );
    }

    public void addCopy(Copies copy) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO copies (copyNumber,bookID,userID,isBorrowed,dueBackDate) VALUES (:copyNumber,:bookID,:userID,:isBorrowed,:dueBackDate)")
                        .bind("copyNumber", copy.getCopyNumber())
                        .bind("bookID", copy.getBookID())
                        .bind("userID", copy.getUserID())
                        .bind("isBorrowed", copy.getIsBorrowed())
                        .bind("dueBackDate", copy.getDueBackDate())
                        .execute()
        );
    }

    public void deleteCopies(int copyId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM copies WHERE CopyID = :id")
                        .bind("id", copyId)
                        .execute()
        );
    }
}
