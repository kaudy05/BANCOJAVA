// Classe principal do Menu
package MenuPrincipal;

import Cliente.CorrentePoupanca;
import MenuFuncionario.menuFuncionario; // Certifique-se de que o menuFuncionario está corretamente importado
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Principal extends JFrame {

    public static class Caminhos {
        private final String logoPrincipal = "C:/Users/kauy0/IdeaProjects/BAnco/src/imagem/dv.png";

        public String getLogoPrincipal() {
            return this.logoPrincipal;
        }
    }

    public void iniciarMenuPrincipal() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Banco Malvader");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(false);

            Image icon = Toolkit.getDefaultToolkit().getImage("src/images/dv.png");
            frame.setIconImage(icon);

            JPanel mainPanel = new GradientPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

            Font malvaderFont = carregarFonte("src/fonts/SHAXIZOR.TTF");
            Font padraoFont = carregarFonte("src/fonts/Nunito-VariableFont_wght.ttf");

            ImageIcon imageIcon = new ImageIcon(new Caminhos().getLogoPrincipal());
            JLabel imageLabel = new JLabel(imageIcon);
            JLabel label = new JLabel("Bem-vindo ao Banco Malvader!");
            JLabel textMenu = new JLabel("Menu Principal");
            JLabel selecao = new JLabel("Selecione a opção desejada");

            label.setForeground(Color.WHITE);
            textMenu.setForeground(Color.WHITE);
            selecao.setForeground(Color.WHITE);

            estilizarTexto(label, padraoFont, 20f);
            estilizarTexto(textMenu, malvaderFont, 44f);
            estilizarTexto(selecao, padraoFont, 15f);

            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            textMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
            selecao.setAlignmentX(Component.CENTER_ALIGNMENT);
            selecao.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));

            mainPanel.add(imageLabel);
            mainPanel.add(label);
            mainPanel.add(textMenu);
            mainPanel.add(selecao);

            JPanel buttonPanel = new JPanel(new GridBagLayout());
            buttonPanel.setOpaque(false);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JButton buttonCliente = criarBotao("CLIENTE", padraoFont, Color.WHITE, new Color(163, 162, 162));
            JButton buttonFuncionario = criarBotao("FUNCIONARIO", padraoFont, Color.white, new Color(163, 162, 162));
            JButton buttonSair = criarBotao("SAIR DO PROGRAMA", padraoFont, Color.RED, new Color(184, 18, 21));

            buttonCliente.addActionListener(e -> {
                CorrentePoupanca correntePoupanca = new CorrentePoupanca();
                correntePoupanca.setVisible(true);  // Tornar a tela visível
                frame.dispose();
            });

            buttonFuncionario.addActionListener(e -> {
                menuFuncionario menuFuncionarioObj = new menuFuncionario();
                menuFuncionarioObj.exibirMenuPrincipal();
                frame.dispose();
            });

            buttonSair.addActionListener(e -> {
                int resposta = JOptionPane.showConfirmDialog(frame, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            });

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 5, 5, 5);
            buttonPanel.add(buttonCliente, gbc);

            gbc.gridy++;
            buttonPanel.add(buttonFuncionario, gbc);

            gbc.gridy++;
            buttonPanel.add(buttonSair, gbc);

            mainPanel.add(buttonPanel);
            frame.add(mainPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private Font carregarFonte(String caminho) {
        try {
            Font fonte = Font.createFont(Font.TRUETYPE_FONT, new File(caminho));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fonte);
            return fonte;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 14); // Fonte padrão caso falhe
        }
    }

    private void estilizarTexto(JLabel label, Font fonte, float tamanho) {
        if (fonte != null) {
            label.setFont(fonte.deriveFont(tamanho));
        } else {
            label.setFont(new Font("Arial", Font.BOLD, Math.round(tamanho)));
        }
    }

    private JButton criarBotao(String texto, Font fonte, Color corTexto, Color corBorda) {
        JButton botao = new JButton(texto);
        botao.setBackground(new Color(182, 182, 182));
        botao.setPreferredSize(new Dimension(400, 40));
        botao.setFont(fonte != null ? fonte.deriveFont(15f) : new Font("Arial", Font.PLAIN, 15));
        botao.setForeground(corTexto);
        botao.setBorder(new LineBorder(corBorda, 1, true));
        botao.setFocusPainted(false);

        estilizarBotaoHover(botao, corTexto, corBorda, new Color(230, 227, 227), corBorda);
        return botao;
    }

    private void estilizarBotaoHover(JButton botao, Color corTexto, Color corBorda, Color corFundoHover, Color corBordaHover) {
        botao.setOpaque(false);
        botao.setContentAreaFilled(false);

        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setOpaque(true);
                botao.setBackground(corFundoHover);
                botao.setForeground(corTexto);
                botao.setBorder(new LineBorder(corBordaHover, 1, true));
                botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setOpaque(false);
                botao.setForeground(corTexto);
                botao.setBorder(new LineBorder(corBorda, 1, true));
            }
        });
    }

    public static void main() {
        new Principal().iniciarMenuPrincipal();
    }

    static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            Color startColor = new Color(30, 30, 30);  // cor cinza clara
            Color endColor = new Color(60, 60, 60);    // cor cinza escuro

            int width = getWidth();
            int height = getHeight();
            GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);

            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
        }
    }
}
