# kronos-spring-api-nosql

## Índice
- [📓 Sobre](#-sobre)
- [🚀 Tecnologias](#-tecnologias)
- [✨ Funcionalidades](#-funcionalidades)
- [⚙️ Instalação](#-instalação)
- [🧱 Estrutura do Projeto](#-estrutura-do-projeto)
- [📄 Licença](#-licença)
- [💻 Autores](#-autores)

</br>

## 📓 Sobre
Kronos-spring-api-nosql é uma API REST desenvolvida em Spring Boot com integração a bancos de dados NoSQL (MongoDB e Redis) para gestão de calendários e notificações. O projeto foi desenvolvido com foco em performance, escalabilidade e integração com diferentes bancos NoSQL, fornecendo endpoints seguros para gerenciamento de calendários e sistema de notificações.

</br>

## 🚀 Tecnologias
- Backend:
    - Java (17)
    - Spring Boot (3.2.5)
    - MongoDB
    - Redis

- Ferramentas e Build:
    - Maven

</br>

## ✨ Funcionalidades
- Gestão completa de calendários com MongoDB
- Sistema de notificações em tempo real com Redis
- API RESTful com endpoints documentados
- Autenticação e autorização segura
- Integração com múltiplos bancos NoSQL
- Tratamento global de exceções
- Deploy automatizado

</br>

## ⚙️ Instalação
É necessário ter Java +17, Maven e PostgreSQL instalados.
```
# clonar o repositório
git clone https://github.com/Systems-Kronos/kronos-spring-api-nosql.git

# entrar no diretório
cd kronos-spring-api-nosql

# configure as variáveis de ambiente no arquivo '.env':
MONGO_URI=sua_uri_mongodb
REDIS_HOST=seu_host_redis
REDIS_PORT=sua_porta_redis
REDIS_PASSWORD=sua_senha_redis

# execute o projeto:
mvn spring-boot:run

# o projeto será inicado em: http://localhost:8080
# a documentação estará disponível em: http://localhost:8080/swagger-ui.html
```

</br>


## 🧱 Estrutura do Projeto
```
kronos-spring-api-nosql
├── /src
│   ├── /main
│   │   ├── /java/com/kronosapinosql
│   │   │   ├── /config          # Configurações do projeto
│   │   │   ├── /controller      # Controladores REST
│   │   │   ├── /dto             # Objetos de Transferência de Dados
│   │   │   ├── /exception       # Exceções personalizadas
│   │   │   ├── /handler         # Manipuladores de exceções
│   │   │   ├── /model           # Entidades JPA
│   │   │   ├── /repository      # Repositórios JPA
│   │   │   └── /service         # Lógica de Negócios
│   │   └── /resources
│   │       └── application.properties
├── pom.xml                      # Dependências Maven
├── Dockerfile                   # Configuração Docker
└── README.md                    # Documentação
```

</br>

## 📄 Licença
Este projeto está licenciado sob a licença MIT — veja o arquivo LICENSE para mais detalhes.

</br>

## 💻 Autores
- [Carlos Perrud](https://github.com/CaduPerrudGerminare)
- [Yasmin Barbosa](https://github.com/yassbarbosa)
