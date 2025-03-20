import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GerenciadorDisciplinas gerenciador = new GerenciadorDisciplinas();
        gerenciador.carregarDados();
        while(true){
            String menu = """
                    
                    ---MENU---
                    [1] Adicionar disciplina
                    [2] Consultar disciplina
                    [3] Exibir disciplinas
                    [4] Sair""";
            JOptionPane.showMessageDialog(null, menu);

            int opcao;
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção: "));
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Entrada inválida! Apenas números");
                continue;
            }
            switch (opcao){
                case 1:
                    JOptionPane.showMessageDialog(null,"Adicionar disciplina\n");
                    addDadosDisciplina(gerenciador);

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"Consultar discipina\n");
                    gerenciador.consultarDisciplinaEntrada();

                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Exibir disciplinas\n");
                    gerenciador.exibirDisciplinas();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Sair\n");
                    gerenciador.salvarArquivos();
                    JOptionPane.showMessageDialog(null,"Encerrando programa...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida!\n");
            }
        }
    }
    public static void addDadosDisciplina(GerenciadorDisciplinas gerenciador){

        String nomeDisciplina = JOptionPane.showInputDialog("Disciplina: ");

        double nota1, nota2, frequencia;
        do {
            nota1 = Double.parseDouble(JOptionPane.showInputDialog("Nota 1: "));
            nota2 = Double.parseDouble(JOptionPane.showInputDialog("Nota 2: "));


            if (nota1 > 10 || nota1 < 0 || nota2 > 10 || nota2 < 0){
                JOptionPane.showMessageDialog(null,"Notas inválidas, digite um valor de 0 até 10");
            }

        } while (nota1 > 10 || nota1 < 0 || nota2 > 10 || nota2 < 0);

        do {
            frequencia = Double.parseDouble(JOptionPane.showInputDialog("Frequência: "));
            if(frequencia < 0 || frequencia > 100 ){
                JOptionPane.showMessageDialog(null,"Frequência inválida, digite um valor de 0 até 100");
            }
        } while (frequencia < 0 || frequencia > 100);

        Disciplina disciplina = new Disciplina(nomeDisciplina, nota1, nota2, frequencia);
        gerenciador.addDisciplinas(disciplina);
    }
}
