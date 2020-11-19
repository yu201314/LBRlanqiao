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
class MainCanvas extends Canvas
{

	/*
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
    
	int x,y;
	int leftFlag,rightFlag,upFlag,downFlag;
	Image img,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,currentImg;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
			*/
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
		    img3=Image.createImage("/sayo16.png");

            img4=Image.createImage("/sayo02.png");
		    img5=Image.createImage("/sayo22.png");

            img6=Image.createImage("/sayo06.png");
		    img7=Image.createImage("/sayo26.png");

		    img8=Image.createImage("/sayo04.png");
		    img9=Image.createImage("/sayo24.png");

		    img10=Image.createImage("/sayo00.png");
		    img11=Image.createImage("/sayo20.png");
        
			currentImg=img;
            x=120;
			y=100;
			leftFlag=1;
            rightFlag=1;
            upFlag=1;
            downFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120��X���ꡢ100��Y����
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){
			/*
			ʵ��ת�����
			*/
			/*
			���������¸�ֵ����
			*/
			if(leftFlag==1){
			currentImg=img4;
            leftFlag++;
			}
            else if(leftFlag==2){
			currentImg=img5;
            leftFlag=1;
			}
          
			System.out.println("����ת");
			x=x-3;
			repaint();
		}
                     
		else if(action == UP){
		
		  if(upFlag==1){
			currentImg=img8;
            upFlag++;
			}
            else if(upFlag==2){
			currentImg=img9;
            upFlag=1;
			}
            
		   System.out.println("����ת");
           y=y-3;
		   repaint();
		}
		else if(action == RIGHT){
		
			if(rightFlag==1){
			currentImg=img6;
            rightFlag++;
			}
            else if(rightFlag==2){
			currentImg=img7;
            rightFlag=1;
			}
            
		   System.out.println("����ת");
           x=x+3;
		   repaint();
		}
         else {
		   if(downFlag==1){
			currentImg=img10;
            downFlag++;
			}
            else if(downFlag==2){
			currentImg=img11;
            downFlag=1;
			}
		   System.out.println("����ת");
           y=y+3;
		   repaint();
		}
	}
}