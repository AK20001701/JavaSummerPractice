CREATE TABLE discount_group
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(10) NOT NULL,
    discount INT         NOT NULL
);

INSERT INTO discount_group (id, title, discount)
VALUES (1, 'group1', 10),
       (2, '1234567890', 0),
       (3, 'qwe', 50);