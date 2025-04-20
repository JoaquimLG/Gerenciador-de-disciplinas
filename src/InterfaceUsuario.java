import javax.swing.JOptionPane;

//CLASSE DE ENTRADA DE DADOS
public class InterfaceUsuario {
    public void cadastrarDisciplina(Gerenciador gerenciador){

        String nomeDisciplina = JOptionPane.showInputDialog("Disciplina: ");
        if (nomeDisciplina == null) {
            JOptionPane.showMessageDialog(null,"Operação cancelada");
            return;
        }
        String nomeValidar = Disciplina.formatarNome(nomeDisciplina);
        boolean existe = gerenciador.validarDisciplina(nomeValidar);

        if (existe) {
            JOptionPane.showMessageDialog(null,"Essa disciplina já foi cadastrada");
        }
        else {

            double nota1, nota2, frequencia;

            do {
                String entradaNota1 = JOptionPane.showInputDialog(null, "Nota 1: ");
                if (entradaNota1 == null) {
                    JOptionPane.showMessageDialog(null, "Operação cancelada");
                    return;
                }
                try {
                    nota1 = Double.parseDouble(entradaNota1);
                    if (nota1 > 10 || nota1 < 0) {
                        JOptionPane.showMessageDialog(null, "Nota inválida, digite um valor de 0 até 10");
                        nota1 = -1;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida, digite um valor de 0 até 10");
                    nota1 = -1;
                }
            } while (nota1 == -1);

            do {
                String entradaNota2 = JOptionPane.showInputDialog(null, "Nota 2: ");
                if (entradaNota2 == null) {
                    JOptionPane.showMessageDialog(null, "Operação cancelada");
                    return;
                }
                try {
                    nota2 = Double.parseDouble(entradaNota2);

                    if (nota2 > 10 || nota2 < 0) {
                        JOptionPane.showMessageDialog(null, "Nota inválida, digite um valor de 0 até 10");
                        nota2 = -1;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida, digite um valor de 0 até 10");
                    nota2 = -1;
                }
            } while (nota2 == -1);

            do {
                String entradaFrequencia = JOptionPane.showInputDialog(null, "Frequência(%): ");
                if (entradaFrequencia == null) {
                    JOptionPane.showMessageDialog(null, "Operação cancelada");
                    return;
                }

                //CASO O USUÁRIO DIGITE COM A % EX. 72%
                entradaFrequencia = entradaFrequencia.replace("%", "");

                try {
                    frequencia = Double.parseDouble(entradaFrequencia);
                    if (frequencia < 0 || frequencia > 100) {
                        JOptionPane.showMessageDialog(null, "Frequência inválida, digite um valor de 0 até 100");
                        frequencia = -1;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida, digite um valor de 0 até 100");
                    frequencia = -1;
                }
            } while (frequencia == -1);

            Disciplina disciplina = new Disciplina(nomeDisciplina, nota1, nota2, frequencia);
            gerenciador.addDisciplinas(disciplina);
        }
    }

    public void consultarDisciplinaEntrada(Gerenciador gerenciador, String opcao){
        String busca = JOptionPane.showInputDialog("Nome da disciplina: ");
        if (busca == null) {
            JOptionPane.showMessageDialog(null,"Operação cancelada");
            return;
        }
        String buscaFormatada = Disciplina.formatarNome(busca);

        gerenciador.consultarDisciplina(buscaFormatada, opcao);
    }

}