import java.text.Normalizer;

public class Disciplina {

    private final String nomeDisciplina;
    private final double nota1;
    private final double nota2;
    private final double frequencia;
    private final String status;

    public Disciplina(String nomeDisciplina, double nota1, double nota2, double frequencia){
        this.nomeDisciplina = nomeDisciplina;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.frequencia = frequencia;
        this.status = situacao(nota1,nota2,frequencia);
    }

    //UTILIZADO PARA COMPARAR O NOME DA DISCIPLINA
    public String getNomeDisciplina(){
        return formatarNome(nomeDisciplina);
    }

    //RETORNA O STATUS DO ALUNO
    public String situacao(double nota1, double nota2, double frequencia){
        //A PARTIR MÉDIA DAS NOTAS E FREQUÊNCIA, RETORNA A SITUAÇÃO DO ALUNO
        double media = (nota1 + nota2) / 2;

        if (media >= 7 && frequencia >= 75){
            return "Aprovado";
        }
        else if(media >= 7){
            return "Reprovado por falta";
        }
        else if (media >= 5 && frequencia >= 75){
            double pontuacaoFinal = (5 - media * 0.6) / 0.4;
            return String.format("Final | Precisa na final: %.2f", pontuacaoFinal);
        }
        else if (media >= 5){
            return "Reprovado por falta";
        }
        else if (frequencia >= 75){
            return "Reprovado por nota";
        }
        else{
            return "Reprovado por nota e falta";
        }
    }

    //FORMATA O NOME DA DISCIPLINA PARA SER MAIÚSCULA CADA INICIAL DA PALAVRA
    public static String formatarNome(String disciplina) {
        if (disciplina == null || disciplina.isEmpty()) {
            return "";
        }

        //SEPARAR O ACENTO DO CARACTER E RETIRAR O ACENTO DA STRING, ESSA CLASSE NORMALIZE
        disciplina = Normalizer.normalize(disciplina, Normalizer.Form.NFD);
        disciplina = disciplina.replaceAll("\\p{InCombiningDiacriticalMarks}", "");

        disciplina = disciplina.trim();
        String[] palavras = disciplina.split("\\s+");

        for (int i = 0; i < palavras.length; i++) {
            if (!palavras[i].isEmpty()) {
                palavras[i] = palavras[i].substring(0, 1).toUpperCase() + palavras[i].substring(1).toLowerCase();
            }
        }

        return String.join(" ", palavras);
    }

    //FORMATAÇÃO DE COMO VAI FICAR CADA OBJETO DISCIPLINA
    public String toString () {
        return formatarNome(nomeDisciplina) + ", " + nota1 + ", " + nota2
                + ", " + frequencia + "%, " + status;
    }
}