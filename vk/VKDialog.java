package vk;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VKDialog extends JFrame{
	public void showDialog(final AutorithtionListener a) throws IOException{
			JPanel mainpanel=new JPanel();
			setBounds(100, 100, 800, 600);
			setResizable(false);
			setTitle("Vk authorization");
			setAlwaysOnTop(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setContentPane(mainpanel);
			AutorizatorViev testVk= new AutorizatorViev();
			testVk.addOnAutorithtionListener(new AutorithtionListener() {
				public void OnAutorithtion(VKInfo autordata) {
					a.OnAutorithtion(autordata);
					setVisible(false);
				}
			});
			mainpanel.add(testVk);
			setVisible(true);
		}
	}

