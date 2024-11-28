package MenuFuncionario;

import javax.swing.*;
import java.awt.*;

public class AlterarDados extends JFrame {
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

        btnAlterarConta.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Alterar Conta em desenvolvimento."));
        btnAlterarFuncionario.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Alterar Funcionário em desenvolvimento."));
        btnAlterarCliente.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Alterar Cliente em desenvolvimento."));
        btnVoltar.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
