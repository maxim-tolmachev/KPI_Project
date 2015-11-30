package vk;

import java.io.IOException;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class AutorizatorViev extends JFXPanel{
	private WebView webView;
	private AutorithtionListener autor;
	public AutorizatorViev() throws IOException{
		final AutorizatorViev as=this;
		Platform.runLater(new Runnable() {
			public void run() {
				webView = new WebView();
				as.setScene(new Scene(webView));
				
				webView.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {

					public void changed(ObservableValue arg0,
							State arg1, State arg2) {
						if(arg0.getValue().toString()=="SUCCEEDED"&&(webView.getEngine().getLocation().contains("https://oauth.vk.com/blank.html#access_token="))){	
							VKInfo currentuser=new VKInfo(webView.getEngine().getLocation().substring("https://oauth.vk.com/blank.html#".length()));
							autor.OnAutorithtion(currentuser);
						}
					}
				});
				webView.getEngine().load("https://oauth.vk.com/authorize?client_id=5155759&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=token&v=5.40");
				
			}
		});
		
	}
	public void addOnAutorithtionListener(AutorithtionListener a){
		autor=a;
	}	
}
