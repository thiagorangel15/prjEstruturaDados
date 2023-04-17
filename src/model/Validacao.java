package model;

public class Validacao {
    final public static int TAM_CODIGO_DISCIPLINA = 8;
    final public static int TAM_MAX_NOME_DISCIPLINA = 60;
    final public static int TAM_MIN_CREDITOS = 1;
    final public static int TAM_MAX_CREDITOS = 8;
    public static void validarCodigoDisciplina(String codigo) throws Exception{
        if (codigo == null){
            throw new Exception("O código não pode ser nulo!!");
        }
        if (codigo.length() != TAM_CODIGO_DISCIPLINA){
            throw new Exception("O código deve ter "+ TAM_CODIGO_DISCIPLINA + "caracteres no formato XXX99999");
        }
        for (int i = 0 ; i < TAM_CODIGO_DISCIPLINA ; i++){
            char c = codigo.charAt(i);
            switch(i){
                case 0:
                case 1:
                case 2:
                    if(!Character.isUpperCase(c)){
                        throw new Exception("Na posição "+ (i+1) +" deve ser uma letra maiúscula");
                    }
                    break;
                default:
                    if(!Character.isDigit(c)){
                        throw new Exception("Na posição " + (i+1) + " deve ter um dígito!");
                    }
            }
        }
    }

    public static void validarNomeDisciplina(String nome) throws Exception{
        if(nome == null){
            throw new Exception("O nome não pode ser nulo!!");
        }
        if(nome.length() < 0 ||  nome.length() > TAM_MAX_NOME_DISCIPLINA){
            throw new Exception("Tamanho de nome inválido!!");
        }
        if(!nome.matches("^[a-zA-Z ]+$")){
            throw new Exception("Nome inválido!!");
        }
    }

    public static void validarNumCreditos(int creditos) throws Exception{
        if(creditos < TAM_MIN_CREDITOS){
            throw new Exception("Número mínimo de créditos é "+TAM_MIN_CREDITOS);
        }
        if(creditos > TAM_MAX_CREDITOS){
            throw new Exception("Número máximo de créditos é "+TAM_MAX_CREDITOS);
        }
    }
}
