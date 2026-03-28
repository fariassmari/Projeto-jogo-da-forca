import javax.swing.*;

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
        frame.add(btn5Advinhar);
        btn5Advinhar.addActionListener(e -> {
            try {
                jogo.getOcorrencias(txt4Letra.getText());
                atualizarTela();
                txt4Letra.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        });
        frame.setVisible(true);

    }

    private void atualizarTela(){
        lbl2Palavra.setText("Palavra: " + jogo.getPalavra());
        lbl3Dica.setText("Dica: " + jogo.getDica());
        lbl6Resultado.setText("Resultado: " + jogo.getResultado());
        lbl7Acertos.setText("Acertos: " + jogo.getAcertos());
        lbl8Penalidade.setText("Penalidade: " + jogo.getCodigoPenalidade() + " - " + jogo.getNomePenalidade());
        txt10Historico.setText("");
        for (String h : jogo.getResultados()){
            txt10Historico.append(h + "\n");
        }
    }
}
