# 📊 Observabilidade - Métricas e Monitoramento

Guia sobre observabilidade e métricas no projeto usando Spring Boot Actuator.

## ⚙️ Configuração

Na parte de observabilidade foram inseridas as seguintes configuracoes no `application.properties`:

```properties
# Habilitando todos os endpoints do Actuator (somente para desenvolvimento e testes)
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
```

> ⚠️ **Importante:** Habilitar todos os endpoints (`*`) é recomendado apenas para desenvolvimento e testes. Em producao, especifique apenas os endpoints necessarios.

## 📈 Acessando as Metricas

Para ver as metricas geradas pela aplicacao, acesse:

```
http://localhost:8080/actuator/metrics
```

Esta URL retorna uma lista de todas as metricas disponiveis no sistema.

## 🔑 Metrica de Tokens

Uma metrica importante a ser observada e a quantidade de tokens usados pela aplicacao. Essa metrica pode ser encontrada em:

```
http://localhost:8080/actuator/metrics/gen_ai.client.token.usage
```

Esta metrica mede o numero de tokens de entrada (input) e saida (output) utilizados nas interacoes com o modelo de IA.

### Exemplo de Resposta

Apos algumas interacoes, a metrica retorna informacoes detalhadas:

```json
{
  "name": "gen_ai.client.token.usage",
  "description": "Measures number of input and output tokens used",
  "measurements": [
    {
      "statistic": "COUNT",
      "value": 9490
    }
  ],
  "availableTags": [
    {
      "tag": "gen_ai.operation.name",
      "values": [
        "chat"
      ]
    },
    {
      "tag": "gen_ai.response.model",
      "values": [
        "llama3.2:1b"
      ]
    },
    {
      "tag": "gen_ai.request.model",
      "values": [
        "llama3.2:1b"
      ]
    },
    {
      "tag": "gen_ai.token.type",
      "values": [
        "output",
        "input",
        "total"
      ]
    },
    {
      "tag": "gen_ai.system",
      "values": [
        "ollama"
      ]
    }
  ]
}
```

### Observando o Crescimento

Apos mais interacoes, podemos observar que o valor aumenta. Por exemplo:

**Valor inicial:**
```json
{
  "measurements": [
    {
      "statistic": "COUNT",
      "value": 9490
    }
  ]
}
```

**Valor apos mais interacoes:**
```json
{
  "measurements": [
    {
      "statistic": "COUNT",
      "value": 12108
    }
  ]
}
```

Isso demonstra que a aplicacao esta registrando corretamente o uso de tokens a cada interacao com o modelo de IA.

## 📋 Outras Metricas Disponiveis

O Spring Boot Actuator fornece diversas outras metricas, incluindo:

- `jvm.memory.used` - Uso de memoria da JVM
- `http.server.requests` - Requisicoes HTTP
- `process.uptime` - Tempo de execucao da aplicacao
- E muitas outras...

Explore todas as metricas disponiveis em `http://localhost:8080/actuator/metrics`.

## 🔗 Links Relacionados

- [← Voltar ao README principal](README.md)

## 📚 Documentacao Oficial

- [Spring Boot Actuator Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Spring AI Observability](https://docs.spring.io/spring-ai/reference/api/observability.html)

---

*Ultima atualizacao: Janeiro 2025*

