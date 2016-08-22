package Jogo;

import java.util.HashSet;

public abstract class Jogo {
	protected String nome;
	protected double preco;
	protected int maiorScore;
	protected int qntJogadas;
	protected int qntConclusoes;
	protected HashSet<Jogabilidade> jogabilidade;
	protected String tipo = null;
	
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
	
	public abstract int registraJogadas(int score, boolean zerou);
	
	public void addJogabilidade(Jogabilidade jogabilidade){
		this.jogabilidade.add(jogabilidade);
	}
	
	public void removeJogabilidade(Jogabilidade jogabilidade){
		this.jogabilidade.remove(jogabilidade);
	}
	
	public HashSet<Jogabilidade> getJogabilidade(){
		return jogabilidade;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setJogabilidade(HashSet<Jogabilidade> jogabilidade){
		this.jogabilidade = jogabilidade;
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

	public void setQntJogadas() {
		this.qntJogadas += 1;
	}

	public int getQntConclusoes() {
		return qntConclusoes;
	}

	public void setQntConclusoes() {
		this.qntConclusoes += 1;
	}
	
	public String toString(){
		String retorno = "+" + getNome() + "-" + getTipo() + ":";
		retorno += "==> Jogou" + getQntJogadas() + "vez(es)";
		retorno += "==> Zerou" + getQntConclusoes() + "vez(es)";
		retorno += "==> Maior score:" + getMaiorScore();
		return retorno;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidade == null) ? 0 : jogabilidade.hashCode());
		result = prime * result + maiorScore;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qntConclusoes;
		result = prime * result + qntJogadas;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (jogabilidade == null) {
			if (other.jogabilidade != null)
				return false;
		} else if (!jogabilidade.equals(other.jogabilidade))
			return false;
		if (maiorScore != other.maiorScore)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (qntConclusoes != other.qntConclusoes)
			return false;
		if (qntJogadas != other.qntJogadas)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
