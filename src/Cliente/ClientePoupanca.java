package Cliente;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ClientePoupanca {
    private static double saldoPoupanca = 2000.00;

    public static void exibirMenu() {


        JFrame frame = new JFrame("Menu Conta Poupança");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnSaldo = new JButton("Ver Saldo");
        JButton btnDeposito = new JButton("Depósito");
        JButton btnSaque = new JButton("Saque");
        JButton btnVoltar = new JButton("Voltar");

        frame.add(btnSaldo);
        frame.add(btnDeposito);
        frame.add(btnSaque);
        frame.add(btnVoltar);

        btnSaldo.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Saldo da poupança: R$ " + String.format("%.2f", saldoPoupanca)));
        btnDeposito.addActionListener(e -> realizarDepositoPoupanca());
        btnSaque.addActionListener(e -> realizarSaquePoupanca());
        btnVoltar.addActionListener( e -> {
            CorrentePoupanca.abrirMenuCliente();
        });

        frame.setVisible(true);
    }

    private static void realizarDepositoPoupanca() {
        String valorInput = JOptionPane.showInputDialog("Digite o valor do depósito:");
        if (valorInput != null && !valorInput.isEmpty()) {
            try {
                double valor = Double.parseDouble(valorInput);
                if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "O valor deve ser maior que zero.");
                } else {
                    saldoPoupanca += valor;
                    salvarSaldoPoupanca();
                    JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido.");
            }
        }
    }

    private static void realizarSaquePoupanca() {
        String valorInput = JOptionPane.showInputDialog("Digite o valor do saque:");
        if (valorInput != null && !valorInput.isEmpty()) {
            try {
                double valor = Double.parseDouble(valorInput);
                if (valor > saldoPoupanca) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                } else if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "O valor deve ser maior que zero.");
                } else {
                    saldoPoupanca -= valor;
                    salvarSaldoPoupanca();
                    JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido.");
            }
        }
    }

    private static void salvarSaldoPoupanca() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("poupanca.bin"))) {
            oos.writeDouble(saldoPoupanca);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o saldo da poupança.");
        }
    }
}
