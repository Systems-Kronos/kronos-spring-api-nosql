# Kronos Spring API NoSQL

# Índice
📓 [Sobre](#sobre)
🚀 [Tecnologias](#tecnologias)
✨ [Funcionalidades](#funcionalidades)
⚙️ [Instalação](#instalação)
🧱 [Estrutura do Projeto](#estrutura-do-projeto)
📄 [Licença](#licença)
💻 [Autores](#autores)

## 📓 Sobre
Kronos Spring API NoSQL é uma API REST desenvolvida em Spring Boot com integração a bancos de dados NoSQL (MongoDB e Redis) para gestão de calendários e notificações. O projeto foi desenvolvido com foco em performance, escalabilidade e integração com diferentes bancos NoSQL, fornecendo endpoints seguros para gerenciamento de calendários e sistema de notificações.

## � Tecnologias

### Back-end:
- Java 17
- Spring Boot 3.5.4
- MongoDB
- Redis
- Maven
- Docker
- Swagger/OpenAPI
- GitHub Actions

### Ferramentas e Build:
- Maven 3.9+
- Docker
- GitHub Actions

## ✨ Funcionalidades
- Gestão completa de calendários com MongoDB
- Sistema de notificações em tempo real com Redis
- API RESTful com endpoints documentados
- Autenticação e autorização segura
- Integração com múltiplos bancos NoSQL
- Tratamento global de exceções
- Deploy automatizado

## ⚙️ Instalação

- JDK 17+
- Maven 3.9+
- Docker
- MongoDB
- Redis

## 🚀 Configuração

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/spring-api-nosql.git
```

2. Configure as variáveis de ambiente no arquivo `.env`:
```properties
MONGO_URI=sua_uri_mongodb
REDIS_HOST=seu_host_redis
REDIS_PORT=sua_porta_redis
REDIS_PASSWORD=sua_senha_redis
```

3. Execute a aplicação:
```bash
mvn spring-boot:run
```

## 🐳 Docker

Para executar via Docker:

```bash
docker build -t spring-api-nosql .
docker run -p 8080:8080 spring-api-nosql
```

## 📚 Documentação API

A documentação Swagger está disponível em:
```
http://localhost:8080/swagger-ui.html
```

## 🔍 Endpoints Principais

### Calendário (MongoDB)
- `GET /api/calendario/selecionar` - Lista todos os calendários
- `GET /api/calendario/selecionar/{id}` - Busca calendário por ID
- `POST /api/calendario/adicionar` - Cria novo calendário
- `PUT /api/calendario/atualizar/{id}` - Atualiza calendário
- `DELETE /api/calendario/deletar/{id}` - Remove calendário

### Notificações (Redis)
- `GET /api/notificacoes/selecionar` - Lista todas as notificações
- `GET /api/notificacoes/selecionar/{id}` - Lista notificações por usuário

## 🔄 CI/CD

O projeto utiliza GitHub Actions para:
- Build automático
- Testes
- Deploy no Render

## 📄 Licença

Este projeto está sob a licença MIT - veja o arquivo [`LICENSE`](LICENSE ) para detalhes.

## 🤝 Contribuição

1. Fork o projeto
2. Crie sua Feature Branch (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Add: MinhaFeature'`)
4. Push para a Branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## ⚠️ Tratamento de Erros

A API possui tratamento global de exceções para:
- Erros de MongoDB
- Erros de Redis
- Validações de dados
- Erros genéricos

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/kronosapinosql/
│   │       ├── config/           # Configurações do Redis e MongoDB
│   │       ├── controller/       # Controladores REST
│   │       ├── dto/             # Objetos de Transferência de Dados
│   │       ├── exception/        # Exceções personalizadas
│   │       ├── handler/         # Manipuladores de exceções
│   │       ├── model/           # Entidades do domínio
│   │       ├── repository/      # Repositórios NoSQL
│   │       └── service/         # Lógica de negócios
│   └── resources/              # Arquivos de configuração
└── test/                      # Testes unitários e de integração
```

## 💻 Autores

- Carlos Sousa
- Yasmin Barbosa
