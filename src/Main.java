import DTO.PessoaDTO;
import DTO.VacinaDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VacinaDTO vacinaDTO = new VacinaDTO();
        vacinaDTO.setCodigo(1);
        vacinaDTO.setDoencasProtegidas(Arrays.asList("Herpes"));
        vacinaDTO.setNome("Hepius Preventus");
        vacinaDTO.setPreco(123.23);
        vacinaDTO.setTempoDuracaoEfeitoEmAnos(12);
        vacinaDTO.setIdadesDosagens(Arrays.asList("Todas as idades: 5ml"));

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setCpf("956.599.910-76");
        pessoaDTO.setDataNascimento(new Date(27,05,1999));
        pessoaDTO.setNome("Carlos José da Silva");
        pessoaDTO.setSalario(1075.00);
        pessoaDTO.setSexo("Masculino");
        pessoaDTO.setTelefones(Arrays.asList("carlos.gmail.com", "carlao@gmail.com"));
        pessoaDTO.setEmails(Arrays.asList("(16)98145-1615", "(16)98145-1855"));
        pessoaDTO.setVacinaDTOs(Arrays.asList(vacinaDTO));
    }
}
