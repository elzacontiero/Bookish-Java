Create DATABASE Bookish;

Use Bookish;

CREATE TABLE Books(
                      BookID integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      title varchar(250),
                      author varchar(255),
                      isbn varchar(30),
                      category varchar(50)
);

CREATE TABLE Users(
                        UserID integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        FirstName varchar (255),
                        LastName varchar (255),
                        Email varchar(300),
                        Address varchar(300),
                        AppliedFees Decimal(4,2)
);

CREATE TABLE Copies(
                       CopyID integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       CopyNumber int,
                       BookID int,
                       foreign key (BookID) references Books(BookID),
                       UserID int ,
                       foreign key (UserID) references Users(UserID),
                       IsBorrowed BOOLEAN,
                       DueBackDate date

);

insert into Users (FirstName, LastName, Email, Address, AppliedFees)
values
('Elsa','Frozen','elsa@frozen.co.uk','NW34BJ',15.50),
('Galadriel','Elf','galadriel@rivendell.org','SW1A1AA',45.80),
('Han','Solo','han@starwars.org','LA23 1LJ',99.99),
('Chewbacca','Brown','chewie@starwars.org','DE4 1AB',80.50);

INSERT INTO Books (title, author, isbn, category) VALUES ('Clean Code', 'Robert Martin', '978-0-13-235088-4', 'Computing');
INSERT INTO Books (title, author, isbn, category) VALUES ('Modern Java in Action', 'Raoul Urma', '978-1-61729356-6', 'Computing');
INSERT INTO Books (title, author, isbn, category) VALUES ('Python for Serious Beginners', 'Harry Yoon', '978-2-98764663-5', 'Computing');
INSERT INTO Books (title, author, isbn, category) VALUES ('Algorithms Unlocked', 'Thomas Cormen', '978-026251880-2', 'Computing');

INSERT INTO COPIES (CopyNumber, BookID, UserID, IsBorrowed, DueBackDate) VALUES (1, 2, 1, 1, '2022-10-15');
INSERT INTO COPIES (CopyNumber, BookID, UserID, IsBorrowed, DueBackDate) VALUES (2, 4, 2, 1, '2022-10-30');

