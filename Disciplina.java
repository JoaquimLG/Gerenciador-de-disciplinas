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

    public String getNomeDisciplina(){
        return formatarNome(nomeDisciplina);
    }
    public double getNota1(){
        return nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public double getFrequencia(){
        return frequencia;
    }
    public String getStatus(){
        return status;
    }
    public String situacao(double nota1, double nota2, double frequencia){
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
    public static String formatarNome(String disciplina) {
        if (disciplina == null || disciplina.isEmpty()) {
            return "";
        }

        disciplina = disciplina.trim();
        String[] palavras = disciplina.split("\\s+");

        for (int i = 0; i < palavras.length; i++) {
            if (!palavras[i].isEmpty()) {
                palavras[i] = palavras[i].substring(0, 1).toUpperCase() + palavras[i].substring(1).toLowerCase();
            }
        }

        return String.join(" ", palavras);
    }
}

