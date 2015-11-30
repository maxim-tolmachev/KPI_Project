package Notification;
import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class NotificationDialog extends JFrame{
	private FrameControll framecontroll;
	private JFrame thisFrame=this;
	public NotificationDialog(String videoname,String videodescription,final long Videoid,final Class frameclass){
		setTitle("New video");
		setResizable(false);
		setAlwaysOnTop(true);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screenwidth = gd.getDisplayMode().getWidth();
		int screenheight = gd.getDisplayMode().getHeight();
		int width=400;
		int heigh=300;
		setBounds(screenwidth/2-width/2, screenheight/2-heigh/2, width, heigh);
		JPanel pane =new JPanel();
		pane.setLayout(new BorderLayout());
		setContentPane(pane);
		
		JButton ansverOk=new JButton("Ok");
		JButton ansverWatch=new JButton("Watch");
		ansverOk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				thisFrame.setVisible(false);
			}
		});
		ansverWatch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					thisFrame.setVisible(false);
					System.out.println("test");
					framecontroll.setCurrentFrame(frameclass,new Long(Videoid));			
			}
		});
		
		JPanel buttons=new JPanel(new BorderLayout());
		buttons.add(ansverOk,BorderLayout.WEST);
		buttons.add(ansverWatch,BorderLayout.EAST);
		
		add(buttons, BorderLayout.SOUTH);
		JLabel lable = new JLabel(videoname);
		lable.setHorizontalAlignment(JLabel.CENTER);
		add(lable,BorderLayout.NORTH);
		
		JTextArea text = new JTextArea(videodescription);
		text.setEditable(false);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		
		
		add(text,BorderLayout.CENTER);
		setVisible(true);
	}
	public void setFrameController(FrameControll a) {
		framecontroll=a;
	}
	

}
