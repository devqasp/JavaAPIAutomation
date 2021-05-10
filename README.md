# JavaAPIAutomation

# Teste de API de Consulta de CEP

## Instalação

- Ter configurado no mínimo *Java 11+*
- IDEs compatíveis: *Ex.: Eclipse / IntelliJ*
- *Apache Maven*
- *Apache JMeter*

## Dos Testes Automatizados

Para esse desafio, foram utilizados os frameworks - *RestAssured, Cucumber e JAssertions* para a avaliação das expectativas de resultado

### Estrutura

- br.com.java.api.automation.model - Contém uma model para os atributos de API - *BodyParams, Header e Response*
- br.com.java.api.automation.utils - Funções utéis para tratamento de Json e Arquivos
- br.com.java.api.automation - Esse pacote contém 1 classe responsável por mapear e validar a API CEP, 1 classe que trata e retorna a URL com um CEP definido no .feature e 1 classe que classifica e organiza as APIs mapeadas (Classe que generalizaasdasd um objeto de API). Com ela (APIRegister.java), podemos herdar qualquer API que for classificada
- br.com.java.api.automation.runner - Contém a classe que executa os testes e dispõe plugins de relatórios
- br.com.java.api.automation.step.definition - Classe que integra o .feature e a classe de mapeamento de uma API
- src/test/resources/ - Contém o .feature e os arquivos de propriedades do *Cucumber* e do *Allure Report*

## Como executar

- Em um terminal, digite a linha:
```bash
mvn clean verify && mvn allure:serve 
```

- **O relatório do Allure abrirá automaticamente no navegador principal**

## Relatórios

- Existem 3 relatórios presentes na pasta *target*:

- Um na pasta *allure-results*, que precisa de um servidor de aplicação para ser executado
- Outro na pasta *cluecumber-reports* - Esse só precisa ser aberto em um navegador, basta clicar no *index.html*
- E o *cucumber-reports* - Para executá-lo, abra no navegador a página *cucumber.html*

- Uma maneira de ver o relatório após a execução e publicado é, no arquivo cucumber.properties, na pasta *src/test/resources/*, você pode alterar os seguintes comandos:
```
cucumber.publish.enabled=true
cucumber.publish.quiet=false
```
- Uma URL será gerada e o relatório será publicado em um servidor da **SmartBear**

## Dos Testes Não Funcionais

*Teste de Conhecimento de Jmeter*

### Funcionalidade:
**Consulta endereço através do CEP**

### Cenário:
**Executar um teste de performance na API de Consulta da VIACEP**

- 10 Threads/Users
- 5 Minutos de Execução
- 20 segundos de subida de usuários
- 20 segundos de queda de usuários

## Descrição do Passo a Passo do Plano de Teste

*1ª Etapa*
- Criar um novo projeto no Jmeter
- Adicionar o componente Ultimate Thread Group [Ultima Thread Group é o componente responsável pela criação da rampa de teste]
- Adicionar o componente de Requisição HTTP
- Inserir as informações da API no componente de Requisição de HTTP
- Adicionar os ouvintes [Ouvintes/Listeners são os componentes resposáveis por gerar informações sobre a execução do teste de performance, como a árvore de resultados que apresenta as informações de envio e retorno da requisição/chamada realizada, como o relatório agregado que traz as informações de métricas de tempo de resposta, tps, taxa de erros, etc...]

*2ª Etapa*
- Executar um smoke teste para validar a chamada de sucesso da API e aproveitar para validar as informações de retorno da API através dos ouvintes
- Adicionar o componente de configuração de dados CSV [Configuração dos Dados CSV é o componente responsável por carregar o arquivo de massa de dados para ser utilizado nos parâmentros de chamada da API]
- Criar o arquivo CSV com o campo de dados "CEP" e realizar o upload no componente de configuração de dados CSV
- Criar a variável ${CEP} no campo de valor de CEP do caminho da chamada da API
- Adicionar o componente de asserção de resposta [Asserções de Resposta é o componente responsável por validar o retorno da requisição por código de resposta, mensagem de resposta, ou por asserções de campos de JSON ou por XPATH, entre outros]

*3ª Etapa*
- Executar novamente um smoke para validar a massa de dados adicionada e as asserções de respostas 
- Configurar um cenário de execução no componente Ultimate Thread Group [Baseado no Cenário descrito no início]
- Adicionar arquivo .csv em branco no componotente de escritor de dados simples
- Executar o teste de performance através da GUI do Jmeter ou através de linha de código via terminal
- Gerar relatório HTML (estilo deashboard) após a execução do teste de performamnce através da GUI do Jmeter ou através de linha de comando via terminal


**Observação**: *Ao executar as validações de smoke test com apenas 1 usuário a API da Via Cep retornou todas as requisições, porém ao executar o cenário de teste de performance a rede/ip da máquina utilizado no teste de performance foi bloqueado apresentando o erro ERR_NETWORK_CHANGED, com isso não foi possível gerar um relatório de execução*
