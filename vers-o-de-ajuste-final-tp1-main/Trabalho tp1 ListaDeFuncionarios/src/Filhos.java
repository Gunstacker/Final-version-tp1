import java.time.LocalDate;

public class Filhos {
	private String nome;
	private String dataNasc;
	private String sexo;

	public Filhos(String nome, String dataNasc, String sexo) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
	}

	public String getNome() {
		//chamando a classe Funcionario para usar o metodo ja criado em funcionario para formatar nome
		return Funcionario.formatName(nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		//chamando o metodo formatar data para alcançar o padrão exigido
		return formatarData(dataNasc);
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	//metodo que formata data
	public static String formatarData(String data) {
	    String dia = data.substring(0, 2);
	    String mes = data.substring(2, 4);
	    String ano = data.substring(4, 8);
	    return dia + "/" + mes + "/" + ano;
	}

}