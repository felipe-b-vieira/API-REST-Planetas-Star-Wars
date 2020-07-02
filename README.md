# API REST Planetas Star Wars
 API REST dos planetas de Star Wars, permitindo enviar e receber informações de planetas. Projeto sendo desenvolvido para vaga de Back-end Júnior.
 
 Projeto utilizando Java, Spring e MongoDB.
 
 As configurações de MongoDB estão sendo acessadas localmente. Para a configuração de acesso local precisa utilizar md \data\db após a instalação do MongoDB na máquina para configurar o local de instalação dos bancos. Também é necessário definir o nome como um index para poder ser considerado único.
 
 Sendo utilizado IntelliJ IDEA para execução, gerando acesso por http://localhost:8080/planetas, podendo ser utilizados GET, POST, PUT e DELETE.
 
 IntelliJ IDEA apresenta o erro Could not autowire. No beans of 'PlanetasRepository' type found. Esse erro parece ser apenas identificado pela IDE mas não realmente acontece, possivelmente por causa da configuração do Spring com o comando @RestController.
 
 As informações contidas no banco de dados são: Nome, Clima, Terreno e Quantidade de aparições nos filmes(Vai ser atualizada por outra API).
 
 Para fazer requisições POST, é necessário passar Nome, Clima e Terreno. A quantidade de aparições será adiciona automatica com base no nome do Planeta através da API Pública de Star Wars. Caso não encontre um planeta com o mesmo nome, ele irá definir a quantidade como -1.
 
 
# Desafio proposto:
Nossos associados são aficionados por Star Wars e com isso, queremos criar um jogo com algumas informações da franquia.
Para possibilitar a equipe de front criar essa aplicação, queremos desenvolver uma API que contenha os dados dos planetas.

Requisitos:
- A API deve ser REST
- Para cada planeta, os seguintes dados devem ser obtidos do banco de dados da aplicação, sendo inserido manualmente:

    Nome
    Clima
    Terreno

- Para cada planeta também devemos ter a quantidade de aparições em filmes, que podem ser obtidas pela API pública do Star Wars: https://swapi.dev/about


Funcionalidades desejadas: 

- Adicionar um planeta (com nome, clima e terreno)
- Listar planetas
- Buscar por nome
- Buscar por ID
- Remover planeta


Linguagens que usamos: Java, Go
Bancos que usamos: MongoDB, Cassandra, DynamoDB, Datomic

E lembre-se! Um bom software é um software bem testado.


