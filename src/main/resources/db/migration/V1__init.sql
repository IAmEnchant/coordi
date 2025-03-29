CREATE TABLE category
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE brand
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE product
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    price       NUMERIC NOT NULL,
    brand_id    BIGINT,
    category_id BIGINT,
    CONSTRAINT fk_brand FOREIGN KEY (brand_id) REFERENCES brand (id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (id)
);

INSERT INTO category (name)
VALUES ('상의');
INSERT INTO category (name)
VALUES ('아우터');
INSERT INTO category (name)
VALUES ('바지');
INSERT INTO category (name)
VALUES ('스니커즈');
INSERT INTO category (name)
VALUES ('가방');
INSERT INTO category (name)
VALUES ('모자');
INSERT INTO category (name)
VALUES ('양말');
INSERT INTO category (name)
VALUES ('액세서리');

INSERT INTO brand (name)
VALUES ('A');
INSERT INTO brand (name)
VALUES ('B');
INSERT INTO brand (name)
VALUES ('C');
INSERT INTO brand (name)
VALUES ('D');
INSERT INTO brand (name)
VALUES ('E');
INSERT INTO brand (name)
VALUES ('F');
INSERT INTO brand (name)
VALUES ('G');
INSERT INTO brand (name)
VALUES ('H');
INSERT INTO brand (name)
VALUES ('I');

INSERT INTO product (price, brand_id, category_id)
VALUES (11200.00, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5500.00, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (4200.00, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9000.00, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000.00, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1700.00, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1800.00, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2300.00, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10500.00, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5900.00, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3800.00, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9100.00, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100.00, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000.00, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000.00, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2200.00, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10000.00, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (6200.00, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3300.00, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9200.00, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2200.00, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1900.00, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2200.00, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100.00, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10100.00, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5100.00, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3000.00, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9500.00, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2500.00, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1500.00, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2400.00, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000.00, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10700.00, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5000.00, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3800.00, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9900.00, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2300.00, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1800.00, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100.00, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100.00, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (11200.00, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (7200.00, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (4000.00, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9300.00, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000.00, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1600.00, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2300.00, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1900.00, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10500.00, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5800.00, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3900.00, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9000.00, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2200.00, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1700.00, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100.00, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000.00, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10800.00, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (6300.00, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3100.00, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9700.00, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100.00, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1600.00, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000.00, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000.00, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (11400.00, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (6700.00, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3200.00, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9500.00, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2400.00, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1700.00, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1700.00, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2400.00, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '액세서리'));
