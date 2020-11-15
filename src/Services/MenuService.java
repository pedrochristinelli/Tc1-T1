package Services;

public class MenuService {
    public String menuPrincipal(){
        String menu = "\n" +
                "+------------------------+\n" +
                "|     Menu Principal     |\n" +
                "+========================+\n" +
                "| 1 - Submenu de pessoas |\n" +
                "| 2 - Submenu de Vacinas |\n" +
                "| 3 - Sair               |\n" +
                "+------------------------+\n" +
                "\n";
        return menu;
    }

    public String menuPessoas(){
        String menu = "\n" +
                "+--------------------==+\n" +
                "| Submenu de pessoas   |\n" +
                "+======================+\n" +
                "| 1 - Listar Todos     |\n" +
                "| 2 - Listar Um        |\n" +
                "| 3 - Incluir          |\n" +
                "| 4 - Alterar          |\n" +
                "| 5 - Excluir          |\n" +
                "| Outro digito - Voltar|\n" +
                "+----------------------+\n" +
                "\n";
        return menu;
    }

    public String menuVacinas(){
        String menu = "\n" +
                "+----------------------+\n" +
                "| Submenu de Vacinas   |\n" +
                "+======================+\n" +
                "| 1 - Listar Todos     |\n" +
                "| 2 - Listar Um        |\n" +
                "| 3 - Incluir          |\n" +
                "| 4 - Alterar          |\n" +
                "| 5 - Excluir          |\n" +
                "| Outro digito - Voltar|\n" +
                "+----------------------+\n" +
                "\n";
        return menu;
    }

    public String menuEditPessoa(){
        String menu = "\n" +
                "+-------------------------+\n" +
                "| Dados Editaveis         |\n" +
                "+=========================+\n" +
                "| 1 - Nome                |\n" +
                "| 2 - Data de Nascimento  |\n" +
                "| 3 - Sexo                |\n" +
                "| 4 - Salario             |\n" +
                "| 5 - Telefones           |\n" +
                "| 6 - Emails              |\n" +
                "| 7 - Vacinas Tomadas     |\n" +
                "| Outro digito - Confirmar|\n" +
                "+-------------------------+\n" +
                "\n";
        return menu;
    }
}
