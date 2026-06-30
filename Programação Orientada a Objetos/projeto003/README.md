## Projeto - Sistema de Biblioteca Universitária
### Discente: Júlia Montagnini
Projeto final desenvolvido para a disciplina de Programação Orientada a Objetos, com o objetivo de implementar os conceitos aprendidos durante o semestre.


## Sistema
O sistema apresenta uma biblioteca capaz de registrar usuários, livros, exemplares, empréstimos e devoluções.

### Conceitos de POO utilizados:
- O `encapsulamento` está presente em todo o projeto, distribuindo as responsabilidades de modo a concentrar cada função na classe mais adequada.

- O conceito de `associação` pode ser visto em Empréstimo-Usuário e Empréstimo-Exemplar, pois eles existem separadamente mas se referenciam.

- A relação de `composição` é nítida em Livro, o qual possui seus Exemplares, e estes só existem havendo um livro.

- A `agregação` é presente ao analisar a Biblioteca abrigando coleções (lista e hashmaps) de usuários, livros, exemplares e empréstimos.

- Além disso, relacionamentos de `herança` estão presentes nas classes Aluno, Professor e Servidor, as quais são tipos de Usuário. O `polimorfismo` foi essencial para o funcionamento adequado do sistema, fazendo com que cada classe filha pudesse ser inserida em uma mesma estrutura que abrigava simplesmente usuários, mas ainda retornando seus atributos específicos em qualquer chamada.

- Por fim, uma `interface` Relatorio garantiu que relatórios fossem implementados em outras classes. 

### Principais classes
- **Aluno, Professor e Servidor:** armazenam as informações de cada usuário, como nome, matrícula, email, limite de empréstimos, prazo para empréstimos, curso e período para alunos, departamento e titulação para professores e cargo e setor para servidores.
- **Empréstimo:** controla a criação de empréstimos, armazenando datas de empréstimo e devolução, controle de multas em caso de atraso, status do empréstimo (ativo, atrasado ou devolvido) e vinculação do usuário e do exemplar.
- **Exemplar:** armazena as informações de cada exemplar, a qual livro ele está vinculado e controla seu status de empréstimo (disponível, emprestado ou bloqueado).
- **Livro:** armazena as informações de cada livro, a lista de seus exemplares e gera relatórios acerca dos exemplares.
- **BibliotecaService:** atua como o coração do sistema, centralizando todas as regras de negócio (cadastros, validações de limites, bloqueios de operações inválidas e geração de mais relatórios), deixando a função principal apenas com a função de chamar os métodos aqui construídos.

## Execução
> Para executar o projeto deve-se ter instalado o Java 17 (ou superior), e o projeto deve ser baixado com todos os pacotes como já organizados aqui.

No terminal, dentro da pasta `src`, basta executar 
``` bash
javac br/ufla/gct052/biblioteca/*/*.java
```
o que compila os arquivos, e em seguida digitar
```bash
java br.ufla.gct052.biblioteca.app.App
```
executando o projeto.
