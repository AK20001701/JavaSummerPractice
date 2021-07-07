DROP TABLE IF EXISTS book;

CREATE TABLE usr
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);


INSERT INTO usr (id, username, password)
VALUES (1, 'User1', '$2a$10$kzA9Gw2tRqtKf3yKDWfmpeLsaaMJ4JXZQa1UPSYxuFgVUau.QE2Ia'),
       (2, 'User2', '$2a$10$a8GS.3.W9Qz1.ktOBdbMCO1g1l4kaD2iCgRjaQBcu3t2AwGQBCKSq'),
       (3, 'User3', '$2a$10$DVJXrT0rAb.hEaV5RUlvkODL1hhuwMT/aTfsuPIqGVdKYUfwhWnM2'),
       (4, 'User4', '$2a$10$LD3H7Kmk7t8Q6U0y8CLH9.3iMtcbyN3LWDfiMaiZDjqtBap5c/VJy');


CREATE TABLE comment
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    author_id INT          NOT NULL,
    book_id   INT          NOT NULL,
    text      VARCHAR(255) NOT NULL
);

INSERT INTO comment (id, author_id, book_id, text)
VALUES (1, 1, 1, 'Nice book'),
       (2, 1, 1, 'Not so bad'),
       (3, 1, 2, 'Awesome');