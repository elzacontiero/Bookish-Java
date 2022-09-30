package org.softwire.training.bookish.models.database;

public class Copies {

    private Integer copyID;
    private String copyNumber;
    private Integer bookID;
    private Integer userID;
    private String isBorrowed;
    private String dueBackDate;

    public Integer getCopyID() {
        return copyID;
    }

    public void setCopyID(Integer copyID) {
        this.copyID = copyID;
    }

    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(String isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String getDueBackDate() {
        return dueBackDate;
    }

    public void setDueBackDate(String dueBackDate) {
        this.dueBackDate = dueBackDate;
    }

    @Override
    public String toString() {
        return "Copies{" +
                "copyID=" + copyID +
                ", copyNumber='" + copyNumber + '\'' +
                ", bookID=" + bookID +
                ", userID=" + userID +
                ", isBorrowed='" + isBorrowed + '\'' +
                ", dueBackDate='" + dueBackDate + '\'' +
                '}';
    }
}
