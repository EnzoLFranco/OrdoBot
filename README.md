<div align="center">
  
# Ordobot
![Simbolo_ordem](https://github.com/user-attachments/assets/abca7eeb-3dce-41e5-9c2a-632aa9fcebf7)

### Bem vindo ao repositorio do nosso projeto.
</div>

## Sumario
* [Sobre o projeto](#installation)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Funções e comandos](#funções-e-comandos) 
  * [Comandos](#comandos)
* [Como executar](#como-executar)

## Sobre o projeto
Este projeto é voltado a jogadores de RPG de mesa, evitando uma pesquisa manual para as informações de certos monstros, ao perguntar de um determinado monstro, o bot respondera a pergunta com a informação fornecida a ele pelo documento "info.txt".

## Tecnologias utilizadas

<div style="display: inline_block"><br/>
 <img alingn="center" alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
 <img alingn ="center" alt="Intellij" src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
 <img alingn="center" alt="GitHub" src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/>
 <img alingn="center" alt="Git" src="https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white"/>
</div><br/>

+ #### O modelo de Inteligencia artificial utilizado é o [Ollama](https://ollama.com/), especificamente o modelo gemma: 2b;
+ #### API utilizada para para execução do projeto [Telebof](https://github.com/natanimn/Telebof).


## Funções e comandos
O bot inclui funções como adquirir informações de monstros citados no arquivo "info.txt" e rolar dados comumente utilizados em uma jogatina de RPG.

### Comandos
+ /start = executa a mensagem de introdução do bot;
+ /help = explica os comandos disponiveis na versão;
+ /aleatorio = entrega dados de um monstro aleatorio contido no "info.txt";
+ /rolar = rola o tipo de dado especificado no comando, Ex: /rolar d6;

## Como executar
+ O projeto necessita de algumas dependencias para seu funcionamento completo, é recomendado a instalação da IDE [Intellij](https://www.jetbrains.com/idea/);
Foi utilizado Intellij Idea Community Edition no desenvolvimento do projeto, logo é a versão recomendada para instalação.
+ Tambem é necessario a inteligencia artificial [Ollama](https://ollama.com/);
Apos instalar o Ollama, execute o aplicativo e digite o comando "ollama run gemma2:2b".
+ Clone o projeto para sua maquina local com o Ollama rodando;
+ Abra o projeto no Intellij e aguarde a instalação automática das dependencias do projeto;
+ Abra o arquivo "Ordobot.java" e insira o Token de seu bot na seguinte linha;
  
  ´´´java
  static final String TOKEN = "INSIRA SEU TOKEN AQUI";
  ´´´
  
+ Execute o arquivo "Ordobot.java"

## Conclusão
Este projeto de bot do telegram utilizando Ollama e o API Telebof possui flexibilidade, ótimo potencial para execução de diversas funções e uma capacidade de aliviar um pouco do trabalho manual que mestres possuem ao pesquisar informações de monstros.
[→ Voltar ao topo](#ordobot)
