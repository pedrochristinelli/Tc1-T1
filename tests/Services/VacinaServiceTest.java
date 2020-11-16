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

    @Test
    void vacinaCreation() {
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        List<String> doencasProtegidas = Collections.singletonList(("Tétano"));
        List<String> idadesDosagens = Collections.singletonList(("10"));
        vacinaDTOList.add(new VacinaDTO(10,"Tetaniaziade",32.5,doencasProtegidas,idadesDosagens,7));
        assertEquals(3, vacinaDTOList.size());
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    void vacinaEdit(int parametro) {
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        VacinaDTO vacinaDTO = vacinaDTOList.get(parametro);
        vacinaDTO.setNome("Vacina Legal");
        assertEquals("Vacina Legal", vacinaDTO.getNome());
    }

    @ParameterizedTest
    @ValueSource(ints = 1)
    void vacinaDelete(int parametro) {
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        VacinaDTO vacinaDTO = vacinaDTOList.get(parametro);
        int codigo = vacinaDTO.getCodigo();
        vacinaDTOList.remove(parametro);
        int result = 0;
        for(VacinaDTO vacinaDTO1 : vacinaDTOList){
            if(vacinaDTO1.getCodigo() == codigo){
                result = 1;
            }
        }
        assertEquals(0, result);
    }

    @Test
    void listarTodasVacinas() {
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        System.out.println("Número de vacinas: "+vacinaDTOList.size());
        int vacinas_listadas = 0;
        for(VacinaDTO vacinaDTO1 : vacinaDTOList){
            vacinas_listadas++;
            System.out.println(vacinas_listadas +": "+ vacinaDTO1.getCodigo());
        }
        assertEquals(2, vacinas_listadas);
    }

    @ParameterizedTest
    @ValueSource(ints = 36)
    void listarVacinapeloCodigo(int parametro) {
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        System.out.println("Número de vacinas: 1");
        int vacinas_listadas = 0;
        for(VacinaDTO vacinaDTO1 : vacinaDTOList){
            if(vacinaDTO1.getCodigo() == parametro){
                vacinas_listadas++;
                System.out.println(vacinas_listadas +": "+ vacinaDTO1.getCodigo());
            }
        }
        assertEquals(1, vacinas_listadas);
    }

    @ParameterizedTest
    @ValueSource(ints = 55)
    void getVacinaInListByCodigo(int parametro) {
        List<VacinaDTO> vacinaDTOList = geraListaVacina();
        System.out.println("Número de vacinas: 1");
        VacinaDTO vacina = null;
        for(VacinaDTO vacinaDTO1 : vacinaDTOList){
            if(vacinaDTO1.getCodigo() == parametro){
                vacina = vacinaDTO1;
            }
        }
        assert vacina != null;
        assertEquals(parametro, vacina.getCodigo());
    }
}