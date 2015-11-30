import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(Parameterized.class)
public class TestNotification {
	public String videoname;
	public String description;
	public Long videoid;
	public TestNotification(String videoname,String description,Long videoid){
		this.videoname=videoname;
		this.description=description;
		this.videoid=videoid;
	}
	
	@Test(timeout=10000)
	public void actionsTest() throws InterruptedException, AWTException{
		NotificationDialog notif =new NotificationDialog(videoname,description,videoid,JFrame.class);
		FrameControll framecontroll=mock(FrameControll.class);
		notif.setFrameController(framecontroll);
		Robot emulator =new Robot();
		Rectangle rect = notif.getBounds();
		emulator.mouseMove(rect.x+rect.width/12*11, rect.y+(rect.height*19)/20);
		emulator.delay(500);
		emulator.mousePress(MouseEvent.BUTTON1_MASK);
		emulator.delay(50);
		emulator.mouseRelease(MouseEvent.BUTTON1_MASK);
		emulator.delay(100);
		verify(framecontroll).setCurrentFrame(JFrame.class, videoid);
	}
	@Test(timeout=10000)
	public void hideTest() throws AWTException{
		NotificationDialog notif =new NotificationDialog(videoname,description,videoid,JFrame.class);
		FrameControll framecontroll=mock(FrameControll.class);
		notif.setFrameController(framecontroll);
		Robot emulator =new Robot();
		Rectangle rect = notif.getBounds();
		emulator.mouseMove(rect.x+rect.width/11, rect.y+(rect.height*19)/20);
		emulator.delay(500);
		emulator.mousePress(MouseEvent.BUTTON1_MASK);
		emulator.delay(50);
		emulator.mouseRelease(MouseEvent.BUTTON1_MASK);
		emulator.delay(100);
		assertTrue(!notif.isVisible());
	}
	@Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
          return Arrays.asList(new Object[][]{
       		   {"Video", "First Training Group -- ведуща€ консалтингова€ компани€ в –оссии и —Ќ√ по разработке и внедрению системы KPI дл€ любых сфер бизнеса.—истема KPI от компании First Training Group - это: Х усиление конкурентных преимуществ ¬ашей компании и повышение удовлетворенности клиентов;Х увеличение выручки и оборота компании от 10% за счет концентрации внимани€ на клиентах;Х снижение затрат компании от 10--20%;Х многократное повышение производительности труда за счет увеличени€ мотивации персонала и повышени€ эффективности бизнес-процессов;Х в результате увеличение прибыли компании от 15% и выше.",new Long(145)}
       		   
       		   });
 }
}
//x=840
//y=405