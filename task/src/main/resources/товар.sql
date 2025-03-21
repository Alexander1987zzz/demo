CREATE TABLE Пользователь
(
    id     INT PRIMARY KEY,
    имя    VARCHAR(255) NOT NULL,
    email  VARCHAR(255) NOT NULL,
    пароль VARCHAR(255) NOT NULL
);

CREATE TABLE Корзина
(
    id              INT PRIMARY KEY,
    id_пользователя INT  NOT NULL,
    дата_создания   DATE NOT NULL,
    FOREIGN KEY (id_пользователя) REFERENCES Пользователь (id)
);

CREATE TABLE Товар
(
    id       INT PRIMARY KEY,
    название VARCHAR(255)   NOT NULL,
    цена     DECIMAL(10, 2) NOT NULL,
    описание TEXT           NOT NULL
);

CREATE TABLE Корзина_Товар
(
    id         INT PRIMARY KEY,
    id_корзины INT NOT NULL,
    id_товара  INT NOT NULL,
    количество INT NOT NULL,
    FOREIGN KEY (id_корзины) REFERENCES Корзина (id),
    FOREIGN KEY (id_товара) REFERENCES Товар (id)
);