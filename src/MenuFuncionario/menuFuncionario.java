package MenuFuncionario;

import MenuPrincipal.Principal;
import Funcionario.correntepoupanca;
import javax.swing.*;
import java.awt.*;

public class menuFuncionario extends JFrame {
    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    public static void exibirMenuPrincipal() {
        JFrame frame = new JFrame("Menu Funcionário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(7, 1, 10, 10));

        // Botões do menu principal
        JButton btnAberturaConta = new JButton("1 - Abertura de Conta");
        JButton btnEncerramentoConta = new JButton("2 - Encerramento de Conta");
        JButton btnConsultarDados = new JButton("3 - Consultar Dados");
        JButton btnAlterarDados = new JButton("4 - Alterar Dados");
        JButton btnCadastroFuncionarios = new JButton("5 - Cadastro de Funcionários");
        JButton btnGerarRelatorios = new JButton("6 - Gerar Relatórios");
        JButton btnSair = new JButton("7 - Sair");

        // Adiciona os botões ao frame
        frame.add(btnAberturaConta);
        frame.add(btnEncerramentoConta);
        frame.add(btnConsultarDados);
        frame.add(btnAlterarDados);
        frame.add(btnCadastroFuncionarios);
        frame.add(btnGerarRelatorios);
        frame.add(btnSair);

        // Ação para "Abertura de Conta"
        btnAberturaConta.addActionListener(e -> {
            correntepoupanca correntePoupanca = new correntepoupanca();
            correntePoupanca.setVisible(true);  // Exibe a janela de CorrentePoupanca
            frame.dispose();  // Fecha o menu principal
        });

        // Ação para "Encerramento de Conta"
        btnEncerramentoConta.addActionListener(e -> {
            Encerramento.exibirMenu();
            frame.dispose();  // Fecha o menu principal
        });

        // Ação para "Consultar Dados"
        btnConsultarDados.addActionListener(e -> {
            ConsultarDados.exibirMenu();

            frame.dispose();
        });

        // Ação para "Alterar Dados"
        btnAlterarDados.addActionListener(e -> {
            AlterarDados.exibirMenu();

            frame.dispose();
        });

        // Ação para "Cadastro de Funcionários"
        btnCadastroFuncionarios.addActionListener(e -> {
            CadastroFuncionario.exibirMenu();
           ;
            frame.dispose();

        });

        // Ação para "Gerar Relatórios"
        btnGerarRelatorios.addActionListener(e -> {
            GerarRelatorio.exibirMenu();
            frame.dispose();
        });

        // Ação para "Sair"
        btnSair.addActionListener(e -> {
            Principal.main();

            frame.dispose();
        });

        frame.setVisible(true);
    }
}
