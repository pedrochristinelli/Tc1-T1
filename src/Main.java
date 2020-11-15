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
                                System.out.println("Digite o(s) novo(s) telefone(s) da pessoa");

                            } else if (editIndex == 6) {
                                System.out.println("Digite o novo Nome da pessoa");
                            } else if (editIndex == 7) {
                                System.out.println("Digite o novo Nome da pessoa");
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
