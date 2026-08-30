# Calculadora de IMC

Aplicação desktop simples, desenvolvida em Java com JavaFX, para calcular o Índice de Massa Corporal (IMC) a partir do peso e da altura informados pelo usuário.

## 📋 Funcionalidades

- Interface gráfica intuitiva construída com JavaFX.
- Cálculo do IMC a partir de peso (kg) e altura (m).
- Aceita tanto vírgula quanto ponto como separador decimal (ex.: `70,5` ou `70.5`).
- Classificação automática do resultado nas seguintes faixas:

| IMC             | Classificação           |
|-----------------|--------------------------|
| < 17            | Muito abaixo do peso     |
| 17 – 18,49      | Abaixo do peso           |
| 18,5 – 24,99    | Peso normal              |
| 25 – 29,99      | Acima do peso            |
| 30 – 34,99      | Obesidade I              |
| 35 – 39,99      | Obesidade II (severa)    |
| ≥ 40            | Obesidade III (mórbida)  |

- Validação de entradas: valores negativos, zero ou não numéricos exibem mensagens de erro amigáveis em vez de travar a aplicação.
- Campos de entrada limpos automaticamente após cada cálculo.

## 🛠️ Tecnologias utilizadas

- **Java** (JDK 17 ou superior recomendado)
- **JavaFX** (Application, Scene, GridPane, Label, TextField, Button)
- **CSS** para estilização da interface (`style.css`)

## 📁 Estrutura do projeto

```
calculadora-imc/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── calculadora_imc/
│       │           └── CalculadoraIMC.java
│       └── resources/
│           └── com/
│               └── calculadora_imc/
│                   └── style.css
├── pom.xml
└── README.md
```

## ✅ Pré-requisitos

- [JDK 17+](https://adoptium.net/) instalado e configurado no `PATH`.
- [JavaFX SDK](https://openjfx.io/) (caso o JDK utilizado não inclua o JavaFX nativamente) **ou** gerenciamento via Maven/Gradle com as dependências do JavaFX.
- Um dos seguintes: Maven, Gradle, ou apenas o JDK com JavaFX SDK para compilação manual.

## ▶️ Como executar

### Opção 1 — Usando Maven (recomendado)

Adicione o plugin do JavaFX ao `pom.xml`:

```xml
<plugin>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-maven-plugin</artifactId>
    <version>0.0.8</version>
    <configuration>
        <mainClass>com.calculadora_imc.CalculadoraIMC</mainClass>
    </configuration>
</plugin>
```

E execute:

```bash
mvn clean javafx:run
```

### Opção 2 — Linha de comando com JavaFX SDK

```bash
javac --module-path /caminho/para/javafx-sdk/lib --add-modules javafx.controls -d out src/main/java/com/calculadora_imc/CalculadoraIMC.java

java --module-path /caminho/para/javafx-sdk/lib --add-modules javafx.controls -cp out com.calculadora_imc.CalculadoraIMC
```

Substitua `/caminho/para/javafx-sdk/lib` pelo diretório `lib` do JavaFX SDK baixado.

## 🖥️ Como usar

1. Abra a aplicação.
2. Informe o peso (em kg) no campo correspondente.
3. Informe a altura (em metros) no campo correspondente.
4. Clique em **Calcular**.
5. O resultado exibirá o valor do IMC e sua classificação.

## ⚠️ Tratamento de erros

- **Entradas não numéricas**: exibe a mensagem "Entrada inválida! Insira apenas números".
- **Peso ou altura ≤ 0**: exibe "Peso e altura devem ser maiores do que 0".

## 🚀 Possíveis melhorias futuras

- Adicionar histórico de cálculos.
- Permitir alternar entre unidades (kg/lb, m/ft).
- Exportar resultado em PDF ou compartilhar.
- Testes unitários para a lógica de cálculo do IMC.
