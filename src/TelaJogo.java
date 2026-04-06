import javax.swing.*;
import java.awt.*;

public class TelaJogo {
    private JFrame frame;
    private JogoDaForca jogo = new JogoDaForca();

    private JButton btn1Iniciar;
    private JLabel lbl2Palavra;
    private JLabel lbl3Dica;
    private JTextField txt4Letra;
    private JButton btn5Advinhar;
    private JLabel lbl6Resultado;
    private JLabel lbl7Acertos;
    private JLabel lbl8Penalidade;
    private JLabel lbl9Imagem;
    private JTextArea txt10Historico;

    public TelaJogo() {
        frame = new JFrame("Jogo da Forca");
        frame.setSize(400, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        btn1Iniciar = new JButton("Iniciar");
        btn1Iniciar.setBounds(20, 20, 100, 30);
        frame.add(btn1Iniciar);
        btn1Iniciar.addActionListener(e -> {
            jogo.iniciar();
            btn5Advinhar.setEnabled(true);
            atualizarTela();
        });

        lbl2Palavra = new JLabel("Palavra: ");
        lbl2Palavra.setBounds(20, 60, 300, 30);
        frame.add(lbl2Palavra);

        lbl3Dica = new JLabel("Dica: ");
        lbl3Dica.setBounds(20, 90, 300, 30);
        frame.add(lbl3Dica);

        txt4Letra = new JTextField();
        txt4Letra.setBounds(20, 130, 50, 30);
        frame.add(txt4Letra);

        btn5Advinhar = new JButton("Advinhar");
        btn5Advinhar.setBounds(80, 130, 120, 30);
        btn5Advinhar.setEnabled(false);
        frame.add(btn5Advinhar);
        btn5Advinhar.addActionListener(e -> {
            try {
                if (txt4Letra.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Digite uma letra!");
                    return;
                }
                jogo.getOcorrencias(txt4Letra.getText());
                atualizarTela();
                txt4Letra.setText("");
            } catch (Exception error) {
                JOptionPane.showMessageDialog(frame, error.getMessage());
            }
        });

        lbl6Resultado = new JLabel("Resultado: ");
        lbl6Resultado.setBounds(20, 180, 300, 30);
        frame.add(lbl6Resultado);

        lbl7Acertos = new JLabel("Acertos: 0");
        lbl7Acertos.setForeground(new Color(0,200,0));
        lbl7Acertos.setBounds(20, 210, 300, 30);
        frame.add(lbl7Acertos);

        lbl8Penalidade = new JLabel("Penalidade: 0 - sem penalidades");
        lbl8Penalidade.setForeground(new Color(255,0,0));
        lbl8Penalidade.setBounds(20, 240, 350, 30);
        frame.add(lbl8Penalidade);

        lbl9Imagem = new JLabel();
        lbl9Imagem.setBounds(200, 20, 150, 150);
        frame.add(lbl9Imagem);

        txt10Historico = new JTextArea();
        txt10Historico.setBounds(20, 280, 340, 180);
        txt10Historico.setEditable(false);
        txt10Historico.setVisible(false);
        frame.add(txt10Historico);

        frame.setVisible(true);
    }

    private void atualizarTela(){
        lbl2Palavra.setText("Palavra: " + jogo.getPalavra());
        lbl3Dica.setText("Dica: " + jogo.getDica());
        if (jogo.terminou()) {
            lbl6Resultado.setText("Resultado: " + jogo.getResultado());
        } else {
            lbl6Resultado.setText("Resultado: em andamento");
        }
        lbl7Acertos.setText("Acertos: " + jogo.getAcertos());
        lbl8Penalidade.setText("Penalidade: " + jogo.getCodigoPenalidade() + " - " + jogo.getNomePenalidade());

        if (jogo.terminou()) {
            txt10Historico.setVisible(true);
        }

        txt10Historico.setText("");
        for (String h : jogo.getResultados()){
            txt10Historico.append(h + "\n");
        }

        int codigoImagem = jogo.getCodigoPenalidade();

        ImageIcon imagem = new ImageIcon(
                getClass().getResource("/imagens/" + codigoImagem + ".png")
        );
        lbl9Imagem.setIcon(imagem);

        if (jogo.terminou()){
            btn5Advinhar.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new TelaJogo();
    }
}
