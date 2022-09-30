package org.softwire.training.bookish.services;

import org.springframework.stereotype.Service;
import org.softwire.training.bookish.models.database.Copies;
import java.util.List;

@Service
public class CopiesService extends DatabaseService {
    public List<Copies> getAllCopies() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT*FROM copies")
                        .mapToBean(Copies.class)
                        .list()


        );
    }
}
