package joquempo.client;

import java.util.HashMap;
import java.util.Map;

import wg.gwt.utils.httprevayler.client.SimpleRequest;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class JoquempoClient implements EntryPoint {

	private TextBox jogadorTextBox = new TextBox();
	private Image pedraImage = new Image("/images/pedra.gif");
	private Image papelImage = new Image("/images/papel.gif");
	private Image tesouraImage = new Image("/images/tesoura.gif");
	private Label situacaoLabel = new Label();

	@Override
	public void onModuleLoad() {
		RootPanel.get("jogadorContainer").add(jogadorTextBox);
		RootPanel.get("acoesContainer").add(pedraImage);
		RootPanel.get("acoesContainer").add(papelImage);
		RootPanel.get("acoesContainer").add(tesouraImage);
		RootPanel.get("situacaoContainer").add(situacaoLabel);

		pedraImage.addClickHandler(joquempoHandler("pedra"));
		papelImage.addClickHandler(joquempoHandler("papel"));
		tesouraImage.addClickHandler(joquempoHandler("tesoura"));
		
	}

	private ClickHandler joquempoHandler(final String jogada) {
		return new ClickHandler() { @Override public void onClick(ClickEvent event) {
			if (jogadorTextBox.getText().isEmpty()) {
				Window.alert("Preencha seu nome!");
				return;
			}
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("jogador", jogadorTextBox.getText());
			params.put("jogada", jogada);
			new SimpleRequest("jogada", RequestBuilder.POST, params) { @Override public void onResponseReceived() {
				updateSituacao();
			}};
		}};
	}

	protected void updateSituacao() {
		new SimpleRequest("jogada", RequestBuilder.GET, null) { @Override public void onResponseReceived(String response) {
			situacaoLabel.setText(response);
		}};
	}
}
