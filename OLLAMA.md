# 🦙 Ollama - Comandos Essenciais

Guia rápido de comandos do Ollama para o projeto.

## ✅ Verificar se está rodando
```bash
# Browser
http://localhost:11434/

# Terminal
curl http://localhost:11434/
```

**Resposta esperada:** `Ollama is running`

---

## 📋 Listar modelos instalados
```bash
ollama list
```

**Saída exemplo:**
```
NAME              ID              SIZE      MODIFIED
llama3.2:1b       abc123def       1.3 GB    2 hours ago
codellama:7b      xyz789ghi       3.8 GB    3 days ago
```

---

## 🔍 Ver detalhes de um modelo
```bash
ollama show llama3.2:1b
```

**Mostra:**
- Tamanho do modelo
- Arquitetura
- Parâmetros
- Família

---

## 🗑️ Remover modelo
```bash
ollama rm llama3.2:1b
```

⚠️ **Cuidado:** Isso deleta o modelo permanentemente!

---

## 📥 Baixar novo modelo
```bash
# Baixar modelo
ollama pull llama3.2:1b

# Baixar versão específica
ollama pull llama3.2:3b
```

---

## 🚀 Rodar modelo no terminal (teste rápido)
```bash
ollama run llama3.2:1b
```

Abre chat interativo. `Ctrl+D` para sair.

---

## 🛠️ Comandos úteis para desenvolvimento

### Ver uso de recursos
```bash
ollama ps
```

Mostra modelos em execução e memória usada.

### Parar todos os modelos
```bash
ollama stop llama3.2:1b
```

---

## 🐛 Troubleshooting

### Erro: "connection refused"

**Problema:** Ollama não está rodando

**Solução:**
```bash
# macOS
brew services start ollama

# Linux
sudo systemctl start ollama

# Windows
ollama serve
```

### Erro: "model not found"

**Problema:** Modelo não instalado

**Solução:**
```bash
ollama pull llama3.2:1b
```

---

## 🔗 Links Relacionados

- [← Voltar ao README principal](README.md)

---

## 📚 Documentação Oficial

- [Ollama Docs](https://github.com/ollama/ollama/blob/main/docs/README.md)
- [Modelos Disponíveis](https://ollama.com/library)

---

*Última atualização: Janeiro 2025*













