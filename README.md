# Objetivo
No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação.
A partir disso, você precisa criar uma solução back-end para gerenciar essas sessões de votação.

## Segue
* Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API
REST:
> * Cadastrar uma nova pauta;
> * Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo
determinado na chamada de abertura ou 1 minuto por default);
> * Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é
identificado por um id único e pode votar apenas uma vez por pauta);
> * Contabilizar os votos e dar o resultado da votação na pauta.

## Pré-Requisitos

Necessário ter o [docker](https://docs.docker.com/) instalado na máquina;

### Execução

Na raiz do projeto(pasta work-zallpy), abrir o prompt e digitar o seguinte:

```
docker-compose up
```

Ao acessar o link do pgadmin: 

```
http://localhost:16543/
```

> Usuário: leandro.moquiuti@gmail.com

> Senha: postgresql


E não encontrar o server criado não se preocupe, mesmo que já tenha executado alguma ação de inserção!
Vamos lá... 
Basta clicar com o botão direito sobre **Serves** e na opção **Create** selecionar **Server...**
1. Na aba **General**: 
> * no campo **Name** insira: _postgres_ .
2. Na aba **Connection**
> * No campo **Hostname/address** insira: _postgres_
> * No campo **Username** insira: _postgres_
> *	No campo **Password** insira: _postgresql_
> * pressione **Enter** 

Pronto! já será possível identificar dentro do schema public do banco as tabelas criadas, e mesmo que já tenha inserido valores
antes desse procedimento os valores já estarão lá.

## Construído com 

* [Spring](https://start.spring.io/) - Criação da estrutura do Backend
* [Maven](https://maven.apache.org/) - Gerenciamento de Dependências
* [JAVA 14](https://www.oracle.com/java/technologies/javase-downloads.html#JDK14) - Linguagem de Codificação do Backend
* [Postgresql](https://www.postgresql.org/download/) - Banco de Dados
