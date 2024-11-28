package Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Extrato {
    private static final List<String> historico = new ArrayList<>();

    public static void adicionarTransacao(String transacao) {
        historico.add(transacao);
        salvarExtrato();
    }

    public static void mostrarExtrato() {
        if (historico.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma transação registrada no extrato.");
        } else {
            StringBuilder extrato = new StringBuilder("Extrato de Transações:\n");
            for (String transacao : historico) {
                extrato.append(transacao).append("\n");
            }
            JOptionPane.showMessageDialog(null, extrato.toString());
        }
    }

    public static void salvarExtrato() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("extrato.bin"))) {
            oos.writeObject(historico);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o extrato: " + e.getMessage());
        }
    }

    public static void carregarExtrato() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("extrato.bin"))) {
            List<String> carregado = (List<String>) ois.readObject();
            historico.clear();
            historico.addAll(carregado);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Arquivo de extrato não encontrado, iniciando vazio.");
        }
    }
}
