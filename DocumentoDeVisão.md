# Documento de Visão

## Sistema Bancário

### Histórico da Revisão 

|  Data  | Versão | Descrição | Autor |
|:-------|:-------|:----------|:------|
| 27/01/2025 |  **`1.00`** | Versão Inicial  | Antônio Irineu & Gustavo Maia |


### 1. Objetivo do Projeto 

O projeto __Sistema Bancário__ tem como objetivo prover uma solução simples, acessível e padronizada que simule um sistema bancário.

### 2. Descrição do Problema 

|         __        | __   |
|:------------------|:-----|
| **_O problema_**    | Tornar mais ágil o acesso ao seu banco, o que por praticidade e agilidade realizar transações, depósitos, ver o extrato, etc.  |
| **_afetando_**      | Profissionais e empresas que precisam se deslocar à uma lotérica ou caixa eletrônico para realizar uma simples transação. |
| **_cujo impacto é_**| Atraso em outras emergências e falta de praticidade. |
| **_uma boa solução seria_** | Um sistema na Internet que permita os usuários, de forma ágil, ter o controle total de suas ações bancárias. |

### 3. Descrição dos Usuários

| Nome | Descrição | Responsabilidades |
|:---  |:--- |:--- |
| Administrador  | Realiza as atividades básicas para o início da operação do sistema | Mantém o cadastro dos usuários, além de ser responsável pelo cadastro dos seguros e cartões |
| Usuário  | Realiza as atividades relacionadas às operações | Mantém o contrato de seguros; Depósito, transações e extrato; Pedido e acesso aos seus cartões |


### 4. Descrição do Ambiente dos Usuários

Diante do crescimento exponencial da demanda por agilidade, tornou-se essencial gerenciar a vida financeira de maneira eficiente, sem consumir excessivamente o tempo das pessoas. Esse cenário impulsionou o surgimento dos bancos digitais, que surgiram como uma solução prática para agilizar processos bancários, como depósitos, transações e solicitações de cartões. Além disso, a facilidade de acesso e a interface amigável desses sistemas têm proporcionado uma experiência mais satisfatória ao cliente, permitindo-lhe gerenciar suas finanças em qualquer lugar e a qualquer hora.

Esse avanço no setor bancário não só melhora a praticidade, mas também fortalece a segurança dos usuários, pois os bancos digitais investem constantemente em tecnologias de proteção, como autenticação biométrica e criptografia, para garantir que as informações dos clientes estejam sempre seguras. Assim, a proposta central desse sistema é oferecer aos clientes um controle mais intuitivo de suas finanças, garantindo segurança e agilidade em todas as operações.

### 5. Principais Necessidades dos Usuários

Para os clientes, as necessidades são ter acesso rápido a sua conta bancária e realizar as operações em poucos toques!

### 6.	Alternativas Concorrentes

As alternativas concorrentes são, em geral, específicas para uma empresa ou profissional. A ideia do sistema proposto é prover uma solução simples, acessível e padronizada ao sistema bancário e que pode ser utilizada por quaisquer usuários e bancos.

### 7.	Visão Geral do Produto

Em resumo, o sistema bancário é uma aplicação que permite os bancos administrarem seus usuários, e os clientes realizarem suas operações bancárias rapidamente.

O sistema deve ter uma interface amigável e permitir o acesso concorrente de clientes para suas operações bancárias.

### 8. Requisitos Funcionais

| Código | Nome | Descrição |
|:---  |:--- |:--- |
| RF01 | Entrar no sistema | Usuários devem logar no sistema para acessar as funcionalidades relacionadas ao agendamento |
| RF02 | Cadastro de Clientes | Administrador do sistema mantém o cadastro dos clientes |
| RF03 | Cadastro de Seguros | Administrador do sistema mantém o cadastro dos seguros |
| RF04 | Cadastro de Categorias | Administrador do sistema mantém o cadastro das categorias dos cartões |
| RF05 | Cadastro de Cartões | Administrador do sistema mantém o cadastro dos cartões |
| RF06 | Ver o saldo | Administrador do sistema mantém o cadastro dos funcionários responsáveis pelo gerenciamento das agendas |
| RF07 | Ver extrato |  Funcionário mantém a relação de serviços prestados pela empresa ou profissional |
| RF08 | Depositar | Funcionário registra os horários disponíveis de atendimento, confirma e cancela o agendamento de clientes |
| RF09 | Transferir | Cliente deve realizar o auto cadastramento |
| RF10 | Contratar seguro | Cliente consulta agendas de atendimento dos serviços disponíveis, podendo agendar um serviço  |
| RF11 | Ver seus seguros | Cliente consulta atendimentos agendados, podendo cancelar um agendamento |
| RF12 | Pedir um cartão | Usuários devem logar no sistema para acessar as funcionalidades relacionadas ao agendamento |
| RF13 | Ver cartões | Administrador do sistema mantém o cadastro dos funcionários responsáveis pelo gerenciamento das agendas |

### 9. Requisitos Não-funcionais

 Código | Nome | Descrição | Categoria | Classificação
|:---  |:--- |:--- |:--- |:--- |
| RNF01 | Criptografia de dados| Senhas de usuários devem ser gravadas de forma criptografada no banco de dados. | Segurança | Obrigatório |
| RNF02 | Controle de acesso | Só usuários autenticados podem ter acesso ao sistema, com exceção ao auto cadastramento do usuário. | Segurança | Obrigatório |
| RNF03 | Tempo de resposta |A comunicação entre o servidor e o cliente deve ocorrer em tempo hábil | Performance | Desejável |
| RNF04 | Sistema Web | A aplicação deve ser um site. | Arquitetura | Desejável |
| RNF05 | Dados pessoais | Os clientes não devem visualizar dados de outros clientes (na agenda, por exemplo). | Privacidade | Obrigatório |
