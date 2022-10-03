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

CREATE TABLE `technologies` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `name` varchar(50) NOT NULL,
                                `logoUrl` varchar(200) DEFAULT NULL,
                                PRIMARY KEY (`id`)
);

INSERT INTO `technologies`
(id, name, logoUrl)
VALUES
    (1,'Java','https://pngimage.net/wp-content/uploads/2018/06/java-logo-png-transparent-background-7.png'),
    (2,'Spring','https://www.logolynx.com/images/logolynx/98/980c5fe716efb66c936eebe1937d5489.png'),
    (3,'Thymeleaf','https://www.thymeleaf.org/images/thymeleaf.png'),
    (4,'MySQL','https://www.mysql.com/common/logos/logo-mysql-170x115.png'),
    (5,'HTML','https://www.w3.org/html/logo/downloads/HTML5_Logo_256.png'),
    (6,'CSS','https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/CSS3_logo_and_wordmark.svg/2000px-CSS3_logo_and_wordmark.svg.png');

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

