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

class VacinaServiceTest {

    public List<VacinaDTO> geraListaVacina(){
        List<VacinaDTO> vacinaDTOList = new ArrayList<>();

        /*Vacina 1 -- Inicio*/
        List<String> doencasProtegidas = Collections.singletonList(("Gripe"));
        List<String> idadesDosagens = Collections.singletonList(("16"));
        vacinaDTOList.add(new VacinaDTO(55,"Vazcina",22.5,doencasProtegidas,idadesDosagens,5));
        /*Vacina 1 -- Fim*/

        /*Vacina 2 -- Inicio*/
        List<String> doencasProtegidas2 = Collections.singletonList(("Febre Amarela"));
        List<String> idadesDosagens2 = Collections.singletonList(("18"));
        vacinaDTOList.add(new VacinaDTO(36,"Vacina",12.5,doencasProtegidas,idadesDosagens,2));
        /*Vacina 2 -- Fim*/

        return vacinaDTOList;
    }

    @Order(1)
    @DisplayName("Teste vacinaCreation - 1")
    @Test
    void vacinaCreation() {
        VacinaService vacinaService = new VacinaService();
        List<String> doencasProtegidas = Collections.singletonList(("Tétano"));
        List<String> idadesDosagens = Collections.singletonList(("10"));
        int codigo = 10;
        String nome = "Tetaniaziade";
        double price = 32.5;
        int tempo = 7;
        VacinaDTO vacinaDTO = vacinaService.vacinaCreation(codigo,nome,price,doencasProtegidas,idadesDosagens,tempo);
        assertAll(
                () -> assertEquals(codigo, vacinaDTO.getCodigo()),
                () -> assertEquals(nome, vacinaDTO.getNome()),
                () -> assertEquals(price, vacinaDTO.getPreco()),
                () -> assertEquals(tempo, vacinaDTO.getTempoDuracaoEfeitoEmAnos()),
                () -> assertEquals(doencasProtegidas, vacinaDTO.getDoencasProtegidas()),
                () -> assertEquals(idadesDosagens, vacinaDTO.getIdadesDosagens())
        );
    }

    @Order(2)
    @DisplayName("Teste vacinaEdit - 1")
    @ParameterizedTest
    @ValueSource(ints = {0,1})
    void vacinaEdit(int parametro) {
        VacinaService vacinaService = new VacinaService();
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        VacinaDTO vacinaDTO = vacinaDTOList.get(parametro);
        assertEquals("Vacina Atualizada com Sucesso!", vacinaService.vacinaEdit(vacinaDTOList,vacinaDTO));
    }

    @Order(3)
    @DisplayName("Teste vacinaDelete - 1")
    @ParameterizedTest
    @ValueSource(ints = {36, 55})
    void vacinaDelete(int codigo) {
        VacinaService vacinaService = new VacinaService();
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        assertEquals("Vacina deletada com Sucesso!", vacinaService.vacinaDelete(vacinaDTOList,codigo));
    }

    @Order(4)
    @DisplayName("Teste listarTodasVacinas - 1")
    @Test
    void listarTodasVacinas() {
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        VacinaService vacinaService = new VacinaService();
        String todasVacinas = "";
        for (VacinaDTO vacina: vacinaDTOList) {
            todasVacinas = todasVacinas + vacina.toString();
        }
        assertEquals(todasVacinas, vacinaService.listarTodasVacinas(vacinaDTOList));
    }

    @Order(5)
    @DisplayName("Teste listarVacinapeloCodigo - 1")
    @ParameterizedTest
    @ValueSource(ints = {36, 55})
    void listarVacinapeloCodigo(int codigo) {
        VacinaService vacinaService = new VacinaService();
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        VacinaDTO vacinaDTO = null;
        for(VacinaDTO vacina : vacinaDTOList){
            if(vacina.getCodigo() == codigo){
                vacinaDTO = vacina;
            }
        }
        assert vacinaDTO != null;
        assertEquals(vacinaDTO.toString(), vacinaService.listarVacinapeloCodigo(vacinaDTOList, codigo));
    }

    @Order(6)
    @DisplayName("Teste getVacinaInListByCodigo - 1")
    @ParameterizedTest
    @ValueSource(ints = {36, 55})
    void getVacinaInListByCodigo(int codigo) {
        VacinaService vacinaService = new VacinaService();
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        VacinaDTO vacinaDTO = null;
        for(VacinaDTO vacina : vacinaDTOList){
            if(vacina.getCodigo() == codigo){
                vacinaDTO = vacina;
            }
        }
        assertEquals(vacinaDTO, vacinaService.getVacinaInListByCodigo(vacinaDTOList, codigo));
    }
}