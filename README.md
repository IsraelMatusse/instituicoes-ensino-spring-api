# instituicoes-ensino-spring-api

Esta API foi desenvolvida com o objetivo de permitir que os clientes consultem informações sobre instituições de ensino em Moçambique, abrangendo desde o nível primário até o ensino superior. Os usuários podem filtrar suas buscas por meio do código da instituição, pelo nível de ensino ou pela província.

Atualmente, a API contém dados de instituições de ensino superior e médio. A aplicação possui uma documentação acessível pelo seguinte endpoint:
[http://localhost:port/swagger-ui/index.html](http://localhost:port/swagger-ui/index.html)
*Observação:* Verifique a porta em que o serviço está sendo executado em sua máquina local.

A implementação da API foi realizada utilizando o framework Spring Boot, aproveitando apenas os modelos necessários para o propósito de disponibilização de informações sobre instituições de ensino. As consultas ao banco de dados foram efetuadas usando Hibernate e JPA, fornecendo uma camada eficiente para manipulação dos dados.

O banco de dados escolhido para armazenar essas informações é o MySQL. Essa escolha foi feita levando em consideração a robustez e confiabilidade que o MySQL oferece para aplicativos web.
