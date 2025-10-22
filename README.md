[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/5YVqiNIR)
### Avaliação continuada 2 - Linguagem de Programação

Você deve implementar as classes **Vacina** e **Laboratorio** de acordo com as especificações a seguir. As classes estão
vazias e já possuem testes prontos que validarão o seu código. O objetivo é implementar as classes de modo que todos os
testes passem.

#### 1. Classe **Vacina**

A classe `Vacina` deve representar uma vacina com as seguintes características:

- **Atributos**:
    - `String codigo`: Código único que identifica a vacina.
    - `String nome`: Nome da vacina.
    - `String tipo`: Tipo da vacina (ex: Vírus inativado, Bactéria viva atenuada, Vírus atenuado).
    - `Double preco`: Preço da vacina.
    - `Double eficacia`: Eficácia da vacina em uma escala de 0 a 100.
    - `LocalDate dataLancamento`: Data de lançamento da vacina.

- **Construtores**:
    - Um **construtor sem argumentos**.

- **Getters e Setters**:
    - **Getter** e **Setter** para todos os atributos: `codigo`, `nome`, `tipo`, `preco`, `eficacia` e `dataLancamento`.

- **Métodos**:
    - `String getEficaciaDescricao()`: Esse método deve retornar uma descrição baseada na eficácia da vacina:
        - Se a eficácia for maior ou igual a 90.5, retornar `"EXCELENTE"`.
        - Se a eficácia for maior ou igual a 75.5, retornar `"BOM"`.
        - Se a eficácia for maior ou igual a 50.5, retornar `"REGULAR"`.
        - Caso contrário, retornar `"RUIM"`.

  > **Exceções**: Não há necessidade de lançar exceções nessa classe.

---

#### 2. Classe **Laboratorio**

A classe `Laboratorio` deve representar um laboratório que gerencia uma lista de vacinas.

- **Atributos**:
    - `String nome`: Nome do laboratório.
    - `List<Vacina> vacinas`: Lista de vacinas que o laboratório gerencia.

- **Construtores**:
    - Um **construtor sem argumentos**.

- **Getters**:
    - **Getter e Setter** para o atributo `nome`.
    - **Getter** para o atributo `vacinas` (não deve haver um setter para `vacinas`).

  - **Métodos**:
      - `void adicionarVacina(Vacina vacina)`: Adiciona uma vacina à lista de vacinas do laboratório.

        - **Comportamento esperado**:
          - vacina: A vacina a ser adicionada não pode ser nulo. Se a vacina for nulo, lançar uma `VacinaInvalidaException`.
          - código: O código da vacina deve ser válido (não nulo e não vazio). Se o código for inválido, lançar
            uma `VacinaInvalidaException`.
          - nome: O nome da vacina deve ser válido (não nulo e não vazio). Se o nome for inválido, lançar
            uma `VacinaInvalidaException`.
          - tipo: O tipo da vacina deve ser válido (não nulo e não vazio). Se o tipo for inválido, lançar
            uma `VacinaInvalidaException`.
          - preço:  O preço da vacina deve ser maior que zero e não nulo. Se o preço for inválido (por exemplo, valor menor ou igual a zero ), lançar a exceção `VacinaInvalidaException`.
          - eficacia: A eficácia da vacina deve estar dentro do intervalo de 0 a 5. Se a eficácia estiver fora desse
            intervalo, lançar uma `VacinaInvalidaException`.
          - data de lançamento: A data de lançamento da vacina deve ser válida (não nula e não pode ser uma data futura). Se a data de lançamento for inválida ou estiver no futuro, lançar a exceção `VacinaInvalidaException`.

      - `Vacina buscarVacinaPorCodigo(String codigo)`: Busca uma vacina na lista de vacinas pelo seu código.
          - **Comportamento esperado**:
              - Deve validar se o código fornecido não é nulo, vazio ou em branco.
              - Se o código for inválido, deve lançar uma `ArgumentoInvalidoException`.
              - Se a vacina não for encontrada, deve lançar uma `VacinaNaoEncontradaException`.
    
      - `void removerVacinaPorCodigo(String codigo)`: Remove uma vacina da lista com base no seu código.
          - **Comportamento esperado**:
              - Se a vacina não for encontrada, deve lançar uma `VacinaNaoEncontradaException`.
              - Se o código fornecido for nulo, vazio ou em branco, deve lançar uma `ArgumentoInvalidoException`.

      - `Vacina buscarVacinaComMelhorEficacia()`: Busca a vacina com a melhor eficácia.
          - **Comportamento esperado**:
              - Se duas ou mais vacinas tiverem a mesma eficácia, deve-se retornar a mais recente (com a data de lançamento
                mais recente).
              - Se não houver vacinas na lista, deve lançar uma `VacinaNaoEncontradaException`.
          
              - **Observação**: Considere que nos cenários a serem testados, não existe a possibilidade de duas vacinas terem a mesma eficácia e a mesma data de lançamento. 

      - `List<Vacina> buscarVacinaPorPeriodo(LocalDate dataInicio, LocalDate dataFim)`: Retorna uma lista de vacinas cujo
        lançamento esteja entre as datas de início e fim fornecidas.
          - **Comportamento esperado**:
              - Se as datas de início ou fim forem nulas, ou se a data de início for maior que a data de fim, deve lançar
                uma `ArgumentoInvalidoException`.
              - Deve retornar uma lista de vacinas cuja data de lançamento esteja dentro do intervalo fornecido (inclusive).

> **Observação**: O foco da atividade é implementar a lógica dos métodos e suas validações de acordo com as
> especificações, sem alterar os testes.

#### Instruções Adicionais

- As exceções `ArgumentoInvalidoException`, `VacinaInvalidaException` e `VacinaNaoEncontradaException` já estão definidas no
  projeto. Utilize-as conforme especificado.
- Todos os métodos e construtores devem ter visibilidade pública (`public`).
- A lista de vacinas (`vacinas`) deve ser inicializada nos construtores, e não deve haver um setter para este atributo.

> **Dica**: Teste frequentemente seu código. O objetivo é que todos os testes fornecidos passem corretamente.
