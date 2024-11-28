package Funcionario;

import javax.swing.*;
import java.awt.*;

public class FuncionarioPoupanca {
    public static void exibirFormulario() {
        JFrame frame = new JFrame("Abertura de Conta Poupança");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new GridLayout(15, 2, 10, 10));

        // Campos de entrada
        JTextField txtAgencia = new JTextField();
        JTextField txtNumeroConta = new JTextField();
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
        frame.add(new JLabel("3 - Nome do Cliente:"));
        frame.add(txtNomeCliente);
        frame.add(new JLabel("4 - CPF do Cliente:"));
        frame.add(txtCpfCliente);
        frame.add(new JLabel("5 - Data de Nascimento:"));
        frame.add(txtDataNascimento);
        frame.add(new JLabel("6 - Telefone de Contato:"));
        frame.add(txtTelefone);
        frame.add(new JLabel("7 - Endereço do Cliente:"));
        frame.add(txtEndereco);
        frame.add(new JLabel("8 - CEP:"));
        frame.add(txtCep);
        frame.add(new JLabel("9 - Local:"));
        frame.add(txtLocal);
        frame.add(new JLabel("10 - Número da Casa:"));
        frame.add(txtNumeroCasa);
        frame.add(new JLabel("11 - Bairro:"));
        frame.add(txtBairro);
        frame.add(new JLabel("12 - Cidade:"));
        frame.add(txtCidade);
        frame.add(new JLabel("13 - Estado:"));
        frame.add(txtEstado);
        frame.add(new JLabel("14 - Senha do Cliente:"));
        frame.add(txtSenha);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");

        frame.add(btnSalvar);
        frame.add(btnVoltar);

        // Ação do botão "Salvar"
        btnSalvar.addActionListener(e -> {
            String contaInfo = String.format("""
                            Conta Poupança Criada com Sucesso:
                            Agência: %s
                            Número da Conta: %s
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
                    txtAgencia.getText(), txtNumeroConta.getText(), txtNomeCliente.getText(),
                    txtCpfCliente.getText(), txtDataNascimento.getText(), txtTelefone.getText(),
                    txtEndereco.getText(), txtCep.getText(), txtLocal.getText(),
                    txtNumeroCasa.getText(), txtBairro.getText(), txtCidade.getText(),
                    txtEstado.getText()
            );

            JOptionPane.showMessageDialog(frame, contaInfo, "Conta Criada", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        });

        btnVoltar.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
