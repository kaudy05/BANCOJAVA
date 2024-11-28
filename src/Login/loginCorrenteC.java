package Login;

import Cliente.ClienteCorrente;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class loginCorrenteC extends JFrame {
    private static final Map<String, String> usuarios = new HashMap<>();
    private static final String ARQUIVO_USUARIOS = "usuarios.bin";

    public static void main(String[] args) {
        carregarUsuarios(); // Carrega os usuários salvos
        exibirTelaLogin();
    }

    public static void exibirTelaLogin() {
        JFrame frame = new JFrame("Tela de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // Define o painel com gradiente como fundo
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(new GridLayout(5, 5, 10, 10)); // Configuração do layout no painel

        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();
        JButton btnCriarConta = new JButton("Criar Conta");
        JButton btnEntrar = new JButton("Entrar");

        gradientPanel.add(lblCpf);
        gradientPanel.add(txtCpf);
        gradientPanel.add(lblSenha);
        gradientPanel.add(txtSenha);
        gradientPanel.add(new JLabel());
        gradientPanel.add(new JLabel());
        gradientPanel.add(btnCriarConta);
        gradientPanel.add(btnEntrar);

        frame.add(gradientPanel); // Adiciona o painel gradiente ao frame

        btnCriarConta.addActionListener(e -> {
            String cpf = txtCpf.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            if (cpf.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "CPF e senha são obrigatórios para criar conta.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (usuarios.containsKey(cpf)) {
                JOptionPane.showMessageDialog(frame, "Conta já existe para este CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                usuarios.put(cpf, senha);
                salvarUsuarios(); // Salva os dados no arquivo
                JOptionPane.showMessageDialog(frame, "Conta criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                txtCpf.setText("");
                txtSenha.setText("");
            }
        });

        btnEntrar.addActionListener(e -> {
            String cpf = txtCpf.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            if (usuarios.containsKey(cpf) && usuarios.get(cpf).equals(senha)) {
                JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose(); // Fecha a tela de login
                ClienteCorrente.exibirMenu(); // Abre o menu ClienteCorrente
            } else {
                JOptionPane.showMessageDialog(frame, "CPF ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private static void carregarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_USUARIOS))) {
            @SuppressWarnings("unchecked")
            Map<String, String> usuariosCarregados = (Map<String, String>) ois.readObject();
            usuarios.putAll(usuariosCarregados);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de usuários não encontrado. Um novo será criado.");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os usuários. Um novo arquivo será criado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void salvarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_USUARIOS))) {
            oos.writeObject(usuarios);
            System.out.println("Usuários salvos com sucesso.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os usuários.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void abrirTelaLogin() {
        SwingUtilities.invokeLater(loginCorrenteC::exibirTelaLogin);
    }

    // Classe interna para criar o fundo gradiente cinza
    static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            Color startColor = new Color(200, 200, 200); // Cinza claro
            Color endColor = new Color(100, 100, 100);   // Cinza escuro

            int width = getWidth();
            int height = getHeight();
            GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);

            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
        }
    }
}
