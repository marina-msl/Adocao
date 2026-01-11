# 🐕 Sistema de Adoção de Cães com Spring AI

Este projeto é uma implementação em português do tutorial **"Your First Spring AI 1.0 Application"** do blog oficial do Spring.

## 📚 Sobre este Projeto

Este repositório foi criado como parte dos meus estudos sobre **Spring AI 1.0**. Estou seguindo e aprendendo com o material publicado no blog do Spring:

🔗 **[Your First Spring AI 1.0 Application](https://spring.io/blog/2025/05/20/your-first-spring-ai-1)**

Durante o aprendizado, estou traduzindo o conteúdo e adaptando para português, tornando o material mais acessível para desenvolvedores brasileiros.

## 🎯 O que este projeto faz?

Este é um sistema de adoção de cães que utiliza **Spring AI** para criar um assistente inteligente que ajuda pessoas a encontrar o cão perfeito para adoção. O sistema utiliza:

- 🤖 **Spring AI** com modelo Claude (via Ollama)
- 🗄️ **PostgreSQL** com extensões PgVector e PostgresML
- 💾 **Spring Data JDBC** para persistência
- 🧠 **Chat Memory** para manter contexto das conversas
- 🔍 **Vector Store** para busca semântica de cães disponíveis

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.10-SNAPSHOT**
- **Spring AI 1.1.2**
- **PostgreSQL** (com PgVector e PostgresML)
- **Ollama** (modelo llama3.2:1b)
- **Maven**
- **GraalVM Native Support**

## 📋 Pré-requisitos

- Java 21 ou superior
- Maven
- Docker (para PostgreSQL com extensões)
- Ollama instalado e rodando

## 🛠️ Como Executar

### 1. Configurar o Banco de Dados

Execute o script para iniciar o PostgreSQL com as extensões necessárias:

```bash
./db/run.sh
```

Depois, inicialize o usuário da aplicação:

```bash
./db/init.sh
```

### 2. Configurar a Aplicação

As configurações estão no arquivo `src/main/resources/application.properties`. Certifique-se de que o Ollama está rodando e acessível.

### 3. Executar a Aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## 📡 Endpoints

### Assistente de Adoção

```
GET /{user}/assistant?question={sua pergunta}
```

Exemplo:
```
GET /joao/assistant?question=Quais cães estão disponíveis para adoção?
```

## 🗂️ Estrutura do Projeto

```
adoptions/
├── src/
│   ├── main/
│   │   ├── java/com/example/adoptions/
│   │   │   ├── AdoptionsApplication.java
│   │   │   ├── controller/
│   │   │   │   └── AdoptionsController.java
│   │   │   ├── model/
│   │   │   │   └── Dog.java
│   │   │   └── repository/
│   │   │       └── DogRepository.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── schema.sql
│   │       └── data.sql
│   └── test/
├── db/
│   └── run.sh
└── pom.xml
```

## 🐕 Os Cães

O banco de dados contém informações sobre vários cães disponíveis para adoção, incluindo o famoso **Prancer** - um Chihuahua que se tornou viral em 2021 por sua personalidade única! 😄

Todas as descrições dos cães foram traduzidas para português para melhorar a experiência do usuário brasileiro.

## 📝 Traduções Realizadas

- ✅ Comentários do `application.properties`
- ✅ Descrições dos cães no `data.sql`
- ✅ Documentação em português

## 🎓 Aprendizados

Este projeto me permitiu aprender sobre:

- Integração com modelos de IA usando Spring AI
- Configuração de vector stores para busca semântica
- Implementação de chat memory para manter contexto
- Uso de embeddings para melhorar respostas da IA
- Configuração de PostgreSQL com extensões avançadas

## 📖 Referências

- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Your First Spring AI 1.0 Application](https://spring.io/blog/2025/05/20/your-first-spring-ai-1)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/reference/)

## 📄 Licença

Este projeto é para fins educacionais, baseado no tutorial oficial do Spring.

## 👨‍💻 Autor

Criado como parte dos estudos sobre Spring AI, traduzindo e adaptando o material oficial para português.

---

⭐ Se este projeto te ajudou de alguma forma, considere dar uma estrela!

