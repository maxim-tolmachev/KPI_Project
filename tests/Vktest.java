package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.sun.glass.events.KeyEvent;

import vk.AutorithtionListener;
import vk.VKDialog;
import vk.VKInfo;
@RunWith(Parameterized.class)
public class Vktest {
	 static long id;
	 static String username;
	 static String password;
	 static long idtocheck=-1;
	 public Vktest(long id,String username,String password){
		this.id=id;
		this.username=username;
		this.password=password;
	}
	public static void manipulation(Rectangle rectangle) throws InterruptedException, AWTException{
		Robot test=new Robot();
		test.delay(1000);
		while (test.getPixelColor(rectangle.x+361,(int) rectangle.y+127).equals(new Color(89,123,165))) {
			test.delay(1500);
			System.out.println(test.getPixelColor(rectangle.x+361,(int) rectangle.y+127));
		}
		test.delay(1000);
		test.mouseMove(495,395);
		test.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		test.setAutoDelay(100);
		for (int i = 0; i <username.length() ; i++) {
			if(username.charAt(i)=='@'){
				test.keyPress(KeyEvent.VK_SHIFT);
				test.keyPress(KeyEvent.getKeyCodeForChar(username.charAt(i)));
				test.keyRelease(KeyEvent.getKeyCodeForChar(username.charAt(i)));
				test.keyRelease(KeyEvent.VK_SHIFT);
			}else{
				test.keyPress(KeyEvent.getKeyCodeForChar(username.charAt(i)));
				test.keyRelease(KeyEvent.getKeyCodeForChar(username.charAt(i)));
			}
		}
		test.delay(500);
		test.mouseMove(495,459);
		test.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		for (int i = 0; i <password.length() ; i++) {		
			test.keyPress(KeyEvent.getKeyCodeForChar(password.charAt(i)));
		}
		test.delay(500);
		test.mouseMove(495,505);
		test.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		test.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
	}
	@Test(timeout=20000) 
	public void VKAutorTest() throws IOException, InterruptedException, AWTException {
		VKDialog a=new VKDialog();
		a.showDialog(new AutorithtionListener() {
			
			public void OnAutorithtion(VKInfo currentuser) {
				idtocheck=currentuser.getId();	
			}
		});
		a.setBounds(100, 100, 800, 600);
		manipulation(a.getBounds());
		while(idtocheck==-1){
			Thread.sleep(200);
		}
		assertTrue("Полученый id (" + idtocheck + ") не равен "+id,id==idtocheck);
	}
	 @Parameterized.Parameters
     public static Collection<Object[]> getTestData() {
           return Arrays.asList(new Object[][]{
        		   {1418425L,"examplemail@example.example","example"}
        		   
        		   });
  }

}
