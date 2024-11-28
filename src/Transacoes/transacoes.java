package Transacoes;

import java.io.*;
import java.util.*;

public class transacoes {
    private static final String ARQUIVO_CORRENTE = "contas_correntes.csv";
    private static final String ARQUIVO_POUPANCA = "contas_poupancas.csv";
    private static final String ARQUIVO_EXTRATO = "extrato.csv";

    // Método principal para realizar uma transação
    public static void realizarTransacao(String tipoConta, String cpf, double valor, boolean isDeposito) {
        String caminhoArquivo = tipoConta.equalsIgnoreCase("corrente") ? ARQUIVO_CORRENTE : ARQUIVO_POUPANCA;

        try {
            // Carregar dados do arquivo
            List<String[]> linhas = new ArrayList<>();
            boolean usuarioEncontrado = false;
            double saldoAtual = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] valores = linha.split(",");
                    if (valores[1].equals(cpf)) { // Supondo que o CPF está na coluna 1
                        usuarioEncontrado = true;

                        // Saldo está na coluna 4 (ajuste conforme o seu CSV)
                        saldoAtual = Double.parseDouble(valores[4]);

                        if (isDeposito) {
                            saldoAtual += valor;
                        } else {
                            if (saldoAtual >= valor) {
                                saldoAtual -= valor;
                            } else {
                                System.out.println("Saldo insuficiente para realizar o saque.");
                                return;
                            }
                        }

                        valores[4] = String.valueOf(saldoAtual); // Atualiza o saldo
                    }
                    linhas.add(valores);
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("Usuário não encontrado.");
                return;
            }

            // Regravar os dados atualizados no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
                for (String[] linha : linhas) {
                    writer.write(String.join(",", linha));
                    writer.newLine();
                }
            }

            // Registrar a transação no extrato
            registrarExtrato(tipoConta, cpf, valor, isDeposito, saldoAtual);

            System.out.println("Transação realizada com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao acessar o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar os valores numéricos: " + e.getMessage());
        }
    }

    // Método para registrar o extrato
    private static void registrarExtrato(String tipoConta, String cpf, double valor, boolean isDeposito, double saldoFinal) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_EXTRATO, true))) {
            String tipoOperacao = isDeposito ? "Depósito" : "Saque";
            String linhaExtrato = String.format("%s,%s,%s,%.2f,%.2f,%s",
                    tipoConta, cpf, tipoOperacao, valor, saldoFinal, new Date());
            writer.write(linhaExtrato);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao registrar o extrato: " + e.getMessage());
        }
    }

    // Método para saque
    public static void sacar(String tipoConta, String cpf, double valor) {
        realizarTransacao(tipoConta, cpf, valor, false);
    }

    // Método para depósito
    public static void depositar(String tipoConta, String cpf, double valor) {
        realizarTransacao(tipoConta, cpf, valor, true);
    }
}
