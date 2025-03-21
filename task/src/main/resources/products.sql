CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL

);

CREATE TABLE tags (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE product_tags (
                              product_id INT,
                              tag_id INT,
                              PRIMARY KEY (product_id, tag_id),
                              FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
                              FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE
);