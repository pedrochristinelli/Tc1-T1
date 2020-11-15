package DTO;

import java.util.Date;
import java.util.List;

public class PessoaDTO {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String sexo;
    private double salario;
    private List<String> emails;
    private List<String> telefones;
    private List<VacinaDTO> vacinaDTOs;

    public PessoaDTO(String cpf, String nome, Date dataNascimento, String sexo, double salario, List<String> emails, List<String> telefones) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.salario = salario;
        this.emails = emails;
        this.telefones = telefones;
    }

    public PessoaDTO(String cpf, String nome, Date dataNascimento, String sexo, double salario, List<String> emails, List<String> telefones, List<VacinaDTO> vacinaDTOs) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.salario = salario;
        this.emails = emails;
        this.telefones = telefones;
        this.vacinaDTOs = vacinaDTOs;
    }

    public PessoaDTO() {
    }

    @Override
    public String toString() {
        return "Pessoa:" +
                "\nCpf: '" + cpf + '\'' +
                "\nNome: '" + nome + '\'' +
                "\nDataNascimento: " + dataNascimento +
                "\nSexo: '" + sexo + '\'' +
                "\nSalario: " + salario +
                "\nE-mails: " + emails +
                "\nTelefones: " + telefones +
                "\nVacinas Tomadas: " + vacinaDTOs +
                '.';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public List<VacinaDTO> getVacinaDTOs() {
        return vacinaDTOs;
    }

    public void setVacinaDTOs(List<VacinaDTO> vacinaDTOs) {
        this.vacinaDTOs = vacinaDTOs;
    }
}
