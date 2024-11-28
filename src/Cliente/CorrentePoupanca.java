package Cliente;

import Login.LoginPoupancaC;
import Login.loginCorrenteC;
import MenuPrincipal.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CorrentePoupanca extends JFrame {

    public CorrentePoupanca() {
        setTitle("Menu de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(new BorderLayout(10, 10));
        gradientPanel.add(criarPainelMenu(), BorderLayout.CENTER);

        add(gradientPanel, BorderLayout.CENTER);
    }

    private JPanel criarPainelMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setOpaque(false);

        JButton btnContaCorrente = criarBotao("Conta Corrente", e -> {
            loginCorrenteC.exibirTelaLogin();
            dispose();
        });

        JButton btnContaPoupanca = criarBotao("Conta Poupança", e -> {
            LoginPoupancaC.exibirTelaLogin();
            dispose();
        });

        JButton btnVoltar = criarBotao("Voltar", e -> {
            Principal.main();
            dispose();
        });

        panel.add(btnContaCorrente);
        panel.add(btnContaPoupanca);
        panel.add(btnVoltar);

        return panel;
    }

    private JButton criarBotao(String texto, ActionListener acao) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(200, 50));

        botao.addActionListener(acao);

        final Color corOriginal = botao.getBackground();

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(197, 197, 197, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(48, 47, 47, 255));
            }
        });

        return botao;
    }

    public static void abrirMenuCliente() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new CorrentePoupanca();
            frame.setVisible(true);
        });
    }


    public static void main(String[] args) {
        abrirMenuCliente();
    }

    public static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            Color startColor = new Color(30, 30, 30);
            Color endColor = new Color(0, 0, 0);

            int width = getWidth();
            int height = getHeight();
            GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);

            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
        }
    }
}
