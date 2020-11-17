package Services;

import DTO.PessoaDTO;
import DTO.VacinaDTO;

import java.util.List;

public class VacinaService {
    public VacinaDTO vacinaCreation(int codigo, String nome, double preco, List<String> doencasProtegidas, List<String> idadesDosagens, float tempoDuracaoEfeitoEmAnos){
        VacinaDTO newVacina = new VacinaDTO();
        newVacina.setCodigo(codigo);
        newVacina.setNome(nome);
        newVacina.setPreco(preco);
        newVacina.setDoencasProtegidas(doencasProtegidas);
        newVacina.setIdadesDosagens(idadesDosagens);
        newVacina.setTempoDuracaoEfeitoEmAnos(tempoDuracaoEfeitoEmAnos);

        return newVacina;
    }

    public String vacinaEdit(List<VacinaDTO> vacinaDTOList, VacinaDTO vacinaDTO){
        for (VacinaDTO vacina: vacinaDTOList) {
            if (vacina.getCodigo() == vacinaDTO.getCodigo()){
                vacina = vacinaDTO;
                return "Vacina Atualizada com Sucesso!";
            }
        }
        return "Vacina não encontrada!";
    }

    public String vacinaDelete(List<VacinaDTO> vacinaDTOList, int codigo){
        for (VacinaDTO vacina: vacinaDTOList) {
            if (vacina.getCodigo()== codigo){
                vacinaDTOList.remove(vacina);
                return "Vacina deletada com Sucesso!";
            }
        }
        return "Vacina não encontrada!";
    }

    public String listarTodasVacinas(List<VacinaDTO> vacinaDTOList){
        String todasVacinas = "";
        if(!vacinaDTOList.isEmpty()){
            for (VacinaDTO vacina: vacinaDTOList) {
                todasVacinas = todasVacinas + vacina.toString();
            }
        } else {
            todasVacinas = "Nenhuma vacina cadastrada na lista!";
        }
        return todasVacinas;
    }

    public String listarVacinapeloCodigo(List<VacinaDTO> vacinaDTOList, int codigo){
        for (VacinaDTO vacina: vacinaDTOList) {
            if (vacina.getCodigo() == codigo){
                return vacina.toString();
            }
        }
        return "Vacina não encontrada!";
    }

    public VacinaDTO getVacinaInListByCodigo(List<VacinaDTO> vacinaDTOList, int codigo){
        for (VacinaDTO vacina: vacinaDTOList) {
            if (vacina.getCodigo() == codigo){
                return vacina;
            }
        }
        return new VacinaDTO();
    }
}
