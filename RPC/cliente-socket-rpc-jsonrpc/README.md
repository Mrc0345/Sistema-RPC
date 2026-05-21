# Cliente Socker RPC com JsonRPC

* Aplicação de terminal com as funcionalidades
- Calculo de raizes
- Calculo das casas decimais de PI
- Estatísticas de um texto

# plano de execução do cliente-servidor e exemplos


```powershell
java -jar target\servidor-socket-rpc-jsonrpc-1.0-SNAPSHOT-jar-with-dependencies.jar
```

O servidor ficará aguardando conexões na porta `7654`.

## 2. Testar O Cliente

Abra outro terminal, sem fechar o servidor.

Entre na pasta do cliente:

```powershell
cd Senai_2026_ADS_DSD-main\RPC\cliente-socket-rpc-jsonrpc
```

Compile o cliente:

```powershell
mvn package
```

Execute:

```powershell
java -jar target\cliente-socket-rpc-jsonrpc-1.0-SNAPSHOT-jar-with-dependencies.jar
```

O menu será exibido:

```txt
1. Calcular Pi com casas decimais
2. Calcular Raízes de uma Equação Quadrática
3. Estatísticas de um texto
0. Sair
```

## 3. Exemplos De Teste Manual

### Opção 1 - PI

Entrada:

```txt
1
6
```

Resultado esperado:

```txt
3.141593
```

### Opção 2 - Bhaskara

Entrada:

```txt
2
a: 1
b: -3
c: 2
```

Resultado esperado:

```txt
2.0 e 1.0
```

### Opção 3 - Estatísticas De Texto

Entrada:

```txt
3
A vingança nunca é plena, mata a alma e envenena.
```

Resultado esperado:

```txt
Quantidade de letras: 38
Quantidade de palavras: 10
Quantidade de vogais sem acento: 18
Quantidade de vogais acentuadas: 1
Quantidade de consoantes: 19
Quantidade de espacos: 9
Quantidade de palavras pares: 4
Quantidade de palavras impares: 6
Quantidade de linhas: 1
```

## 4. Erro Comum

Se aparecer:

```txt
Connection refused: connect
```

significa que o cliente foi aberto sem o servidor estar rodando.

Solução:

1. Abra o servidor primeiro.
2. Deixe o terminal do servidor aberto.
3. Abra o cliente em outro terminal.


