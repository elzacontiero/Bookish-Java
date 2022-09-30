package org.softwire.training.bookish.models.database;

public class Copies {

    private String firstName;
    private String lastName;
    private Integer copyID;
    private String copyNumber;
    private Integer bookID;
    private Integer userID;
    private boolean isBorrowed;
    private String dueBackDate;
    private String title;

    @Override
    public String toString() {
        return "Copies{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", copyID=" + copyID +
                ", copyNumber='" + copyNumber + '\'' +
                ", bookID=" + bookID +
                ", userID=" + userID +
                ", isBorrowed=" + isBorrowed +
                ", dueBackDate='" + dueBackDate + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String getDueBackDate() {
        return dueBackDate;
    }

    public void setDueBackDate(String dueBackDate) {
        this.dueBackDate = dueBackDate;
    }

}
