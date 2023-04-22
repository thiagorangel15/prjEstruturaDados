package model;

import java.io.Serializable;

public class Pessoa implements Serializable { // o extends Object é desnecessário...

    final public static int TAM_MAX_NOME = 40;
    final public static int TAM_CPF      = 14;
    final public static int MIN_IDADE    = 0;
    final public static int MAX_IDADE    = 130;
    final public static int NUM_MAX_PESSOAS = 10;
    
    private static Pessoa[] listaPessoas = new Pessoa[Pessoa.NUM_MAX_PESSOAS];
    private static int numPessoas = 0;

    //---------------------------------------------------
    // DECLARAÇÃO DOS ATRIBUTOS DA CLASSE PESSOA
    //---------------------------------------------------
    /**
     * Referência para a String cpf do objeto Pessoa
     */
    private String cpf;
    /**
     * Referência para a String nome do objeto Pessoa
     */
    private String nome;
    /**
     * Valor da idade do objeto Pessoa
     */
    private int idade;

    //---------------------------------------------------
    // DECLARAÇÃO DOS MÉTODOS DA CLASSE PESSOA
    //---------------------------------------------------

    /**
     * Método Construtor: promove a inicialização do novo objeto
     *
     * @param c referência para o cpf do novo objeto Pessoa
     * @param n referência para o nome do novo objeto Pessoa
     * @param i valor para a idade do novo objeto Pessoa
     */
    public Pessoa(String c, String n, int i) throws Exception {
        this.setCpf(c);
        this.setNome(n);
        this.setIdade(i);
        
        Pessoa.listaPessoas[Pessoa.numPessoas++] = this;
    }
    public static int getNumPessoas() {
		return Pessoa.numPessoas;
	}
	
	/**
	 * Retorna a lista de pessoas
	 * @return
	 */
	public static Pessoa[] getListaPessoas() {
		return Pessoa.listaPessoas;
	}
	
	/**
	 * Atualiza a lista de pessoas
	 * @return
	 */
	public static void setListaPessoas(Pessoa[] novaLista) {
		Pessoa.listaPessoas = novaLista;
		
		for(int i = 0; i < Pessoa.NUM_MAX_PESSOAS; i++) {
			if(Pessoa.listaPessoas[i] != null)
				System.out.println(Pessoa.listaPessoas[i]);
			else {
				Pessoa.numPessoas = i;
				break;
			}
		}
	}

    /**
     * Obtem o estado do atributo cpf do objeto Pessoa
     *
     * @return
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Altera o estado do atributo cpf do objeto Pessoa
     *
     * @param c
     */
    public void setCpf(String c) throws Exception {
        Pessoa.validarCpf(c);
        this.cpf = c;
    }

    /**
     * Obtem o estado do atributo nome do objeto Pessoa
     *
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Altera o estado do atributo nome do objeto Pessoa
     *
     * @param n
     */
    public void setNome(String n) throws Exception {
        Pessoa.validarNome(n);
        this.nome = n;
    }

    /**
     * Obtem o valor do atributo idade do objeto Pessoa
     *
     * @return
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * Altera o estado do atributo idade do objeto Pessoa
     *
     * @param i
     */
    public void setIdade(int i) throws Exception {
        Pessoa.validarIdade(i);
        this.idade = i;
    }

    /**
     * Redefinição (overriding) do método toString()
     */
    public String toString() {
        String resultado = "Meu nome é " + this.nome;
        resultado += ", eu tenho " + this.idade + " anos";
        resultado += " e meu cpf é " + this.cpf;

        return resultado;
    }

    /**
     * Método para validação se o valor pode ser atribuído a um cpf
     * @param valor
     * @return
     */
    public static void validarCpf(String valor) throws Exception {
        // Se a referência para a String 'valor' for nula
        if (valor == null)
            throw new Exception("O cpf não pode ser nulo!");
        // Se a String 'valor' não tiver 14 caracteres
        if (valor.length() != TAM_CPF)
            throw new Exception("O cpf deve ter " + TAM_CPF + " caracteres no formato 999.999.999-99!");
        // 'for' para verificar caracter a caracter da String recebida
        for (int i = 0; i < TAM_CPF; i++) {
            // recupero o caracter da posição 'i' da String 'valor'
            char c = valor.charAt(i);
            switch(i) {
                // Verificando se na posição 3 e 7 temos o caracter '.'
                case  3:
                case  7:
                    if(c != '.')
                        throw new Exception("Na posição " + (i+1) + " deve constar '.', pois o cpf deve ter 14 caracteres no formato 999.999.999-99!");
                    break;

                // Verificando se na posição 11 temos o caracter '-'
                case 11:
                    if(c != '-')
                        throw new Exception("Na posição " + (i+1) + " deve constar '-', pois o cpf deve ter 14 caracteres no formato 999.999.999-99!");
                    break;
                default:
                    if(!Character.isDigit(c))
                        throw new Exception("Na posição " + (i+1) + " deve ter um dígito!");;
            }
        }
    }

    /**
     * Método para validação se o valor pode ser atribuído a um nome
     * @param valor
     * @return
     */
    public static void validarNome(String valor) throws Exception {
        // Se a referência para a String 'valor' for nula
        if(valor == null || valor.length() == 0)
            throw new Exception("O nome não pode ser nulo!");
        // Se a String 'valor' tiver mais que 40 caracteres
        if(valor.length() > TAM_MAX_NOME)
            throw new Exception("O nome não pode ter mais que " + TAM_MAX_NOME + " caracteres!");
        for(int i = 0; i < valor.length(); i++) {
            // recupero o caracter da posição 'i' da String 'valor'
            char c = valor.charAt(i);
            if(!Character.isAlphabetic(c) && !Character.isWhitespace(c))
                throw new Exception("O caracter na posição " + (i+1) + " é inválido para o nome!");
        }
    }
    /**
     * Método para validação se o valor pode ser atribuído a uma idade
     * @param valor
     * @return
     */
    public static void validarIdade(int valor) throws Exception {
        if (valor < MIN_IDADE || valor > MAX_IDADE)
            throw new Exception("A idade precisa ser um valor entre " + MIN_IDADE + " e " + MAX_IDADE +"!");
    }
}