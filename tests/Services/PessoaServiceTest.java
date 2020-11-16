package Services;

import DTO.PessoaDTO;
import DTO.VacinaDTO;
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

    @org.junit.jupiter.api.Test
    void pessoaCreation() {
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
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
        assertEquals(3, pessoaDTOList.size());
    }

    @ParameterizedTest
    @ValueSource(ints = 1)
    void pessoaEdit(int parametro) {
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        PessoaDTO pessoaDTO = pessoaDTOList.get(parametro);
        pessoaDTO.setCpf("818.353.368-09");
        assertEquals("818.353.368-09",pessoaDTOList.get(parametro).getCpf());
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    void pessoaDelete(int parametro) {
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        String cpf = pessoaDTOList.get(parametro).getCpf();
        pessoaDTOList.remove(parametro);
        int result = 0;
        for(PessoaDTO pessoa : pessoaDTOList){
            if(pessoa.getCpf().equals(cpf)){
                result = 1;
            }
        }
        assertEquals(0, result);
    }

    @org.junit.jupiter.api.Test
    void listarTodasPessoas() {
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        System.out.println("Número de pessoas: "+pessoaDTOList.size());
        int pessoas_listadas = 0;
        for(PessoaDTO pessoa : pessoaDTOList){
            pessoas_listadas++;
            System.out.println(pessoas_listadas +": "+ pessoa.getCpf());
        }
        assertEquals(2, pessoas_listadas);
    }

    @ParameterizedTest
    @ValueSource(strings = "301.785.707-70")
    void listarPessoaPeloCpf(String parametro) {
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        System.out.println("Número de pessoas: 1");
        int pessoas_listadas = 0;
        for(PessoaDTO pessoa : pessoaDTOList){
            if(pessoa.getCpf().equals(parametro)){
                pessoas_listadas++;
                System.out.println(pessoas_listadas +": "+ pessoa.getCpf());
            }
        }
        assertEquals(1, pessoas_listadas);
    }

    @ParameterizedTest
    @ValueSource(strings = "301.785.707-70")
    void getPessoaByCpf(String parametro) {
        List<PessoaDTO> pessoaDTOList = geraListaPessoa();
        PessoaDTO pessoaDTO = null;
        for(PessoaDTO pessoa : pessoaDTOList){
            if(pessoa.getCpf().equals(parametro)){
                pessoaDTO = pessoa;
            }
        }
        assert pessoaDTO != null;
        assertEquals(parametro, pessoaDTO.getCpf());
    }
}