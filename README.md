# API REST Planetas Star Wars
 API REST dos planetas de Star Wars, permitindo enviar e receber informações de planetas. Projeto sendo desenvolvido para vaga de Back-end Júnior.
 
 Projeto utilizando Java, Spring e MongoDB.
 
 As informações contidas no banco de dados são: Nome, Clima, Terreno e Quantidade de aparições nos filmes(Gerada pela API pública do Star Wars -  https://swapi.dev/about).
 A informação de Nome é considerada valor único.

#Uso local
 Para esse uso, é importante utilizar o application.proprieties local, para isso, basta definir o spring.profiles.active como dev.
 
 As configurações de MongoDB podem ser acessadas localmente. Para a configuração de acesso local precisa utilizar md \data\db após a instalação do MongoDB na máquina para configurar o local de instalação dos bancos. Também é necessário definir o nome como um index para poder ser considerado único.

Sendo utilizado IntelliJ IDEA para execução local, gerando acesso por http://localhost:8080/planetas, podendo ser utilizados GET, POST, PUT e DELETE. IntelliJ IDEA apresenta o erro Could not autowire. No beans of 'PlanetasRepository' type found. Esse erro parece ser apenas identificado pela IDE mas não realmente acontece, possivelmente por causa da configuração do Spring com o comando @RestController.


#Uso online
 Para esse uso, é importante utilizar o application.proprieties local, para isso, basta definir o spring.profiles.active como prod. O link do banco de dados está salvo como variável de ambiente no Heroku.
 
 A API pode ser acessada pela url: https://api-rest-starwars-planetas.herokuapp.com/, e funciona da mesma maneira que localmente. No entanto, a API irá utilizar um banco de dados MONGODB online utilizando a ferramenta gratuita Atlas.
 
 
#Uso geral
 A API se localiza na URL /planetas/ tanto no ambiente local quanto online. As requisições e envios são feitos com JSON.
 As requisições retornam Status Code 200 em sucesso, mas em erros nos valores passados, ou duplicatas, vai retornar apenas erro 400.

 ###GET
  A requisição GET pode ser feita diretamente no /planetas/, ele irá retornar todos os planetas salvos.
  O GET também pode ser usado para adquirir informações de planetas específicos com o id ou nome.
  Utilizando /planetas/{id} você pode pegar informações de um único planeta de mesmo id.
  Utilizando /planetas/nome/{nome} você pode pegar informações de um único planeta com o nome passado.
 
 ###POST
  A requisição GET pode ser feita diretamente no /planetas/.
  Para fazer requisições POST, é necessário passar Nome, Clima e Terreno no body. 
  A quantidade de aparições será adiciona automatica com base no nome do Planeta através da API Pública de Star Wars. 
  Caso não encontre um planeta com o mesmo nome, ele irá definir a quantidade como -1.
  A requisição irá retornar, no body, o planeta salvo.

 ###PUT
  A requisição PUT pode ser feita diretamente no /planetas/{id}. Sendo o id, um valor gerado automaticamente pela API e pode ser pegada através dos comandos GET.
  Para fazer requisições PUT, é necessário passar Nome, Clima e Terreno no body, levando em conta as informações que queira alterar.
  Retorna erro caso tente alterar um planeta que não exista.
  A requisição irá retornar, no body, o planeta alterado.
  
 ###DELETE
  A requisição DELETE pode ser feita diretamente no /planetas/{id}. Sendo o id, um valor gerado automaticamente pela API e pode ser pegada através dos comandos GET.
  Retorna erro caso tente deletar um planeta que não exista.
  A requisição irá retornar, no body, o planeta deletado.
  
 
 
 
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


