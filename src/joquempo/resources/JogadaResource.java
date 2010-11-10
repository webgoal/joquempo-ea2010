package joquempo.resources;

import joquempo.domain.Joquempo;
import httprevayler.BaseResource;
import static sneer.foundation.environments.Environments.my;

public class JogadaResource extends BaseResource {

	@Override
	protected Object doGet() throws Exception {
		return my(Joquempo.class).relatorio();
	}
	
	@Override
	protected void doPost() throws Exception {
		my(Joquempo.class).setUltimaJogada(_request.getParameter("jogada"));
	}

}
