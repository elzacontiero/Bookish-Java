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
    public void addUser(User user) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO users (firstName,lastName,email,address,appliedFees) " +
                                "VALUES (:firstName,:lastName,:email,:address,:appliedFees)")
                        .bind("firstName", user.getFirstName())
                        .bind("lastName", user.getLastName())
                        .bind("email", user.getEmail())
                        .bind("address", user.getAddress())
                        .bind("appliedFees", user.getAppliedFees())
                        .execute()
        );
    }

    public void deleteUser(int userId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM users WHERE UserID = :id")
                        .bind("id", userId)
                        .execute()
        );
    }

}





