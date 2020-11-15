import DTO.PessoaDTO;
import DTO.VacinaDTO;
import Services.MenuService;
import Services.PessoaService;
import Services.VacinaService;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<PessoaDTO> pessoaDTOList = new ArrayList<>();
        List<VacinaDTO> vacinaDTOList = new ArrayList<>();
        VacinaService vacinaService = new VacinaService();
        PessoaService pessoaService = new PessoaService();
        MenuService menuService = new MenuService();
        int menu = 0;
        int submenuPessoas = 0;
        int submenuVacinas = 0;
        Scanner input = new Scanner(System.in);

        while(menu != 3){
            if (menu == 0){
                System.out.println(menuService.menuPrincipal());
                System.out.println("Digite o numero da opção desejada: ");
                menu = input.nextInt();
            } else if (menu == 1){
                System.out.println(menuService.menuPessoas());
                System.out.println("Digite o numero da opção desejada: ");
                submenuPessoas = input.nextInt();
                if(submenuPessoas == 1){
                    System.out.println(pessoaService.listarTodasPessoas(pessoaDTOList));
                } else if (submenuPessoas == 2){
                    System.out.println("Digite o CPF da pessoa: ");
                    String cpf = input.next();
                    System.out.println(pessoaService.listarPessoaPeloCpf(pessoaDTOList, cpf));
                } else if (submenuPessoas == 3){
                    System.out.println("Digite o CPF da pessoa: ");
                    String cpf = input.next();
                    System.out.println("Digite o Nome da pessoa: ");
                    String nome = input.next();
                    System.out.println("Digite a Data de nascimento da pessoa");
                    System.out.println("Dia:");
                    int dia = input.nextInt();
                    System.out.println("Mês:");
                    int mes = input.nextInt();
                    System.out.println("Ano:");
                    int ano = input.nextInt();
                    Date dataNasc = new Date(dia, mes, ano);
                    System.out.println("Digite o Sexo da pessoa: (M, F ou Outro)");
                    String sexo = input.next();
                    System.out.println("Digite o salario da pessoa: ");
                    double salario = input.nextDouble();
                    List<String> email = new ArrayList<>();
                    System.out.println("Essa pessoa possui email? (S ou N)");
                    int finish = 0;
                    while (finish != 1) {
                        String hasEmail = input.next();
                        if (hasEmail.equals("S") || hasEmail.equals("s")){
                            System.out.println("Digite o Email:");
                            email.add(input.next());
                            System.out.println("Tem outro Email? (S ou N)");
                        } else if (hasEmail.equals("N") || hasEmail.equals("n")) {
                            finish = 1;
                        } else {
                            System.out.println("Resposta inválida, responda S ou N");
                        }
                    }
                    List<String> telefone = new ArrayList<>();
                    System.out.println("Essa pessoa possui telefone? (S ou N)");
                    finish = 0;
                    while (finish != 1) {
                        String hasTelefone = input.next();
                        if (hasTelefone.equals("S") || hasTelefone.equals("s")){
                            System.out.println("Digite o telefone:");
                            telefone.add(input.next());
                            System.out.println("Tem outro telefone? (S ou N)");
                        } else if (hasTelefone.equals("N") || hasTelefone.equals("n")) {
                            finish = 1;
                        } else {
                            System.out.println("Resposta inválida, responda S ou N");
                        }
                    }
                    List<VacinaDTO> vacinasTomadas = new ArrayList<>();
                    System.out.println("Essa pessoa já tomou alguma vacina? (S ou N)");
                    finish = 0;
                    while (finish != 1) {
                        String hasVacina = input.next();
                        if (hasVacina.equals("S") || hasVacina.equals("s")){
                            System.out.println("Digite o codigo da vacina tomada:");
                            VacinaDTO vacinaDTO = vacinaService.getVacinaInListByCodigo(vacinaDTOList, input.nextInt());
                            if (vacinaDTO.getCodigo() == 0){
                                System.out.println("Vacina não encontrada, desesja tentar outro codigo? (S ou N)");
                            } else {
                                vacinasTomadas.add(vacinaDTO);
                                System.out.println("Tomou outra vacina? (S ou N)");
                            }
                        } else if (hasVacina.equals("N") || hasVacina.equals("n")) {
                            finish = 1;
                        } else {
                            System.out.println("Resposta inválida, responda S ou N");
                        }
                    }
                    PessoaDTO pessoaDTO = pessoaService.pessoaCreation(cpf,nome,dataNasc,sexo,salario,email,telefone,vacinasTomadas);
                    pessoaDTOList.add(pessoaDTO);
                    System.out.println(pessoaDTO.toString());
                } else if (submenuPessoas == 4){
                    System.out.println("Digite o CPF da pessoa");
                    PessoaDTO pessoa = pessoaService.getPessoaByCpf(pessoaDTOList, input.next());
                    if (pessoa.getCpf()==null){
                        System.out.println("Pessoa não encontrada!");
                    }else{
                        System.out.println(menuService.menuEditPessoa());
                        int finish = 0;
                        while (finish != 1) {
                            int editIndex = input.nextInt();
                            if (editIndex == 1){
                                System.out.println("Digite o novo Nome da pessoa");
                                pessoa.setNome(input.next());
                            } else if (editIndex == 2) {
                                System.out.println("Digite a nova data de nascimento da pessoa");
                                System.out.println("Dia:");
                                int dia = input.nextInt();
                                System.out.println("Mês:");
                                int mes = input.nextInt();
                                System.out.println("Ano:");
                                int ano = input.nextInt();
                                pessoa.setDataNascimento(new Date(dia,mes,ano));
                            } else if (editIndex == 3) {
                                System.out.println("Digite o novo sexo da pessoa");
                                pessoa.setSexo(input.next());
                            } else if (editIndex == 4) {
                                System.out.println("Digite o novo salario da pessoa");
                                pessoa.setSalario(input.nextDouble());
                            } else if (editIndex == 5) {
                                System.out.println(menuService.menuEditTelefone());
                                System.out.println("Digite a opção desejada");
                                int finishTel = 0;
                                while (finishTel != 1){
                                    int opt = input.nextInt();
                                    if (opt == 1){
                                        System.out.println("Digite o novo telefone no formato (xx)xxxxx-xxxx");
                                        pessoa.getTelefones().add(input.next());
                                        System.out.println(menuService.menuEditTelefone());
                                    } else if(opt == 2){
                                        System.out.println("Telefones disponíveis:");
                                        for (int i = 0; i < pessoa.getTelefones().size(); i++) {
                                            System.out.println(i + " - " + pessoa.getTelefones().get(i));
                                        }
                                        System.out.println("Digite a posição do telefone a ser excluido:");
                                        int pos = input.nextInt();
                                        if (pos < pessoa.getTelefones().size()){
                                            pessoa.getTelefones().remove(pos);
                                        } else {
                                            System.out.println("Telefone não encontrado pra posição informada!");
                                        }
                                        System.out.println(menuService.menuEditTelefone());
                                    } else{
                                        finishTel = 1;
                                    }
                                }
                            } else if (editIndex == 6) {
                                System.out.println(menuService.menuEditEmail());
                                System.out.println("Digite a opção desejada");
                                int finishTel = 0;
                                while (finishTel != 1){
                                    int opt = input.nextInt();
                                    if (opt == 1){
                                        System.out.println("Digite o novo email");
                                        pessoa.getEmails().add(input.next());
                                        System.out.println(menuService.menuEditEmail());
                                    } else if(opt == 2){
                                        System.out.println("Emails disponíveis:");
                                        for (int i = 0; i < pessoa.getTelefones().size(); i++) {
                                            System.out.println(i + " - " + pessoa.getEmails().get(i));
                                        }
                                        System.out.println("Digite a posição do email a ser excluido:");
                                        int pos = input.nextInt();
                                        if (pos < pessoa.getEmails().size()){
                                            pessoa.getEmails().remove(pos);
                                        } else {
                                            System.out.println("Email não encontrado pra posição informada!");
                                        }
                                        System.out.println(menuService.menuEditEmail());
                                    } else{
                                        finishTel = 1;
                                    }
                                }
                            } else if (editIndex == 7) {
                                System.out.println(menuService.menuVacinas());
                                System.out.println("Digite a opção desejada");
                                int finishTel = 0;
                                while (finishTel != 1){
                                    int opt = input.nextInt();
                                    if (opt == 1){
                                        System.out.println("Digite o codigo da nova vacina");
                                        VacinaDTO vacinaDTO = vacinaService.getVacinaInListByCodigo(vacinaDTOList, input.nextInt());
                                        pessoa.getVacinaDTOs().add(vacinaDTO);
                                        System.out.println(menuService.menuEditEmail());
                                    } else if(opt == 2){
                                        System.out.println("Vacinas disponíveis:");
                                        for (int i = 0; i < pessoa.getTelefones().size(); i++) {
                                            System.out.println(i + " - Codigo " + pessoa.getVacinaDTOs().get(i).getCodigo());
                                        }
                                        System.out.println("Digite a posição da vacina a ser excluida:");
                                        int posVac = input.nextInt();
                                        if(posVac < pessoa.getVacinaDTOs().size()){
                                            pessoa.getVacinaDTOs().remove(posVac);
                                        } else {
                                            System.out.println("Vacina Não encontrada pro valor informado");
                                        }
                                        System.out.println(menuService.menuEditEmail());
                                    } else{
                                        finishTel = 1;
                                    }
                                }
                            } else {
                                System.out.println(pessoaService.pessoaEdit(pessoaDTOList, pessoa));
                                finish = 1;
                            }
                        }
                    }
                } else if (submenuPessoas == 5){
                    System.out.println("Digite o CPF da pessoa que deseja excluir");
                    System.out.println(pessoaService.pessoaDelete(pessoaDTOList, input.next()));
                }
                menu = 0;
            } else if (menu == 2){
                System.out.println(menuService.menuVacinas());
                if (input.nextInt()==1){
                    System.out.println(vacinaService.listarTodasVacinas(vacinaDTOList));
                } else if (input.nextInt()==2){
                    System.out.println("Digite o codigo da vacina");
                    System.out.println(vacinaService.listarVacinapeloCodigo(vacinaDTOList, input.nextInt()));
                } else if (input.nextInt()==3){
                    System.out.println("Digite o codigo da vacina");
                    int codigo = input.nextInt();
                    System.out.println("Digite o nome da vacina");
                    String nome = input.next();
                    System.out.println("Digite o preço da vacina");
                    double preco = input.nextDouble();
                    int finish = 0;
                    List<String> doencas = new ArrayList<>();
                    System.out.println("Digite (individualmente) de quais doenças essa vacina protege");
                    while (finish != 1) {
                        System.out.println("Digite o nome de UMA doença que ela protege");
                        doencas.add(input.next());
                        System.out.println("Essa vacina protege de mais doenças? (S ou N)");
                        String hasDoenca = input.next();
                        if (hasDoenca.equals("S") || hasDoenca.equals("s")){
                            finish = 0;
                        } else if (hasDoenca.equals("N") || hasDoenca.equals("n")) {
                            finish = 1;
                        } else {
                            System.out.println("Resposta inválida, responda S ou N");
                        }
                    }
                    List<String> dosagens = new ArrayList<>();
                    System.out.println("Digite (individualmente) as idades/dosagens");
                    while (finish != 1) {
                        System.out.println("Digite a idade e dosagem recomendada");
                        dosagens.add(input.next());
                        System.out.println("Adicionar mais uma idade e dosagem recomendada? (S ou N)");
                        String hasDosagem = input.next();
                        if (hasDosagem.equals("S") || hasDosagem.equals("s")){
                            finish = 0;
                        } else if (hasDosagem.equals("N") || hasDosagem.equals("n")) {
                            finish = 1;
                        } else {
                            System.out.println("Resposta inválida, responda S ou N");
                        }
                    }
                    System.out.println("Digite, em quantidade de anos, o tempo de duração do efeito da vacina");
                    int tempoDuracao = input.nextInt();
                    VacinaDTO vacinaDTO = vacinaService.vacinaCreation(codigo, nome, preco, doencas, dosagens, tempoDuracao);
                    vacinaDTOList.add(vacinaDTO);
                    System.out.println(vacinaDTO.toString());
                } else if (input.nextInt()==4){
                    System.out.println("Digite o codigo da vacina");
                    VacinaDTO vacina = vacinaService.getVacinaInListByCodigo(vacinaDTOList, input.nextInt());
                    if (vacina.getCodigo()== 0){
                        System.out.println("Vacina não encontrada!");
                    }else{
                        System.out.println(menuService.menuEditVacinaDto());
                        int finish = 0;
                        while (finish != 1) {
                            int editIndex = input.nextInt();
                            if (editIndex == 1){
                                System.out.println("Digite o novo Nome da vacina");
                                vacina.setNome(input.next());
                            } else if (editIndex == 2) {
                                System.out.println("Digite o novo Preço da vacina");
                                vacina.setPreco(input.nextDouble());
                            } else if (editIndex == 3) {
                                System.out.println(menuService.menuEditVacinaDoencas());
                                System.out.println("Digite a opção desejada");
                                int finishTel = 0;
                                while (finishTel != 1){
                                    int opt = input.nextInt();
                                    if (opt == 1){
                                        System.out.println("Digite a nova doença protegida");
                                        vacina.getDoencasProtegidas().add(input.next());
                                        System.out.println(menuService.menuEditEmail());
                                    } else if(opt == 2){
                                        System.out.println("Doenças protegidas disponíveis:");
                                        for (int i = 0; i < vacina.getDoencasProtegidas().size(); i++) {
                                            System.out.println(i + " - " + vacina.getDoencasProtegidas().get(i));
                                        }
                                        System.out.println("Digite a posição da doença a ser excluido:");
                                        int pos = input.nextInt();
                                        if (pos < vacina.getDoencasProtegidas().size()){
                                            vacina.getDoencasProtegidas().remove(pos);
                                        } else {
                                            System.out.println("Doença não encontrado pra posição informada!");
                                        }
                                        System.out.println(menuService.menuEditVacinaDosagens());
                                    } else{
                                        finishTel = 1;
                                    }
                                }
                            }else if (editIndex == 4) {
                                System.out.println(menuService.menuEditVacinaDosagens());
                                System.out.println("Digite a opção desejada");
                                int finishTel = 0;
                                while (finishTel != 1){
                                    int opt = input.nextInt();
                                    if (opt == 1){
                                        System.out.println("Digite a nova idade e dosagem.");
                                        vacina.getIdadesDosagens().add(input.next());
                                        System.out.println(menuService.menuEditEmail());
                                    } else if(opt == 2){
                                        System.out.println("Idades e dosagens disponíveis:");
                                        for (int i = 0; i < vacina.getIdadesDosagens().size(); i++) {
                                            System.out.println(i + " - " + vacina.getIdadesDosagens().get(i));
                                        }
                                        System.out.println("Digite a posição da idade/Dosagem a ser excluido:");
                                        int pos = input.nextInt();
                                        if (pos < vacina.getIdadesDosagens().size()){
                                            vacina.getIdadesDosagens().remove(pos);
                                        } else {
                                            System.out.println("Idade e Dosagem não encontrado pra posição informada!");
                                        }
                                        System.out.println(menuService.menuEditVacinaDosagens());
                                    } else{
                                        finishTel = 1;
                                    }
                                }
                            }else if (editIndex == 5) {
                                System.out.println("Digite o novo Tempo de duração em anos da vacina");
                                vacina.setTempoDuracaoEfeitoEmAnos(input.nextFloat());
                            }else{
                                vacinaService.vacinaEdit(vacinaDTOList, vacina);
                                finish = 1;
                            }
                        }
                    }
                } else if (input.nextInt()==5){
                    System.out.println("Digite o codigo da vacina que quer excluir");
                    System.out.println(vacinaService.vacinaDelete(vacinaDTOList, input.nextInt()));
                }
                menu = 0;
            } else if (menu != 3){
                System.out.println("Menu não encontrado!");
                menu = 0;
            }
        }
    }
}
