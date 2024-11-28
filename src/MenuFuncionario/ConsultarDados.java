package MenuFuncionario;

import javax.swing.*;
import java.awt.*;

public class ConsultarDados extends JFrame {
    public static void exibirMenu() {
        JFrame frame = new JFrame("Alterar Dados");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnAlterarConta = new JButton("1 - Alterar Conta");
        JButton btnAlterarFuncionario = new JButton("2 - Alterar Funcionário");
        JButton btnAlterarCliente = new JButton("3 - Alterar Cliente");
        JButton btnVoltar = new JButton("4 - Voltar");

        frame.add(btnAlterarConta);
        frame.add(btnAlterarFuncionario);
        frame.add(btnAlterarCliente);
        frame.add(btnVoltar);

        btnAlterarConta.addActionListener(e -> alterarConta());
        btnAlterarFuncionario.addActionListener(e -> alterarFuncionario());
        btnAlterarCliente.addActionListener(e -> alterarCliente());
        btnVoltar.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    private static void alterarConta() {
        String senhaGerente = JOptionPane.showInputDialog("Digite a senha do Gerente:");
        if (!"gerente123".equals(senhaGerente)) {
            JOptionPane.showMessageDialog(null, "Senha incorreta. Voltando ao menu.");
            return;
        }

        JFrame frame = new JFrame("Alterar Conta");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JTextField txtTipoConta = new JTextField();
        JTextField txtLimiteDisponivel = new JTextField();
        JTextField txtDataVencimento = new JTextField();

        frame.add(new JLabel("Tipo de Conta:"));
        frame.add(txtTipoConta);
        frame.add(new JLabel("Limite Disponível:"));
        frame.add(txtLimiteDisponivel);
        frame.add(new JLabel("Data de Vencimento:"));
        frame.add(txtDataVencimento);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        frame.add(btnSalvar);
        frame.add(btnCancelar);

        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Conta alterada com sucesso:\n" +
                    "Tipo de Conta: " + txtTipoConta.getText() + "\n" +
                    "Limite Disponível: " + txtLimiteDisponivel.getText() + "\n" +
                    "Data de Vencimento: " + txtDataVencimento.getText());
            frame.dispose();
        });

        btnCancelar.addActionListener(e -> frame.dispose());
        frame.setVisible(true);
    }

    private static void alterarFuncionario() {
        String senhaAdmin = JOptionPane.showInputDialog("Digite a senha do Administrador:");
        if (!"admin123".equals(senhaAdmin)) {
            JOptionPane.showMessageDialog(null, "Senha incorreta. Voltando ao menu.");
            return;
        }

        JFrame frame = new JFrame("Alterar Funcionário");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(8, 2, 10, 10));

        JTextField txtCodigoFuncionario = new JTextField();
        JTextField txtCargo = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtEndereco = new JTextField();
        JTextField txtCep = new JTextField();
        JTextField txtBairro = new JTextField();
        JTextField txtCidade = new JTextField();
        JTextField txtEstado = new JTextField();

        frame.add(new JLabel("Código do Funcionário:"));
        frame.add(txtCodigoFuncionario);
        frame.add(new JLabel("Cargo:"));
        frame.add(txtCargo);
        frame.add(new JLabel("Telefone:"));
        frame.add(txtTelefone);
        frame.add(new JLabel("Endereço:"));
        frame.add(txtEndereco);
        frame.add(new JLabel("CEP:"));
        frame.add(txtCep);
        frame.add(new JLabel("Bairro:"));
        frame.add(txtBairro);
        frame.add(new JLabel("Cidade:"));
        frame.add(txtCidade);
        frame.add(new JLabel("Estado:"));
        frame.add(txtEstado);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        frame.add(btnSalvar);
        frame.add(btnCancelar);

        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Funcionário alterado com sucesso:\n" +
                    "Código: " + txtCodigoFuncionario.getText() + "\n" +
                    "Cargo: " + txtCargo.getText() + "\n" +
                    "Telefone: " + txtTelefone.getText() + "\n" +
                    "Endereço: " + txtEndereco.getText() + "\n" +
                    "CEP: " + txtCep.getText() + "\n" +
                    "Bairro: " + txtBairro.getText() + "\n" +
                    "Cidade: " + txtCidade.getText() + "\n" +
                    "Estado: " + txtEstado.getText());
            frame.dispose();
        });

        btnCancelar.addActionListener(e -> frame.dispose());
        frame.setVisible(true);
    }

    private static void alterarCliente() {
        String senhaGerente = JOptionPane.showInputDialog("Digite a senha do Gerente:");
        if (!"gerente123".equals(senhaGerente)) {
            JOptionPane.showMessageDialog(null, "Senha incorreta. Voltando ao menu.");
            return;
        }

        JFrame frame = new JFrame("Alterar Cliente");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        JTextField txtTelefone = new JTextField();
        JTextField txtEndereco = new JTextField();
        JTextField txtCep = new JTextField();
        JTextField txtBairro = new JTextField();
        JTextField txtCidade = new JTextField();
        JTextField txtEstado = new JTextField();

        frame.add(new JLabel("Telefone:"));
        frame.add(txtTelefone);
        frame.add(new JLabel("Endereço:"));
        frame.add(txtEndereco);
        frame.add(new JLabel("CEP:"));
        frame.add(txtCep);
        frame.add(new JLabel("Bairro:"));
        frame.add(txtBairro);
        frame.add(new JLabel("Cidade:"));
        frame.add(txtCidade);
        frame.add(new JLabel("Estado:"));
        frame.add(txtEstado);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        frame.add(btnSalvar);
        frame.add(btnCancelar);

        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Cliente alterado com sucesso:\n" +
                    "Telefone: " + txtTelefone.getText() + "\n" +
                    "Endereço: " + txtEndereco.getText() + "\n" +
                    "CEP: " + txtCep.getText() + "\n" +
                    "Bairro: " + txtBairro.getText() + "\n" +
                    "Cidade: " + txtCidade.getText() + "\n" +
                    "Estado: " + txtEstado.getText());
            frame.dispose();
        });

        btnCancelar.addActionListener(e -> frame.dispose());
        frame.setVisible(true);
    }
}
