import javax.swing.*;
import java.io.*;

public class GerenciadorDisciplinas {
    static int contador = 0;
    static String[][] lista = new String[100][5];
    static boolean encontrou = false;

    public void addDisciplinas(Disciplina disciplina){


        lista[contador][0] = disciplina.getNomeDisciplina();
        lista[contador][1] = String.valueOf(disciplina.getNota1());
        lista[contador][2] = String.valueOf(disciplina.getNota2());
        lista[contador][3] = String.valueOf(disciplina.getFrequencia());
        lista[contador][4] = disciplina.getStatus();

        JOptionPane.showMessageDialog(null,"Disciplina adicionada com sucesso!\n");
        contador ++;
    }
    public void consultarDisciplinaEntrada(){
        String busca = JOptionPane.showInputDialog("Nome da disciplina");
        String buscaFormatada = Disciplina.formatarNome(busca);
        consultarDisciplina(buscaFormatada, 0);
    }
    public void consultarDisciplina(String buscaFormatada, int i){
        String resultadoBusca = "";

        if (i >= lista.length){
            JOptionPane.showMessageDialog(null,"Não achei essa disciplina");
            return;
        }

        if(buscaFormatada.equals(lista[i][0])){
            resultadoBusca = "Achei\n" + "Disciplina: " + lista[i][0] + ", Nota 1: " + lista[i][1] + ", Nota 2: " + lista[i][2] + "," +
                    " Frequência: " + lista[i][3] + ", Situação: " + lista[i][4];
            encontrou = true;
        }
        else{
            consultarDisciplina(buscaFormatada, i + 1);
        }

        if (!resultadoBusca.isEmpty()){
            JOptionPane.showMessageDialog(null,resultadoBusca);
        }
    }
    public void exibirDisciplinas() {
        JOptionPane.showMessageDialog(null,"-----Lista de disciplinas-----");
        for (int i = 0; i < contador; i++){
            JOptionPane.showMessageDialog(null,"Disciplina: " + lista[i][0] + /*", Nota 1: " + lista[i][1] + ", Nota 2: " + lista[i][2] + "," +
                    " Frequência: " + lista[i][3] + */", Situação: " + lista[i][4]);
        }
    }
    public void salvarArquivos(){
        try (BufferedWriter escrever = new BufferedWriter(new FileWriter("Disciplinas.txt"))) {
            for (int i = 0; i < contador; i++){
                escrever.write(lista[i][0] + ";" + lista[i][1] + ";" + lista[i][2] + ";" + lista[i][3] + ";" + lista[i][4]);
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

            while ((linha = leitor.readLine()) != null){
                String[] partes = linha.split(";");

                if (partes.length == 5){
                    lista[contador][0] = partes[0];
                    lista[contador][1] = partes[1];
                    lista[contador][2] = partes[2];
                    lista[contador][3] = partes[3];
                    lista[contador][4] = partes[4];

                    contador ++;
                }
            }
            JOptionPane.showMessageDialog(null,"Dados carregados com sucesso!");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,"Erro ao carregar o arquivo!" + e.getMessage());
        }
    }
}
