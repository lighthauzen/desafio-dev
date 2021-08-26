

CREATE TABLE IF NOT EXISTS tipos_trans (
id INTEGER NOT NULL AUTO_INCREMENT,
descricao VARCHAR(25),
natureza VARCHAR(25),
sinal INTEGER,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cnab (
id INTEGER NOT NULL AUTO_INCREMENT,
fk_tipos_trans INTEGER ,
data DATE,
valor INTEGER,
cpf VARCHAR(11),
cartao VARCHAR(12),
hora TIME,
dono_loja VARCHAR(20),
nome_loja VARCHAR(20),
PRIMARY KEY(id),
FOREIGN KEY(fk_tipos_trans) REFERENCES tipos_trans(id)

)