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
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
    
	int x,y;
	int leftFlag;
	Image img,img1,img2,img3,img4,img5,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
		    img3=Image.createImage("/sayo16.png");

            img4=Image.createImage("/sayo02.png");
		    img5=Image.createImage("/sayo22.png");
        
			currentImg=img;
            x=120;
			y=100;
			leftFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(leftFlag==1){
			currentImg=img4;
            leftFlag++;
			}
            else if(leftFlag==2){
			currentImg=img5;
            leftFlag=1;
			}
            

			System.out.println("向左转");
			x=x-3;
			repaint();
		}
                     
		else if(action == UP){
		   currentImg=img2;
		   System.out.println("向上转");
           y=y-3;
		   repaint();
		}
		else if(action == RIGHT){
		   currentImg=img3;
		   System.out.println("向右转");
           x=x+3;
		   repaint();
		}
                               else {
		   currentImg=img;
		   System.out.println("向下转");
           y=y+3;
		   repaint();
		}
	}
}