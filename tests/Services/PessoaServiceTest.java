package Services;

import DTO.PessoaDTO;
import DTO.VacinaDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PessoaServiceTest {
    public List<PessoaDTO> geraListaPessoa(){
        List<PessoaDTO> pessoaDTOList = new ArrayList<>();

        /*Pessoa 1*/
        /*Usuário -- Inicio*/
        List<String> telefone = Collections.singletonList(("1651541111"));
        List<String> email = Collections.singletonList(("calor@eduardo.com"));
        /*Usuário -- Fim*/
        /*Vacina -- Inicio*/
        List<String> doencasProtegidas = Collections.singletonList(("Gripe"));
        List<String> idadesDosagens = Collections.singletonList(("16"));
        VacinaDTO vacinaDTO = new VacinaDTO(55,"Vazcina",22.5,doencasProtegidas,idadesDosagens,5);
        List<VacinaDTO> vacinaDTOs = Collections.singletonList((vacinaDTO));
        /*Vacina -- Fim*/

        pessoaDTOList.add(new PessoaDTO("301.785.707-70","Carlos Eduardo",new Date(2000,9,25),"M",2563,telefone,email,vacinaDTOs));

        /*Pessoa 2*/
        /*Usuário -- Inicio*/
        List<String> telefone2 = Collections.singletonList(("16554223634"));
        List<String> email2 = Collections.singletonList(("fernanda@dias.com"));
        /*Usuário -- Fim*/
        /*Vacina -- Inicio*/
        List<String> doencasProtegidas2 = Collections.singletonList(("Febre Amarela"));
        List<String> idadesDosagens2 = Collections.singletonList(("18"));
        VacinaDTO vacinaDTO2 = new VacinaDTO(36,"Vacina",12.5,doencasProtegidas,idadesDosagens,5);
        List<VacinaDTO> vacinaDTOs2 = Collections.singletonList((vacinaDTO));
        /*Vacina -- Fim*/

        pessoaDTOList.add(new PessoaDTO("025.856.966-26","Fernanda Dias",new Date(2000,9,25),"F",1256,telefone2,email2,vacinaDTOs2));

        return pessoaDTOList;
    }

    @Order(1)
    @DisplayName("Teste pessoaCreation - 1")
    @org.junit.jupiter.api.Test
    void pessoaCreation() {
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        /*Usuário -- Inicio*/
        String cpf = "301.785.707-70";
        String nome = "Carlos Eduardo";
        Date date = new Date(2000,9,25);
        String sexo = "M";
        double salario = 2563;
        List<String> telefone = Collections.singletonList(("1651541111"));
        List<String> email = Collections.singletonList(("calor@eduardo.com"));
        /*Usuário -- Fim*/
        /*Vacina -- Inicio*/
        List<String> doencasProtegidas = Collections.singletonList(("Gripe"));
        List<String> idadesDosagens = Collections.singletonList(("16"));
        VacinaDTO vacinaDTO = new VacinaDTO(55,"Vazcina",22.5,doencasProtegidas,idadesDosagens,5);
        List<VacinaDTO> vacinaDTOs = Collections.singletonList((vacinaDTO));
        /*Vacina -- Fim*/

        PessoaService pessoaService = new PessoaService();
        PessoaDTO pessoaDTO = pessoaService.pessoaCreation(cpf,nome,date,sexo,salario,telefone,email,vacinaDTOs);
        assertAll(
                () -> assertEquals(cpf, pessoaDTO.getCpf()),
                () -> assertEquals(nome, pessoaDTO.getNome()),
                () -> assertEquals(date, pessoaDTO.getDataNascimento()),
                () -> assertEquals(sexo, pessoaDTO.getSexo()),
                () -> assertEquals(salario, pessoaDTO.getSalario())
        );
    }

    @Order(2)
    @DisplayName("Teste pessoaEdit - 1")
    @ParameterizedTest
    @ValueSource(ints = {0,1})
    void pessoaEdit(int parametro) {
        PessoaService pessoaService = new PessoaService();
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        PessoaDTO pessoaDTO = pessoaDTOList.get(parametro);
        assertEquals("Pessoa Atualizada com Sucesso!",pessoaService.pessoaEdit(pessoaDTOList,pessoaDTO));
    }

    @Order(3)
    @DisplayName("Teste pessoaDelete - 1")
    @ParameterizedTest
    @ValueSource(strings = {"301.785.707-70", "025.856.966-26"})
    void pessoaDelete(String cpf) {
        PessoaService pessoaService = new PessoaService();
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        assertEquals("Pessoa deletada com Sucesso!", pessoaService.pessoaDelete(pessoaDTOList,cpf));
    }

    @Order(4)
    @DisplayName("Teste listarTodasPessoas - 1")
    @org.junit.jupiter.api.Test
    void listarTodasPessoas() {
        PessoaService pessoaService = new PessoaService();
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        String todasPessoas = "";
        for (PessoaDTO pessoa: pessoaDTOList) {
            todasPessoas = todasPessoas + pessoa.toString();
        }
        assertEquals(todasPessoas, pessoaService.listarTodasPessoas(pessoaDTOList));
    }

    @Order(5)
    @DisplayName("Teste listarPessoaPeloCpf - 1")
    @ParameterizedTest
    @ValueSource(strings = {"301.785.707-70", "025.856.966-26"})
    void listarPessoaPeloCpf(String cpf) {
        PessoaService pessoaService = new PessoaService();
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        PessoaDTO pessoaDTO = null;
        for(PessoaDTO pessoa : pessoaDTOList){
            if(pessoa.getCpf().equals(cpf)){
                pessoaDTO = pessoa;
            }
        }
        assert pessoaDTO != null;
        assertEquals(pessoaDTO.toString(), pessoaService.listarPessoaPeloCpf(pessoaDTOList, cpf));
    }

    @Order(6)
    @DisplayName("Teste getPessoaByCpf - 1")
    @ParameterizedTest
    @ValueSource(strings = {"301.785.707-70", "025.856.966-26"})
    void getPessoaByCpf(String cpf) {
        PessoaService pessoaService = new PessoaService();
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        PessoaDTO pessoaDTO = null;
        for(PessoaDTO pessoa : pessoaDTOList){
            if(pessoa.getCpf().equals(cpf)){
                pessoaDTO = pessoa;
            }
        }
        assertEquals(pessoaDTO, pessoaService.getPessoaByCpf(pessoaDTOList, cpf));
    }
}