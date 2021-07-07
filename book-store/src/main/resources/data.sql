DROP TABLE IF EXISTS book;

CREATE TABLE book
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    author            VARCHAR(250) NOT NULL,
    title             VARCHAR(250) NOT NULL,
    price             DECIMAL      NOT NULL,
    discount_group_id INT          NOT NULL
);


INSERT INTO book (id, author, title, price, discount_group_id)
VALUES (1, 'Author 1', 'Book 1', 100, 1),
       (2, 'Author 2', 'Book 2', 500, 3),
       (3, 'Author 3', 'Book 3', 400, 2),
       (4, 'Author 4', 'Book 4', 300, 3),
       (5, 'Author 5', 'Book 5', 200, 0);
