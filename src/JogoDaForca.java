import javax.swing.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

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
        InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.csv");
        if (stream == null) {
            JOptionPane.showMessageDialog(null, "Arquivo de palavras inexistente!");
            System.exit(0);
        }
        Scanner arquivo = new Scanner(stream);
        String linha;
        while (arquivo.hasNext()) {
            linha = arquivo.nextLine();

            String[] palavraDica = linha.split(",");

            if(!linha.isEmpty()){
                bancoPalavras.add(palavraDica);
            }
        }
        arquivo.close();
    }

    public void iniciar(){
        Random random = new Random();
        String[] sorteio = bancoPalavras.get(random.nextInt(bancoPalavras.size()));
        this.palavraSorteada = sorteio[0];
        this.dica = sorteio [1];
    }

    public String getDica(){
        return this.dica;
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
