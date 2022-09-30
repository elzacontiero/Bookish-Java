package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Copies;
import java.util.List;

public class CopiesModel {
    private List<Copies> copies;

    public List<Copies> getCopies() {
        return copies;
    }

    public void setCopies(List<Copies> copies) {
        this.copies = copies;
    }
}

