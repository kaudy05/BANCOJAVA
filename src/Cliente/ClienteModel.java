package Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ClienteModel {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String agencia;
    private String conta;
    private Double saldo;
    private String dddTelefone;
    private String numerotelefone;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private String cepEndereco;
    private String senha;


    public ClienteModel() {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
        this.numerotelefone = numerotelefone;
        this.dddTelefone = dddTelefone;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.complementoEndereco = complementoEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.estadoEndereco = estadoEndereco;
        this.cepEndereco = cepEndereco;
        this.senha = senha;
    }

    private LocalDate parseDataNascimento(String dataNascimento) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataNascimento, formatter);
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public Double getSaldo(){
        return saldo;
    }
    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }
    public String getDddTelefone() {
        return dddTelefone;
    }

    public String getNumerotelefone() {
        return numerotelefone;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public void setNumerotelefone(String numerotelefone) {
        this.numerotelefone = numerotelefone;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
