import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        //CRIA O GERENCIADOR, CARREGA OS DADOS E CRIA O OBJETO DE ENTRADA DE DADOS
        Gerenciador gerenciador = new Gerenciador();
        gerenciador.carregarDados();
        InterfaceUsuario iu = new InterfaceUsuario();

        //MENU DE INTERAÇÃO COM O USUÁRIO
        while(true){
            String menu = """
                    
                    ---MENU---
                    [1] Adicionar disciplina
                    [2] Remover disciplina
                    [3] Consultar disciplina
                    [4] Exibir disciplinas
                    [5] Sair""";

            JOptionPane.showMessageDialog(null, menu);

            String opcao = JOptionPane.showInputDialog("Informe a opção: ");

            //VERIFICA SE CANCELOU A OPERAÇÃO
            if (opcao == null) {
                gerenciador.salvarArquivos();
                return;
            }

            //VERIFICA A OPÇÃO ESCOLHIDA E REALIZA AS OPERAÇÕES
            switch (opcao){
                case "1":
                    JOptionPane.showMessageDialog(null,"Adicionar disciplina\n");
                    iu.cadastrarDisciplina(gerenciador);
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null,"Remover disciplina\n");
                    iu.consultarDisciplinaEntrada(gerenciador,opcao);
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null,"Consultar discipina\n");
                    iu.consultarDisciplinaEntrada(gerenciador,opcao);
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null,"Exibir disciplinas\n");
                    gerenciador.exibirDisciplinas();
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null,"Sair\n");
                    gerenciador.salvarArquivos();
                    JOptionPane.showMessageDialog(null,"Encerrando programa e salvando dados...");
                    return;

                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida!\n");
            }
        }
    }
}