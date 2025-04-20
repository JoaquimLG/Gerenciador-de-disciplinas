import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private final List<Disciplina> listaDisciplinas = new ArrayList<>();

    //RETORNA SE EXISTE A DISCIPLINA NO ARRAY
    public boolean validarDisciplina (String nomeDisciplina) {
          boolean encontrou = false;
          for (Disciplina disciplina : listaDisciplinas) {
              if (disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
                  encontrou = true;
              }
          }
          return encontrou;
      }

    //ADICIONA A DISCIPLINA NO ARRAY
    public void addDisciplinas(Disciplina disciplina){
        listaDisciplinas.add(disciplina);
        JOptionPane.showMessageDialog(null,"Disciplina adicionada com sucesso!\n");
    }

    //REMOVE A DISCIPLINA DO ARRAY
    public void removerDisciplinas(int posicaoDisciplina) {
        listaDisciplinas.remove(posicaoDisciplina);
        JOptionPane.showMessageDialog(null,"Disciplina removida com sucesso!\n");
    }

    //BUSCA A DISCIPLINA NO ARRAY E VERIFICA SE A OPÇÃO ESCOLHIDA FOI DE CONSULTAR OU REMOVER
    //SE A OPÇÃO FOR REMOVER ELE CHAMA removerDisciplinas
    public void consultarDisciplina(String buscaFormatada, String opcao) {
        //BOOLEAN PARA VERIFICAR SE ENCONTROU E VÁRIAVEL PARA OBTER A POSIÇÃO DA DISCIPLINA
        //COMEÇA POR -1 POIS A CADA
        boolean encontrou = false;
        int posicaoDisciplina = -1;

        for (Disciplina disciplina : listaDisciplinas) {
            posicaoDisciplina ++;
            //BUSCA A DISCIPLINA
            if (disciplina.getNomeDisciplina().equals(buscaFormatada)) {
                encontrou = true;
                JOptionPane.showMessageDialog(null, "Disciplina encontrada!\n");
                JOptionPane.showMessageDialog(null, disciplina);
                break;
            }
        }

        //AQUI ELE VERIFICA SE FOI A OPÇÃO 2 ESCOLHIDA E CHAMA A FUNÇÃO DE REMOVER
        if (opcao.equals("2") && encontrou) {
                removerDisciplinas(posicaoDisciplina);
        }

        if (!encontrou) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada!\n");
        }
    }

    public void exibirDisciplinas() {
        StringBuilder disciplinasText = new StringBuilder();
        disciplinasText.append("-----LISTA DE DISCIPLINAS-----\n");
        disciplinasText.append("DISCIPLINA, NOTA 1, NOTA 2, FREQUÊNCIA, STATUS\n");

        for (Disciplina disciplina : listaDisciplinas) {
            disciplinasText.append(disciplina).append("\n");  // Cada disciplina vai em uma nova linha
        }

        JOptionPane.showMessageDialog(null, disciplinasText.toString());
    }

    public void salvarArquivos(){
        try (BufferedWriter escrever = new BufferedWriter(new FileWriter("Disciplinas.txt"))) {

            //AQUI É O MESMO CABEÇALHO DE EXIBIR DISCIPLINAS
            escrever.write("-----LISTA DE DISCIPLINAS-----");
            escrever.newLine();
            escrever.write("DISCIPLINA, NOTA 1, NOTA 2, FREQUÊNCIA, STATUS");
            escrever.newLine();

            //ADICIONA CADA DISCIPLINA EM UMA LINHA
            for (Disciplina disciplina : listaDisciplinas){
                escrever.write(disciplina.toString());
                escrever.newLine();
            }
            JOptionPane.showMessageDialog(null,"Dados salvos com sucesso!");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public void carregarDados(){
        File arquivo = new File("Disciplinas.txt");

        if (!arquivo.exists()){
            return;
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))){
            String linha;

            //PULA DUAS LINHAS, O CABEÇALHO
            leitor.readLine();
            leitor.readLine();

            while ((linha = leitor.readLine()) != null){
                linha = linha.replace("%","");
                String[] partes = linha.split(",");

                if (partes.length == 5){
                    String nomeDisciplina = partes[0].trim();
                    double nota1 = Double.parseDouble(partes[1].trim());
                    double nota2 = Double.parseDouble(partes[2].trim());
                    double frequencia = Double.parseDouble(partes[3].trim());

                    Disciplina disciplina = new Disciplina(nomeDisciplina,nota1,nota2,frequencia);
                    listaDisciplinas.add(disciplina);
                }
            }
            JOptionPane.showMessageDialog(null,"Dados carregados com sucesso!");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,"Erro ao carregar o arquivo!" + e.getMessage());
        }
    }
}