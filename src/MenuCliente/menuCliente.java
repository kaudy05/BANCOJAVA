package MenuCliente;

import MenuPrincipal.Principal;
import java.awt.*;
import javax.swing.*;
import Transacoes.transacoes;


public class menuCliente {
    private transacoes Transacoes;

    public menuCliente() {
        Transacoes = new transacoes();
        exibirMenuCliente();
    }

    private void exibirMenuCliente() {
        JFrame menuFrame = new JFrame("Menu Cliente");
        menuFrame.setSize(400, 400);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new GridLayout(6, 1));

        JButton btnSaldo = new JButton("1 - Saldo");
        JButton btnDeposito = new JButton("2 - Depósito");
        JButton btnSaque = new JButton("3 - Saque");
        JButton btnExtrato = new JButton("4 - Extrato");
        JButton btnConsultarLimite = new JButton("5 - Consultar Limite");
        JButton btnSair = new JButton("6 - Sair");

        menuFrame.add(btnSaldo);
        menuFrame.add(btnDeposito);
        menuFrame.add(btnSaque);
        menuFrame.add(btnExtrato);
        menuFrame.add(btnConsultarLimite);
        menuFrame.add(btnSair);

        // Ações dos botões
        btnSaldo.addActionListener(e -> consultarSaldo());
        btnDeposito.addActionListener(e -> realizarDeposito());
        btnSaque.addActionListener(e -> realizarSaque());
        btnExtrato.addActionListener(e -> exibirExtrato());
        btnConsultarLimite.addActionListener(e -> consultarLimite());
        btnSair.addActionListener(e ->{

        });

        menuFrame.setVisible(true);
    }

    private void consultarSaldo() {
        String cpf = solicitarCPF();
        String tipoConta = solicitarTipoConta();
        // Lógica para consultar saldo (simulada aqui)
        JOptionPane.showMessageDialog(null, "Saldo atual: R$1.500,00 (simulado para CPF: " + cpf + " na conta " + tipoConta + ")");
    }

    private void realizarDeposito() {
        String cpf = solicitarCPF();
        String tipoConta = solicitarTipoConta();
        double valor = solicitarValor("Depósito");
        transacoes.depositar(tipoConta, cpf, valor);
        JOptionPane.showMessageDialog(null, "Depósito de R$" + valor + " realizado com sucesso!");
    }

    private void realizarSaque() {
        String cpf = solicitarCPF();
        String tipoConta = solicitarTipoConta();
        double valor = solicitarValor("Saque");
        transacoes.sacar(tipoConta, cpf, valor);
        JOptionPane.showMessageDialog(null, "Saque de R$" + valor + " realizado com sucesso!");
    }

    private void exibirExtrato() {
        String cpf = solicitarCPF();
        String tipoConta = solicitarTipoConta();
        // Lógica para exibir extrato (simulada aqui)
        JOptionPane.showMessageDialog(null, "Extrato para CPF: " + cpf + " na conta " + tipoConta + " exibido (simulação).");
    }

    private void consultarLimite() {
        String cpf = solicitarCPF();
        String tipoConta = solicitarTipoConta();
        // Lógica para consultar limite (simulada aqui)
        JOptionPane.showMessageDialog(null, "Limite disponível: R$500,00 (simulado para CPF: " + cpf + " na conta " + tipoConta + ")");
    }

    private String solicitarCPF() {
        return JOptionPane.showInputDialog("Informe o CPF:");
    }

    private String solicitarTipoConta() {
        Object[] options = {"Corrente", "Poupança"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de conta:",
                "Tipo de Conta",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
        return escolha == 0 ? "corrente" : "poupanca";
    }

    private double solicitarValor(String operacao) {
        String valorStr = JOptionPane.showInputDialog("Informe o valor para " + operacao + ":");
        try {
            return Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Operação cancelada.");
            return 0;
        }
    }
}
