package testes;

import joquempo.domain.Joquempo;

import org.junit.Assert;
import org.junit.Test;

public class JoquempoTest extends Assert {

	private final Joquempo joquempo = new Joquempo();

	private void verificarJogada(String jogada, String resultadoEsperado) {
		joquempo.setUltimaJogada(jogada);
		assertEquals(resultadoEsperado, joquempo.resultado());
	}
	
	@Test public void adversarioSohJogaPedra() {
		verificarJogada("papel", "venceu");
		verificarJogada("pedra", "empate");
		verificarJogada("tesoura", "perdeu");
	}
	
	@Test public void historicoDeVitorias()
	{
		assertEquals(0, joquempo.getQuantidadeVitorias());		
		joquempo.setUltimaJogada("papel");
		assertEquals(1, joquempo.getQuantidadeVitorias());	
		joquempo.setUltimaJogada("pedra");
		assertEquals(1,joquempo.getQuantidadeVitorias());
		joquempo.setUltimaJogada("tesoura");
		assertEquals(1, joquempo.getQuantidadeVitorias());
		joquempo.setUltimaJogada("papel");
		assertEquals(2, joquempo.getQuantidadeVitorias());	
	}
	
	@Test public void retornaNumeroDeVitorias(){
		joquempo.setUltimaJogada("papel");
		assertEquals("venceu - 1 vitorias", joquempo.relatorio());
	}
	
}

