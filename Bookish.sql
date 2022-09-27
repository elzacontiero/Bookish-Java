Create DATABASE Bookish;

Use Bookish;

CREATE TABLE Books(
                      BookID integer  PRIMARY KEY,
                      title varchar(250),
                      author varchar(255),
                      isbn varchar(30),
                      category varchar(50)
);

CREATE TABLE Users(
                        UserID integer PRIMARY KEY,
                        FirstName varchar (255),
                        LastName varchar (255),
                        Email varchar(300),
                        Address varchar(300),
                        AppliedFees Decimal(4,2)
);

CREATE TABLE Copies(
                       CopyID integer PRIMARY KEY,
                       CopyNumber int,
                       BookID int,
                       foreign key (BookID) references Books(BookID),
                       UserID int ,
                       foreign key (UserID) references Users(UserID),
                       IsBorrowed BOOLEAN,
                       DueBackDate date

);



