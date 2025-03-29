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
    price       INT NOT NULL,
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
VALUES (11200, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5500, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (4200, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9000, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1700, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1800, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2300, (SELECT id FROM brand WHERE name = 'A'), (SELECT id FROM category WHERE name = '액세서리'));

VALUES (10500, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5900, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3800, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9100, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2200, (SELECT id FROM brand WHERE name = 'B'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10000, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (6200, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3300, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9200, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2200, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1900, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2200, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100, (SELECT id FROM brand WHERE name = 'C'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10100, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5100, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3000, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9500, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2500, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1500, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2400, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000, (SELECT id FROM brand WHERE name = 'D'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10700, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5000, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3800, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9900, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2300, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1800, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100, (SELECT id FROM brand WHERE name = 'E'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (11200, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (7200, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (4000, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9300, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1600, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2300, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1900, (SELECT id FROM brand WHERE name = 'F'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10500, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (5800, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3900, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9000, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2200, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1700, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000, (SELECT id FROM brand WHERE name = 'G'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (10800, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (6300, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3100, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9700, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2100, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1600, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2000, (SELECT id FROM brand WHERE name = 'H'), (SELECT id FROM category WHERE name = '액세서리'));

INSERT INTO product (price, brand_id, category_id)
VALUES (11400, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '상의'));
INSERT INTO product (price, brand_id, category_id)
VALUES (6700, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '아우터'));
INSERT INTO product (price, brand_id, category_id)
VALUES (3200, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '바지'));
INSERT INTO product (price, brand_id, category_id)
VALUES (9500, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '스니커즈'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2400, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '가방'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1700, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '모자'));
INSERT INTO product (price, brand_id, category_id)
VALUES (1700, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '양말'));
INSERT INTO product (price, brand_id, category_id)
VALUES (2400, (SELECT id FROM brand WHERE name = 'I'), (SELECT id FROM category WHERE name = '액세서리'));
