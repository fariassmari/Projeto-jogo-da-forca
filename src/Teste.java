import javax.swing.*;
import java.awt.Component;
import java.util.ArrayList;

public class Teste {
    private String letraDigitada;
    private ArrayList<Integer> ocorrencias;
    private JogoDaForca jogo = new JogoDaForca();

    public Teste() {
        JOptionPane.showMessageDialog(null,
                "Bem-vindo ao Jogo da Forca!\nTente adivinhar a palavra.");

        jogo.iniciar();

        do {
            letraDigitada = JOptionPane.showInputDialog(null,
                    "Dica: " + jogo.getDica() +
                            "\nPalavra: " + jogo.getPalavra() +
                            "\nDigite uma letra:");

            try {
                if (letraDigitada == null || letraDigitada.isEmpty()) {
                    throw new Exception("Digite uma letra válida!");
                }

                ocorrencias = jogo.getOcorrencias(letraDigitada);

                if (ocorrencias.size() > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Você acertou a letra: " + letraDigitada +
                                    "\n\nPalavra: " + jogo.getPalavra() +
                                    "\nAcertos: " + jogo.getAcertos() +
                                    "\nPenalidade: " + jogo.getCodigoPenalidade() +
                                    " - " + jogo.getNomePenalidade());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Você errou a letra: " + letraDigitada +
                                    "\n\nPalavra: " + jogo.getPalavra() +
                                    "\nAcertos: " + jogo.getAcertos() +
                                    "\nPenalidade: " + jogo.getCodigoPenalidade() +
                                    " - " + jogo.getNomePenalidade());
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } while (!jogo.terminou());

        JOptionPane.showMessageDialog(null,
                "Resultado final: " + jogo.getResultado());
    }

    public static void main(String[] args) {
        new Teste();
    }
}