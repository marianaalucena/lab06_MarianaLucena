package lab6_MarianaLucena;

public class Jogo {
	private String nome;
	private double preco;
	private int maiorScore;
	private int qntJogadas;
	private int qntConclusoes;
	
	public Jogo(String nome, double preco) throws Exception {
		if (nome == null || nome.trim().equals("")){
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}
		
		if (preco < 0){
			throw new Exception("Preco nao pode ser negativo");
		}
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qntJogadas = 0;
		this.qntConclusoes = 0;
		
	}
	
	public void registraJogadas(int score, boolean zerou){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getQntJogadas() {
		return qntJogadas;
	}

	public void setQntJogadas(int qntJogadas) {
		this.qntJogadas = qntJogadas;
	}

	public int getQntConclusoes() {
		return qntConclusoes;
	}

	public void setQntConclusoes(int qntConclusoes) {
		this.qntConclusoes = qntConclusoes;
	}
	

}
