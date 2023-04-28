import java.text.DecimalFormat;
import java.util.ArrayList;

public class Funcionario {
	private int matricula;
	private String nome;
	private double salario;
	private double gratificacao;
	private ArrayList<Filhos> filhos;

	public Funcionario(int matricula, String nome, double salario, double gratificacao, ArrayList<Filhos> filhos) {
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario;
		this.gratificacao = gratificacao;
		this.filhos = filhos;

	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return formatName(nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getGratificacao() {
		return gratificacao;
	}

	public void setGratificacao(double gratificacao) {
		this.gratificacao = gratificacao;
	}
	
	public ArrayList<Filhos> getFilhos() {
		// TODO Auto-generated method stub
		return filhos;
	}

	public void setFilhos(ArrayList<Filhos> filhos) {
		this.filhos = filhos;
	}
	
	

	public String imprimirDadosFuncionario(String sequencia) {
		//decimal format faz com que os numeros possuam "R$ 1,000.00" essa formatação valor aleatorio no exemplo
	    DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00");
	    String mensagem = String.format("%s - %s - %s - %s\n", sequencia, getNome(), decimalFormat.format(getSalario()), decimalFormat.format(getGratificacao()));
	    							 //seq//nome//salario//gratificação
	    //caso não possua filhos irá retornar mensagem que não possui filhos como o padrão exigido
	    if (getFilhos().isEmpty()) {
	        mensagem += "                 <Sem filhos>\n";
	        //caso haja filhos ira passar por todos os filhos instanciando o metodo para getar filhos que esta sendo utilizado com arraylist na classe funcionario
	    } else {
	        for (Filhos filho : getFilhos()) {
	            mensagem += "                 " + String.format("%s - %s - %s\n", filho.getNome(), filho.getDataNasc(), filho.getSexo().equals("M") ? "Masculino" : "Feminino");
	        }
	    }
	    mensagem = "================================================================\n" + mensagem;
	    return mensagem;
	}
	
	
	// METODO QUE FORMATA NOME
	public static String formatName(String fullName) { 
		//utilizado string biulder somente para ter um retorno mais facilitado
	    StringBuilder sb = new StringBuilder();
	    //split usado com expressão regular para "dividir" o espaçamento entre as palavras
	    String[] names = fullName.split("\s+");

	    //percorre todo o array de nomes
	    for (String name : names) {
	    	//verifica se o nome esta vazio
	        if (!name.isEmpty()) {
	            sb.append(Character.toUpperCase(name.charAt(0)));
	            //caso possua mais de uma letra coloca o restante do nome minusculo
	            if (name.length() > 1) {
	                sb.append(name.substring(1).toLowerCase());
	            }
	            //armazenando os espaços entre cada nome e sobrenome
	            sb.append(" ");
	        }
	    }
	    //retornando oque foi salvo no string biulder e o transformando para String
	    return sb.toString();
	}
	

}