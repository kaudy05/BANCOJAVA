package Funcionario;

import javax.swing.*;
import java.awt.*;

import java.io.Serializable;

public class FuncionarioCorrente {
    public static void exibirFormulario() {
        JFrame frame = new JFrame("Abertura de Conta Corrente");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setLayout(new GridLayout(17, 2, 10, 10));

        // Campos de entrada
        JTextField txtAgencia = new JTextField();
        JTextField txtNumeroConta = new JTextField();
        JTextField txtLimiteConta = new JTextField();
        JTextField txtDataVencimento = new JTextField();
        JTextField txtNomeCliente = new JTextField();
        JTextField txtCpfCliente = new JTextField();
        JTextField txtDataNascimento = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtEndereco = new JTextField();
        JTextField txtCep = new JTextField();
        JTextField txtLocal = new JTextField();
        JTextField txtNumeroCasa = new JTextField();
        JTextField txtBairro = new JTextField();
        JTextField txtCidade = new JTextField();
        JTextField txtEstado = new JTextField();
        JPasswordField txtSenha = new JPasswordField();

        // Adiciona os campos no formulário
        frame.add(new JLabel("1 - Agência:"));
        frame.add(txtAgencia);
        frame.add(new JLabel("2 - Número da Conta:"));
        frame.add(txtNumeroConta);
        frame.add(new JLabel("3 - Limite da Conta:"));
        frame.add(txtLimiteConta);
        frame.add(new JLabel("4 - Data de Vencimento:"));
        frame.add(txtDataVencimento);
        frame.add(new JLabel("5 - Nome do Cliente:"));
        frame.add(txtNomeCliente);
        frame.add(new JLabel("6 - CPF do Cliente:"));
        frame.add(txtCpfCliente);
        frame.add(new JLabel("7 - Data de Nascimento:"));
        frame.add(txtDataNascimento);
        frame.add(new JLabel("8 - Telefone de Contato:"));
        frame.add(txtTelefone);
        frame.add(new JLabel("9 - Endereço do Cliente:"));
        frame.add(txtEndereco);
        frame.add(new JLabel("10 - CEP:"));
        frame.add(txtCep);
        frame.add(new JLabel("11 - Local:"));
        frame.add(txtLocal);
        frame.add(new JLabel("12 - Número da Casa:"));
        frame.add(txtNumeroCasa);
        frame.add(new JLabel("13 - Bairro:"));
        frame.add(txtBairro);
        frame.add(new JLabel("14 - Cidade:"));
        frame.add(txtCidade);
        frame.add(new JLabel("15 - Estado:"));
        frame.add(txtEstado);
        frame.add(new JLabel("16 - Senha do Cliente:"));
        frame.add(txtSenha);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");

        frame.add(btnSalvar);
        frame.add(btnVoltar);

        // Ação do botão "Salvar"
        btnSalvar.addActionListener(e -> {
            String contaInfo = String.format("""
                            Conta Corrente Criada com Sucesso:
                            Agência: %s
                            Número da Conta: %s
                            Limite da Conta: %s
                            Data de Vencimento: %s
                            Nome do Cliente: %s
                            CPF: %s
                            Data de Nascimento: %s
                            Telefone: %s
                            Endereço: %s
                            CEP: %s
                            Local: %s
                            Número da Casa: %s
                            Bairro: %s
                            Cidade: %s
                            Estado: %s""",
                    txtAgencia.getText(), txtNumeroConta.getText(), txtLimiteConta.getText(),
                    txtDataVencimento.getText(), txtNomeCliente.getText(), txtCpfCliente.getText(),
                    txtDataNascimento.getText(), txtTelefone.getText(), txtEndereco.getText(),
                    txtCep.getText(), txtLocal.getText(), txtNumeroCasa.getText(),
                    txtBairro.getText(), txtCidade.getText(), txtEstado.getText()
            );

            JOptionPane.showMessageDialog(frame, contaInfo, "Conta Criada", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        });

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
