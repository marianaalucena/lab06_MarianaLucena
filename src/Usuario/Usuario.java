package Usuario;

import java.util.HashSet;

import Jogo.FactoryJogo;
import Jogo.Jogo;

public abstract class Usuario {
	protected String nome;
	protected String username;
	protected double saldo;
	protected int x2p;
	protected HashSet<Jogo> jogos;
	protected FactoryJogo factoryJogo;
	protected String tipo = null;
	protected final String QUEBRA_LINHA = System.lineSeparator();

	public Usuario(String nome, String username) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}

		if (username == null || username.trim().equals("")) {
			throw new Exception("Username nao pode ser nulo ou vazio");
		}

		this.nome = nome;
		this.username = username;
		this.jogos = new HashSet<>();
		
	}

	public abstract boolean compraJogos(Jogo jogo);
	
	public abstract boolean compraJogos(String nome, double preco, String tipo) throws Exception;

	public void addDinheiro(double valor) throws Exception {
		if(valor < 0){
			throw new Exception("Valor negativo nao eh permitido.");
		}
		setSaldo(valor);
	}
	
	public boolean registraJogada(String nomeDoJogo, int score, boolean zerou){
		for (Jogo jogo : jogos) {
			if(nomeDoJogo.equalsIgnoreCase(jogo.getNome())){
				int x2pJogada = jogo.registraJogadas(score, zerou);
				this.x2p += x2pJogada;
				return true;
			}
		} return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getSaldo() {
		return saldo;
	}

	public void compraJogo(double valorJogoComDesconto) {
		this.saldo -= valorJogoComDesconto;
	}

	public void setSaldo(double valor) throws Exception {
		if(valor < 0){
			throw new Exception("Valor negativo nao eh permitido");
		}
		this.saldo += valor;
	}

	public HashSet<Jogo> getJogos() {
		return jogos;
	}
	
	public void setJogos(HashSet<Jogo> jogos){
		this.jogos = jogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	public String toString(){
		String retorno = getUsername() + QUEBRA_LINHA + getNome() + " - Jogador " + getTipo() + QUEBRA_LINHA + "Lista de Jogos:";
		double valorTotal = 0.0;
		for (Jogo jogo : jogos) {
			retorno += jogo.toString();
			valorTotal += jogo.getPreco();
		} retorno += QUEBRA_LINHA + "Total de jogos: R$ " + valorTotal;
		return retorno;		
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
}
