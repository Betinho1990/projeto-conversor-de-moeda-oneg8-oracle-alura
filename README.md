# 💱 Conversor de Moedas Java

Este é um projeto de **conversor de moedas** desenvolvido em **Java** utilizando a API [ExchangeRate-API](https://www.exchangerate-api.com/). O sistema permite ao usuário converter valores entre diferentes moedas, exibindo informações relevantes como o **nome do país** associado à moeda e registrando as conversões realizadas.

---

## 🚀 Funcionalidades

- 🔄 **Conversão de moedas em tempo real** utilizando taxas da API.
- 🌍 Exibição do **nome do país** ao lado do código da moeda.
- 📄 Geração de **histórico de conversões**, que pode ser visualizado durante a execução.
- 🕒 Registro de **logs de conversão** com data e hora, salvos automaticamente em um arquivo `.txt`.

---

## 📦 Implementações extras

- ✅ **Interface interativa via terminal**, com menus para facilitar o uso.
- ✅ Lista de **moedas fixas mais utilizadas**, exibidas de forma numerada.
- ✅ Arquivo `historico_conversoes.txt` para guardar as operações realizadas pelo usuário.
- ✅ Tratamento de erros e entrada inválida para garantir robustez na execução.

---

## 📂 Estrutura dos arquivos

- `Principal.java` – classe principal que executa o fluxo do sistema.
- `MoedaApiResposta.java` – mapeia a resposta JSON da API.
- `MoedaNomePaises.java` – mapeia os códigos das moedas para o nome dos respectivos países.
- `historico_conversoes.txt` – arquivo onde são salvos os logs de conversões com data e hora.

---

## 💻 Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/Betinho1990/conversor-moedas.git

---
## 🛠 Tecnologias usadas
- Java 17+

- IntelliJ IDEA

- ExchangeRate-API

- Gson (para parsing JSON)

- Java HTTP Client

- java.time (para timestamps de log)

## 📸 Exemplo de uso

``` 
=== Conversor de Moedas ===
1 - USD (Estados Unidos)
2 - BRL (Brasil)
...

Digite o número da moeda de ORIGEM: 1
Digite o número da moeda de DESTINO: 2
Digite o valor a ser convertido: 500

500.00 USD = 2805.30 BRL
```
## 📚 Histórico de conversões
Ao final de cada conversão, um log é salvo em `historico_conversoes.txt`, com informações como:
```
2025-05-15T14:22:10 - 500.0 USD -> 2805.3 BRL
```
##🧾 Licença
Este projeto é apenas para fins educacionais. Sinta-se à vontade para usar, modificar e compartilhar.

## 🙋‍♂️ Autor
Desenvolvido por Roberto Gonçalves Conceição Filho 🧠




