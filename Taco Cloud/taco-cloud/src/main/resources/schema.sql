CREATE TABLE IF NOT EXISTS Taco_Order (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    delivery_name VARCHAR(50) NOT NULL,
    delivery_street VARCHAR(50) NOT NULL,
    delivery_city VARCHAR(50) NOT NULL,
    delivery_state CHAR(2) NOT NULL,
    delivery_zip VARCHAR(10) NOT NULL,
    cc_number CHAR(16) NOT NULL,
    cc_expiration CHAR(5) NOT NULL,
    cc_CVV CHAR(3) NOT NULL,
    placed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS Taco (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    taco_order_key BIGINT NOT NULL,
    name VARCHAR(50) NOT NULL,
    taco_order BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS Ingredient_Ref (
    ingredient CHAR(4) NOT NULL,
    taco BIGINT NOT NULL,
    CONSTRAINT PK_ENTRY PRIMARY KEY (ingredient, taco)
);


CREATE TABLE IF NOT EXISTS Ingredient (
    id VARCHAR(4) NOT NULL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL
);


ALTER TABLE TACO
ADD FOREIGN KEY (taco_order_key) REFERENCES Taco_Order(id);

ALTER TABLE Ingredient_Ref
ADD FOREIGN KEY (ingredient) REFERENCES Ingredient(id);

ALTER TABLE Ingredient_Ref
ADD FOREIGN KEY (taco) REFERENCES Taco(id);
