package joquempo.domain;

public class Joquempo {

	private String _ultimaJogada = "";
	private int _jogadas;
	private int vitorias;

	public String relatorio() {
		return resultado() + " - " + getQuantidadeVitorias() + " vitorias";
	}
	
	public String resultado() {
		if(isPedra()) return "empate";
		if(isTesoura()) return "perdeu";
		
		return "venceu"; 
	}

	private boolean isTesoura() {
		return _ultimaJogada.equals("tesoura");
	}

	private boolean isPedra() {
		return _ultimaJogada.equals("pedra");
	}

	public void setUltimaJogada(String ultimaJogada) {
		_ultimaJogada = ultimaJogada;
		_jogadas++;
		if(resultado().equals("venceu"))
			vitorias++;
	}

	public int getQuantidadeVitorias() {
		return vitorias;
	}

}
