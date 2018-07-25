CREATE TABLE sys_usuario (
  ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NOME VARCHAR(50) NOT NULL,
  MATRICULA VARCHAR(20) NOT NULL,
  SENHA VARCHAR(20) NOT NULL,
  STATUS VARCHAR(20) NOT NULL DEFAULT 'BLOQUEADO',
  EMAIL VARCHAR(120) NOT NULL,
  NIVEL VARCHAR(20) NOT NULL DEFAULT 'FUNCIONARIO'
);

INSERT INTO sys_usuario(ID,NOME,MATRICULA,SENHA,STATUS,EMAIL,NIVEL)
VALUES(NULL,'FELIPE SOUZA CERQUEIRA DOS SANTOS','felipe','falcao998','ATIVO','felipesouza_analista@yahoo.com.br', 'ADMINISTRADOR');