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
       		   {"Video", "First Training Group -- ������� �������������� �������� � ������ � ��� �� ���������� � ��������� ������� KPI ��� ����� ���� �������.������� KPI �� �������� First Training Group - ���: � �������� ������������ ����������� ����� �������� � ��������� ����������������� ��������;� ���������� ������� � ������� �������� �� 10% �� ���� ������������ �������� �� ��������;� �������� ������ �������� �� 10--20%;� ������������ ��������� ������������������ ����� �� ���� ���������� ��������� ��������� � ��������� ������������� ������-���������;� � ���������� ���������� ������� �������� �� 15% � ����.",new Long(145)}
       		   
       		   });
 }
}
//x=840
//y=405