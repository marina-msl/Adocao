# 📊 Observabilidade - Métricas e Monitoramento

Guia sobre observabilidade e métricas no projeto usando Spring Boot Actuator.

## ⚙️ Configuração

Na parte de observabilidade foram inseridas as seguintes configurações no `application.properties`:

```properties
# Habilitando todos os endpoints do Actuator (somente para desenvolvimento e testes)
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
```

> ⚠️ **Importante:** Habilitar todos os endpoints (`*`) é recomendado apenas para desenvolvimento e testes. Em produção, especifique apenas os endpoints necessários.

## 📈 Acessando as Métricas

Para ver as métricas geradas pela aplicação, acesse:

```
http://localhost:8080/actuator/metrics
```

Esta URL retorna uma lista de todas as métricas disponíveis no sistema.

## 🔑 Métrica de Tokens

Uma métrica importante a ser observada é a quantidade de tokens usados pela aplicação. Essa métrica pode ser encontrada em:

```
http://localhost:8080/actuator/metrics/gen_ai.client.token.usage
```

Esta métrica mede o número de tokens de entrada (input) e saída (output) utilizados nas interações com o modelo de IA.

### Exemplo de Resposta

Após algumas interações, a métrica retorna informações detalhadas:

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

Após mais interações, podemos observar que o valor aumenta. Por exemplo:

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

**Valor após mais interações:**
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

Isso demonstra que a aplicação está registrando corretamente o uso de tokens a cada interação com o modelo de IA.

## 📋 Outras Métricas Disponíveis

O Spring Boot Actuator fornece diversas outras métricas, incluindo:

- `jvm.memory.used` - Uso de memória da JVM
- `http.server.requests` - Requisições HTTP
- `process.uptime` - Tempo de execução da aplicação
- E muitas outras...

Explore todas as métricas disponíveis em `http://localhost:8080/actuator/metrics`.

## 🔗 Links Relacionados

- [← Voltar ao README principal](README.md)

## 📚 Documentação Oficial

- [Spring Boot Actuator Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Spring AI Observability](https://docs.spring.io/spring-ai/reference/api/observability.html)

---

*Última atualização: Janeiro 2025*

