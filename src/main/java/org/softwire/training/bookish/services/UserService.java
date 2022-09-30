package org.softwire.training.bookish.services;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService extends DatabaseService {
    public List<User> getAllUsers() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Users")
                        .mapToBean(User.class)
                        .list()
        );


    }

}





