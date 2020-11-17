package Services;

import DTO.PessoaDTO;
import DTO.VacinaDTO;

import java.util.Date;
import java.util.List;

public class PessoaService {
    public PessoaDTO pessoaCreation(String cpf, String nome, Date dataNascimento, String sexo, double salario, List<String> emails, List<String> telefones, List<VacinaDTO> vacinaDTOs){
        PessoaDTO newPessoa = new PessoaDTO();
        newPessoa.setCpf(cpf);
        newPessoa.setNome(nome);
        newPessoa.setDataNascimento(dataNascimento);
        newPessoa.setSexo(sexo);
        newPessoa.setSalario(salario);
        newPessoa.setTelefones(telefones);
        newPessoa.setEmails(emails);
        newPessoa.setVacinaDTOs(vacinaDTOs);
        return newPessoa;
    }

    public String pessoaEdit(List<PessoaDTO> pessoaDTOList, PessoaDTO pessoaDTO){
        for (PessoaDTO pessoa: pessoaDTOList) {
            if (pessoa.getCpf().equals(pessoaDTO.getCpf())){
                pessoa = pessoaDTO;
                return "Pessoa Atualizada com Sucesso!";
            }
        }
        return "Pessoa não encontrada!";
    }

    public String pessoaDelete(List<PessoaDTO> pessoaDTOList, String cpf){
        for (PessoaDTO pessoa: pessoaDTOList) {
            if (pessoa.getCpf().equals(cpf)){
                pessoaDTOList.remove(pessoa);
                return "Pessoa deletada com Sucesso!";
            }
        }
        return "Pessoa não encontrada!";
    }

    public String listarTodasPessoas(List<PessoaDTO> pessoaDTOList){
        String todasPessoas = "";
        if(!pessoaDTOList.isEmpty()){
            for (PessoaDTO pessoa: pessoaDTOList) {
                todasPessoas = todasPessoas + pessoa.toString();
            }
        } else {
            todasPessoas = "Nenhuma pessoa cadastrada na lista!";
        }
        return todasPessoas;
    }

    public String listarPessoaPeloCpf(List<PessoaDTO> pessoaDTOList, String cpf){
        for (PessoaDTO pessoa: pessoaDTOList) {
            if (pessoa.getCpf().equals(cpf)){
                return pessoa.toString();
            }
        }
        return "Pessoa não encontrada!";
    }

    public PessoaDTO getPessoaByCpf(List<PessoaDTO> pessoaDTOList, String cpf){
        for (PessoaDTO pessoa: pessoaDTOList) {
            if (pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return new PessoaDTO();
    }
}
