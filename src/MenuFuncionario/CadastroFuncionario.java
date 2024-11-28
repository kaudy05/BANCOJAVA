package MenuFuncionario;

import javax.swing.*;
import java.awt.*;

public class CadastroFuncionario extends JFrame {
    private static Label txtNumero;

    public static void exibirMenu() {
        JFrame frame = new JFrame("Cadastro de Novo Funcionário");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        String senhaAdmin = JOptionPane.showInputDialog(frame, "Digite a senha de administrador:");

        // Verifica se a senha está correta
        if ("admin123".equals(senhaAdmin)) { // Senha fixa para exemplo
            exibirFormularioCadastro(frame);
        } else {
            JOptionPane.showMessageDialog(frame, "Senha incorreta. Voltando ao Menu Funcionário.");
            frame.dispose();
        }
    }

    private static void exibirFormularioCadastro(JFrame parentFrame) {
        parentFrame.dispose(); // Fecha a janela anterior

        JFrame frame = new JFrame("Cadastrar Novo Funcionário");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setLayout(new GridLayout(17, 2, 10, 10));

        // Campos para entrada de dados
        JTextField txtCodigoFuncionario = new JTextField();
        JTextField txtCargo = new JTextField();
        JTextField txtNomeFuncionario = new JTextField();
        JTextField txtCpfFuncionario = new JTextField();
        JTextField txtDataNascimento = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtEndereco = new JTextField();
        JTextField txtCep = new JTextField();
        JTextField txtLocal = new JTextField();
        JTextField txtNumeroCasa = new JTextField();
        JTextField txtBairro = new JTextField();
        JTextField txtCidade = new JTextField();
        JTextField txtEstado = new JTextField();
        JPasswordField txtSenhaFuncionario = new JPasswordField();

        // Adiciona os campos ao formulário
        frame.add(new JLabel("1 - Código Funcionário:"));
        frame.add(txtCodigoFuncionario);
        frame.add(new JLabel("2 - Cargo:"));
        frame.add(txtCargo);
        frame.add(new JLabel("3 - Nome do Funcionário:"));
        frame.add(txtNomeFuncionario);
        frame.add(new JLabel("4 - CPF do Funcionário:"));
        frame.add(txtCpfFuncionario);
        frame.add(new JLabel("5 - Data de Nascimento:"));
        frame.add(txtDataNascimento);
        frame.add(new JLabel("6 - Telefone de Contato:"));
        frame.add(txtTelefone);
        frame.add(new JLabel("7 - Endereço do Funcionário:"));
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
        frame.add(new JLabel("14 - Senha do Funcionário:"));
        frame.add(txtSenhaFuncionario);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");

        frame.add(btnSalvar);
        frame.add(btnVoltar);

        // Ação do botão "Salvar"
        btnSalvar.addActionListener(e -> {
            String dadosFuncionario = String.format("""
                            Funcionário Cadastrado com Sucesso:
                            Código: %s
                            Cargo: %s
                            Nome: %s
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
                    txtCodigoFuncionario.getText(), txtCargo.getText(), txtNomeFuncionario.getText(),
                    txtCpfFuncionario.getText(), txtDataNascimento.getText(), txtTelefone.getText(),
                    txtEndereco.getText(), txtCep.getText(), txtLocal.getText(), txtNumero.getText(), txtNumeroCasa.getText(), txtBairro.getText(),
                    txtCidade.getText(), txtEstado.getText()
            );

            JOptionPane.showMessageDialog(frame, dadosFuncionario, "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose(); // Fecha o formulário após salvar
        });

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
