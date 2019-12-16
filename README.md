# Universirides

Repositório destinado ao projeto Universirides, trabalho realizado na disciplina Desenvolvimento de Software para Web e retomado na disciplina Técnicas Avançadas de Construção de Software.

## Visão Geral

O objetivo principal do Universirides é melhorar a mobilidade da comunidade da UFG juntando pessoas que fazem viagens para localizações similares, alunos, professores, técnicos, a comunidade em geral pode oferecer e aceitar caronas,  o projeto não tem o foco em cobrar por caronas, apenas juntar pessoas que tem um objetivo em comum.

## Organização do repositório

O projeto com código-fonte pode ser encontrado em /Codigo/
Já os documentos de visão geral, requisitos e o protótipo testável estão contidos em /Documentos/

## Stack Adotada
Neste projeto foi usado as seguintes tecnologias:
* Linguagem de programação Java
* Framework Spring Boot
* Banco de dados MySQL
* Spring Data (módulo do spring para comunicação com banco de dados)
* Pool de conexões Hikari
* Páginas Web Java Server Pages (JSP)

## Como Executar

Para executar este projeto é necessário ter instalado uma idle, preferencialmente que suporte aplicações SpringBoot como IntelliJ IDEA.
Também é necessário ter o banco de dados MySQL instalado em rodando localmente, crie um banco de dados chamado "universirides" com usuário "root" e senha "12345", caso use outro usuário ou senha modificar as primeiras configurações em "application.properties". 
Após isso apenas rodar o projeto, o esquema do banco de dados vai ser criado no momento de execução do projeto e o banco será populado com 1 usuário e 1 carona. 
Acessar a aplicação em [http://localhost:9090/](http://localhost:9090/)

## Protótipo

Na disciplina Desenvolvimento de Software para Web foi criado um protótipo de baixa fidelidade com a ferramenta Quant-UX, link para teste do protótipo: https://www.quant-ux.com/#/test.html?h=a2aa10aXsyS1WIeEEMIozoIs1LZQela9FmDFwxLrCsuPDuNwXTOuMQtts79K

Também foi criado um protótipo web testável utilizando o framework bootstrap, o projeto está em /Documentos/Prototipo/. Este protótipo também pode ser executado pelo IntelliJ IDEA sem a necessidade do banco de dados.
