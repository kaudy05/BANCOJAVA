package MenuFuncionario;

import javax.swing.*;

public class Encerramento extends JFrame{
    public static void exibirMenu() {
        JFrame frame = new JFrame("Encerramento de Conta");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        // Solicita a senha do administrador
        String senhaAdmin = JOptionPane.showInputDialog(frame, "Digite a senha de administrador:");

        // Verifica se a senha está correta
        if ("admin123".equals(senhaAdmin)) { // Senha fixa para exemplo
            encerrarConta(frame); // Chama o método para encerrar a conta
        } else {
            JOptionPane.showMessageDialog(frame, "Senha incorreta. Voltando ao Menu Funcionário.");
            frame.dispose(); // Fecha a janela e retorna ao menu principal
        }
    }

    private static void encerrarConta(JFrame parentFrame) {
        // Solicita o número da conta a ser encerrada
        String numeroConta = JOptionPane.showInputDialog(parentFrame, "Digite o número da conta para encerramento:");

        if (numeroConta == null || numeroConta.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Nenhum número de conta foi informado. Voltando ao Menu Funcionário.");
            return;
        }

        // Simula o encerramento da conta
        int confirmacao = JOptionPane.showConfirmDialog(
                parentFrame,
                "Tem certeza que deseja encerrar a conta " + numeroConta + "?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(parentFrame, "Conta " + numeroConta + " encerrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(parentFrame, "Operação de encerramento cancelada.");
        }
    }
}
