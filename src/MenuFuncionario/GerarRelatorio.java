package MenuFuncionario;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class GerarRelatorio extends JFrame{



    public static void exibirMenu() {
        JFrame frame = new JFrame("Gerar Relatório Geral");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        // Solicita a senha do funcionário
        String senhaFuncionario = JOptionPane.showInputDialog(frame, "Digite a senha do funcionário:");

        // Verifica se a senha está correta
        if ("func123".equals(senhaFuncionario)) { // Senha fixa para exemplo
            gerarRelatorio(frame);
        } else {
            JOptionPane.showMessageDialog(frame, "Senha incorreta. Voltando ao Menu Funcionário.");
            frame.dispose();
        }
    }

    private static void gerarRelatorio(JFrame parentFrame) {
        // Simulação de dados do relatório
        String[] colunas = {"Conta", "Nome do Cliente", "Saldo", "Data da Última Movimentação"};
        String[][] dados = {
                {"12345", "João Silva", "R$ 5.000,00", "2024-11-20"},
                {"67890", "Maria Oliveira", "R$ 2.300,00", "2024-11-19"},
                {"11223", "Carlos Souza", "R$ 7.800,00", "2024-11-18"}
        };

        // Exporta para arquivo Excel (CSV)
        try (FileWriter writer = new FileWriter("relatorio_geral.csv")) {
            // Escreve as colunas
            for (String coluna : colunas) {
                writer.append(coluna).append(";");
            }
            writer.append("\n");

            // Escreve os dados
            for (String[] linha : dados) {
                for (String dado : linha) {
                    writer.append(dado).append(";");
                }
                writer.append("\n");
            }

            writer.flush();
            JOptionPane.showMessageDialog(parentFrame, "Relatório exportado com sucesso para 'relatorio_geral.csv'!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parentFrame, "Erro ao exportar o relatório: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
