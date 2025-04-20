# Gerenciador de Disciplinas

Projeto desenvolvido com o objetivo de praticar **Java** e os conceitos de **Programação Orientada a Objetos (POO)**. O sistema permite o gerenciamento de disciplinas cadastradas pelo usuário, com suporte a armazenamento em arquivo e interface via `JOptionPane`.

## Funcionalidades

- Cadastrar disciplina com nome, duas notas e frequência.  
- Validar se uma disciplina já foi cadastrada.  
- Consultar os dados de uma disciplina.  
- Remover disciplinas.  
- Exibir todas as disciplinas cadastradas.  
- Calcular o status da disciplina com base em notas e frequência.  
- Salvar os dados em arquivo `.txt`.  
- Carregar os dados salvos ao iniciar o programa.

## Estrutura do Projeto

- `Disciplina.java`: classe que representa uma disciplina, contendo atributos e lógica para cálculo de status (Aprovado/Reprovado).
- `Gerenciador.java`: classe responsável por manter a lista de disciplinas, salvar/carregar do arquivo, e fazer buscas/remoções.
- `InterfaceUsuario.java`: interface intermediária para interações com o usuário via `JOptionPane`.
- `Main.java`: ponto de entrada do sistema. Exibe o menu interativo e gerencia o ciclo de execução.

## Interface

A interface é feita com caixas de diálogo (`JOptionPane`), permitindo uma navegação simples por menus e mensagens informativas.

## Salvamento

Os dados das disciplinas são armazenados em um arquivo de texto chamado `Disciplinas.txt`, com formatação legível e cabeçalho. O carregamento dos dados é feito automaticamente ao iniciar o programa.

## Tecnologias Utilizadas

- Java (JDK 17 ou superior recomendado)
- Swing (`javax.swing.JOptionPane`)
- Manipulação de arquivos (`java.io`)

## Observações

- O sistema trata entradas inválidas e evita cadastros duplicados.
- A frequência pode ser digitada com ou sem o símbolo `%`.
- Arquivos antigos são sobrescritos automaticamente ao sair do programa.
