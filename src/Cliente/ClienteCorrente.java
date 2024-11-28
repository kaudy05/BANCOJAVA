package Cliente;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ClienteCorrente {
    private static double saldoCorrente = carregarSaldoCorrente();

    public static void exibirMenu() {
        JFrame frame = new JFrame("Menu Conta Corrente");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnSaldo = new JButton("Ver Saldo");
        JButton btnDeposito = new JButton("Depósito");
        JButton btnSaque = new JButton("Saque");
        JButton btnExtrato = new JButton("Extrato");
        JButton btnVoltar = new JButton("Voltar");

        frame.add(btnSaldo);
        frame.add(btnDeposito);
        frame.add(btnSaque);
        frame.add(btnExtrato);
        frame.add(btnVoltar);

        btnSaldo.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Saldo atual: R$ " + String.format("%.2f", saldoCorrente)));
        btnDeposito.addActionListener(e -> realizarDepositoCorrente());
        btnSaque.addActionListener(e -> realizarSaqueCorrente());
        btnExtrato.addActionListener(e -> Extrato.mostrarExtrato());
        btnVoltar.addActionListener( e -> {
            CorrentePoupanca.abrirMenuCliente();

        });

        frame.setVisible(true);
    }

    private static void realizarDepositoCorrente() {
        String valorInput = JOptionPane.showInputDialog("Digite o valor do depósito:");
        if (valorInput != null && !valorInput.isEmpty()) {
            try {
                double valor = Double.parseDouble(valorInput);
                if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "O valor deve ser maior que zero.");
                } else {
                    saldoCorrente += valor;
                    salvarSaldoCorrente();
                    Extrato.adicionarTransacao("Depósito de R$ " + String.format("%.2f", valor));
                    JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido.");
            }
        }
    }

    private static void realizarSaqueCorrente() {
        String valorInput = JOptionPane.showInputDialog("Digite o valor do saque:");
        if (valorInput != null && !valorInput.isEmpty()) {
            try {
                double valor = Double.parseDouble(valorInput);
                if (valor > saldoCorrente) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                } else if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "O valor deve ser maior que zero.");
                } else {
                    saldoCorrente -= valor;
                    salvarSaldoCorrente();
                    Extrato.adicionarTransacao("Saque de R$ " + String.format("%.2f", valor));
                    JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido.");
            }
        }
    }

    private static void salvarSaldoCorrente() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contaCorrente.bin"))) {
            oos.writeDouble(saldoCorrente);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o saldo da conta corrente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static double carregarSaldoCorrente() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contaCorrente.bin"))) {
            return ois.readDouble();
        } catch (IOException e) {
            // Retorna saldo inicial padrão caso o arquivo não exista ou ocorra erro.
            return 1000.00;
        }
    }
    static class GradientPanel extends JPanel {
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
