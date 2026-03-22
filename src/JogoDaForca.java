import java.util.ArrayList;
import java.util.HashSet;

public class JogoDaForca {
    private ArrayList<String[]> bancoPalavras = new ArrayList<>();
    private ArrayList<String> historico = new ArrayList<>();

    private String palavraSorteada;
    private String dica;
    private HashSet<Character> letrasAdivinhadas = new HashSet<>();

    private int acertos = 0;
    private int penalidades = 0;
    private boolean terminou = false;

    public JogoDaForca(){

    }

    public void iniciar(){

    }

    public String getDica(){
    }

    public String getPalavra(){
        String resultado = "";

        for (int i = 0; i < palavraSorteada.length(); i++){
            char letraPalavra = palavraSorteada.charAt(i);
            if (letrasAdvinhadas.contains(letraPalavra)){
                resultado += letraPalavra;
            } else {
                resultado += "*";
            }
        }
        return resultado;
    }

    public ArrayList<String> getPalavras(){
        return historico;
    }

    public ArrayList<Integer> getOcorrencias(String letra){

    }

    public boolean terminou(){
        if (penalidades == 6){
            return true;
        } else {
            if (acertos == palavraSorteada.length()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int getAcertos(){

    }

    public int getCodigoPenalidade(){

    }


    public String getNomePenalidade(){

    }

    public String getResultado(){
        if (!terminou){
            return "Em andamento";
        } else {
            if (penalidades == 6){
                return "Perdeu";
            } else {
                return "Venceu";
            }
        }
    }
}
