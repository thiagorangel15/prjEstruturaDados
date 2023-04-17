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

    public static void validarNome(String nome) throws Exception{
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

    public static void validarNumCreditosDisciplina(int creditos) throws Exception{
        if(creditos < TAM_MIN_CREDITOS){
            throw new Exception("Número mínimo de créditos é "+TAM_MIN_CREDITOS);
        }
        if(creditos > TAM_MAX_CREDITOS){
            throw new Exception("Número máximo de créditos é "+TAM_MAX_CREDITOS);
        }
    }

    public static void validarMatrFuncional(String matrFuncional) throws Exception{
        int m = Integer.parseInt(matrFuncional);
        for(int i = 0 ; i < matrFuncional.length() ; i++){
            char c = matrFuncional.charAt(i);
            if(!Character.isDigit(c)){
                throw new Exception("Foi encontrado uma letra na posição "+(i+1)+", matrícula só deve ter múmeros.");
            }
        }
        if(matrFuncional == null){
            throw new Exception("Matrícula Funcional não poder ser nula!!");
        }
        if(m < 1000 || m > 9999){
            throw new Exception("Matrícula Funcional deve possuir 4 dígitos");
        }
    }

    public static void validarTitulacao(String titulacao) throws Exception{
        if(titulacao == null){
            throw new Exception("Titulação não pode ser nulo!!");
        }
        if(titulacao != "Especialista" || titulacao != "Mestre" || titulacao != "Doutor"){
            throw new Exception("Titulação inválida!!");
        }

    }

    public static void validarMatriculaAluno(String matricula) throws Exception{
        if(matricula == null){
            throw new Exception("Matricula não pode ser nulo!!");
        }
        if(!matricula.matches("[0-9]{10}")){
            throw new Exception("Matrícula deve possuir apenas números e seu tamanho é de 10");
        }
    }

    public static void validarCodigoCurso(String codigo) throws Exception{
        if(!codigo.matches("[A-Z]{3}")){
            throw new Exception("Código de Curso deve possuir  3 caracteres maiúsculos");
        }
    }

    public static void validarTipoCurso(String tipo) throws Exception{
        if(tipo == null){
            throw new Exception("Tipo de curso não pode ser nulo!!");
        }
        if(tipo != "Curso Superior de Tecnologia" || tipo != "Bacharelado" || tipo != "Licenciatura"){
            throw new Exception("Tipo de curso inválido!!");
        }
    }

}
