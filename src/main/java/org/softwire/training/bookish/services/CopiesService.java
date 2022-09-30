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
}
