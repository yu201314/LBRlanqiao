import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{

	/*
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int flag;
	Image heroImg[][]=new Image[4][3];
	Image bossImg;
	//4������ÿ������3��ͼƬ��0��ʾleft��1��ʾright��2��ʾup��3��ʾdown
	/*
	�����ά����
	*/

	Image currentImg;

	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];
			heroX=120;
			heroY=100;

			bossX=0;
			bossY=0;

			
			flag=1;
			
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	/*
	�ڶ��߳���дһ����ѭ������ͣ�ıȽ�boss��hero������
	*/
	public void run(){
		while(true){
			try
			{
				Thread.sleep(200);//FPS����Ļˢ����
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}

			if(bossY<heroY){
				bossY++;
			}else{
				bossY--;
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);//120��X���ꡢ100��Y����
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){
		    /*�����ĵ���
			 */
			changePicAndDirection(0);
			heroX=heroX-1;
		}
		if(action==UP){
			changePicAndDirection(2);
			heroY=heroY-1;
		}
		if(action==RIGHT){
			changePicAndDirection(1);
			heroX=heroX+1;
		}
		if(action==DOWN){
			changePicAndDirection(3);
			heroY=heroY+1;
		}
	}
	//�Զ��巽��:
	void changePicAndDirection(int direction){
	if(flag==1){
				currentImg=heroImg[direction][0];
				flag++;
			}
			else if(flag==2){
				currentImg=heroImg[direction][2];
				flag=1;
			}
	
	}
}