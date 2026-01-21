# 🐕 Sistema de Adoção de Cães com Spring AI

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green)
![Spring AI](https://img.shields.io/badge/Spring%20AI-1.1.2-blue)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)
![Licença](https://img.shields.io/badge/Licença-Educacional-lightgrey)

Este projeto é uma implementação em português do tutorial **"Your First Spring AI 1.0 Application"** do blog oficial do Spring.

## 📚 Sobre este Projeto

Este repositório foi criado como parte dos meus estudos sobre **Spring AI 1.0**. Estou seguindo e aprendendo com o material publicado no blog do Spring:

🔗 **[Your First Spring AI 1.0 Application](https://spring.io/blog/2025/05/20/your-first-spring-ai-1)**

Durante o aprendizado, estou traduzindo o conteúdo e adaptando para português, tornando o material mais acessível para desenvolvedores brasileiros.

## 💡 Por que este projeto?

Spring AI 1.0 acabou de ser lançado (Maio 2025) e há **pouquíssimo conteúdo em português** sobre o tema.

Este projeto tem três objetivos:

1. 📖 **Documentar minha jornada** aprendendo Spring AI
2. 🇧🇷 **Tornar o conteúdo acessível** para desenvolvedores brasileiros
3. 🚀 **Criar um portfólio real** aplicando conceitos de IA em Java

Se você também está começando com Spring AI, este repositório pode te economizar horas de pesquisa!

## 🔄 Diferenças do Tutorial Original

Algumas adaptações foram feitas em relação ao tutorial original:

1. **Modelo de IA**: Não usei o Claude (que requer pagamento de $5 USD). Em vez disso, utilizei o **Ollama** com o modelo **llama3.2:1b** (o menor modelo disponível). 

2. **Arquitetura em Camadas**: Diferente do tutorial original onde tudo fica na classe principal, estou seguindo uma arquitetura em camadas com separação de responsabilidades. As configurações do Spring AI (como `PromptChatMemoryAdvisor`) foram organizadas na pasta `config/` ao invés de ficarem todas na classe `AdoptionsApplication`, permitindo uma melhor organização e manutenibilidade do código.

## 📊 Progresso do Tutorial

Status atual do aprendizado seguindo o tutorial:

- ✅ **Chat Memory** 
- ✅ **System Prompts**
- ✅ **Observability**
- ✅ **RAG/Vector Store**
- ✅ **Structured Output** - [Structured Output - String vs Objetos Tipados](STRUCTURED_OUTPUT.md)
- ⬜ Tool Calling
- ⬜ MCP
- ⬜ GraalVM Native

## 🎯 O que este projeto faz?

Este é um sistema de adoção de cães que utiliza **Spring AI** para criar um assistente inteligente que ajuda pessoas a encontrar o cão perfeito para adoção. O sistema utiliza:

- 🤖 **Spring AI** com modelo llama3.2:1b (via Ollama)
- 🗄️ **PostgreSQL** com extensões PgVector
- 💾 **Spring Data JDBC** para persistência
- 🧠 **Chat Memory** para manter contexto das conversas
- 🔍 **Vector Store** para busca semântica de cães disponíveis

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.10-SNAPSHOT**
- **Spring AI 1.1.2**
- **PostgreSQL** (com PgVector)
- **Ollama** (modelo llama3.2:1b) - usando um modelo pequeno
- **Maven**
- **GraalVM Native Support**

## 📋 Pré-requisitos

- Java 21 ou superior
- Maven
- Docker (para PostgreSQL com extensões)
- Ollama instalado e rodando

> 📖 **Precisa de ajuda com o Ollama?** Consulte o [Guia de Comandos do Ollama](OLLAMA.md)

## 🛠️ Como Executar

### 1. Iniciar o Banco de Dados

Execute o Docker Compose para iniciar o PostgreSQL:

```bash
docker-compose up -d
```

### 2. Executar a Aplicação

Certifique-se de que o Ollama está rodando e acessível, depois execute:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

> 💡 **Dica:** Precisa configurar ou testar o Ollama? Veja o [Guia de Comandos do Ollama](OLLAMA.md)

## 📡 Endpoints

### Assistente de Adoção

```
GET /{user}/assistant?question={sua pergunta}
```

Exemplo:
```
GET /marina/assistant?question=Quais cães estão disponíveis para adoção?
```

## 🗂️ Estrutura do Projeto

```
adoptions/
├── src/
│   ├── main/
│   │   ├── java/com/example/adoptions/
│   │   │   ├── AdoptionsApplication.java
│   │   │   ├── config/
│   │   │   │   └── AIConfig.java
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

## 🤝 Como Contribuir

Este é um projeto educacional aberto! Contribuições são bem-vindas:

1. 🐛 Encontrou um bug? Abra uma issue
2. 💡 Tem uma ideia? Proponha via Pull Request
3. 📖 Melhorou a documentação? Contribua!

## 📬 Contato

Desenvolvido por **Marina Leide**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Conectar-blue)](https://www.linkedin.com/in/marinaleide/)

---

## ⭐ Gostou do projeto?

Se este repositório te ajudou de alguma forma:
- ⭐ Dê uma estrela no GitHub
- 🔄 Compartilhe com outros devs
- 💬 Deixe um comentário no meu LinkedIn

**Juntos, tornamos Spring AI acessível para todos os devs brasileiros!** 🇧🇷🚀

---

📖 **Referências e Créditos**
- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Tutorial Original](https://spring.io/blog/2025/05/20/your-first-spring-ai-1) por Josh Long, Mark Pollack e Christian Tsolov
- [Anthropic Claude](https://www.anthropic.com/)

## 📚 Documentação Adicional

- [🦙 Guia de Comandos do Ollama](OLLAMA.md) - Comandos essenciais para trabalhar com o Ollama
- [📊 Observabilidade e Métricas](OBSERVABILITY.md) - Guia sobre métricas e monitoramento com Spring Boot Actuator
- [📦 Structured Output - String vs Objetos Tipados](STRUCTURED_OUTPUT.md) - Guia completo sobre quando usar `.content()` vs `.entity()` no Spring AI

