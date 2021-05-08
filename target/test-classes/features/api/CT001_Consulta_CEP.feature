# language: pt
# encoding: utf-8
@api
Funcionalidade: Validar um serviço de consulta de CEP
  
  - Eu, como testador, gostaria de realizar
  uma consulta afim de obter dados de CEPs,
  com base no respectivo serviço.
  
  - Também serão validados nesse circuito,
  as chaves e os valores presentes no retorno.

  @CT_001_Valida_CEP
  Esquema do Cenário: Validar o retorno da consulta de CEP
    Dado que eu consulto o "<CEP>"
    Então os dados de CEP "<LOGRADOURO>" "<COMPLEMENTO>" "<BAIRRO>" "<LOCALIDADE>" "<UF>" "<IBGE>" "<GIA>" "<DDD>" "<SIAFI>" deverão ser validados

    Exemplos: 
      | CEP       | LOGRADOURO          | COMPLEMENTO | BAIRRO    | LOCALIDADE | UF | IBGE    | GIA  | DDD | SIAFI |
      | 05425-020 | Rua Gilberto Sabino |             | Pinheiros | São Paulo  | SP | 3550308 | 1004 |  11 |  7107 |
      | 06090-000 | Rua João Crudo      |             | Centro    | Osasco     | SP | 3534401 | 4923 |  11 |  6789 |
      | 03040-000 | Rua Carneiro Leão   | até 599/600 | Brás      | São Paulo  | SP | 3550308 | 1004 |  11 |  7107 |
