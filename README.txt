Java-Crawler

Para executar é necessário ter o Java 8 e mysql 5.6 instalados e seguir os passos abaixo.
1 - Criar base de dados e tabela
create database `java-crawler`

create table casoCorona(
	id int not null AUTO_INCREMENT PRIMARY key,
    confirmados int,
    suspeitos int,
    recuperados int,
    obitos int,
    dataPesquisa dateTime
) 

2 - Navegue com o cmd/terminal até a pasta dist
3 - Execute o comando java -jar java-crawler.jar

