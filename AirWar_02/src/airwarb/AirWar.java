package airwarb;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AirWar extends JPanel {
    Image map   = GetImage.getImage("images/C4-1.png");
    Image hero  = GetImage.getImage("images/hero.png");
    Image E     = GetImage.getImage("images/ep_1.png");
    Image B     = GetImage.getImage("images/myb_1.png");
    Image EB2   = GetImage.getImage("images/epb_1.png");
    Image BZ1   = GetImage.getImage("images/z01.jpg");
    Image BZ2   = GetImage.getImage("images/z02.jpg");
    Image BZ3   = GetImage.getImage("images/z03.jpg");
    Image BZ4   = GetImage.getImage("images/z04.jpg");
    Image BZw1  = GetImage.getImage("images/zw01.jpg");
    Image BZw2  = GetImage.getImage("images/zw02.jpg");
    Image BZw3  = GetImage.getImage("images/zw03.jpg");
    Image BZw4  = GetImage.getImage("images/zw04.jpg");
    Image BZZ1  = GetImage.getImage("images/BZZ1.png");
    Image BZZ2  = GetImage.getImage("images/BZZ2.png");
    Image BZZ3  = GetImage.getImage("images/BZZ3.png");
    Image XBOSS = GetImage.getImage("images/XBOSS.png");
    Image XBOBT = GetImage.getImage("images/xbb.png");
    Image WIN = GetImage.getImage("images/SL.png");
   	static int WIDTH = 400; // ����
    static int HEIGHT = 654; // ����
    static Play play = new Play();
    static Vector<Enemy>     enemys = new Vector<Enemy>();
    static Vector<Bullet>   Bullets = new Vector<Bullet>();
    static Vector<Bullet2> Bullet2s = new Vector<Bullet2>();
    static Vector<Bullet3> Bullet3s = new Vector<Bullet3>();
    static Vector<Baozha>   baozhas = new Vector<Baozha>();
    static Vector<Baozha>  baozhas2 = new Vector<Baozha>();
    static Vector<Baozha>  baozhas3 = new Vector<Baozha>();
    static Vector<EB>           EBs = new Vector<EB>();
    static Vector<XBOB>        BOBs = new Vector<XBOB>();
    static Vector<XBOSS>     XBOSSs = new Vector<XBOSS>();
    static boolean left, right, up, down,re = false,zd= false,sw=false,shoot = false,BOSS = false;
    static int zd1=-3,mapY=-3100;
    static short mapX=0,KB = 1,kb=1,boss=1;
    public void paint(Graphics g) {
    	g.drawImage(map, mapX, mapY, null); // ������ͼ
        if(zd1==1)//��д
        paintP(g); // ��Ӣ�ۻ�
        paintB(g); // ���ӵ�
        paintB2(g);//���ӵ�2
        paintB3(g);//���ӵ�3
        paintEB(g);//���о��ӵ�
        paintE(g); // ���о�
        paintXBOSS(g);//��BOSS
        paintBOB(g);//��BOSS�ӵ�
        paintBz(g);//����ը
        paintBOSSHP(g);//��BOSSѪ��ֵ
        paintGO2(g);//��������Ϸ�ı�
        paintGO(g);//�������Ϣ
        paintWINGO2(g);//��ʤ����ʾ�ı�
    	}
     // ��Ӣ�ۻ�
    void paintP(Graphics g) {
        g.drawImage(hero, play.PlayX, play.PlayY, 50, 50, null);
    }
     //�����Ӣ�ۻ��ӵ�1
    void paintB(Graphics g) {
        for (int i = 0; i < Bullets.size(); i++) {
            Bullet f = Bullets.get(i);
            g.drawImage(B, f.x, f.y, 50, 50, null);
        }
    }
    //�����Ӣ�ۻ��ӵ�2
    void paintB2(Graphics g) {
        for (int i = 0; i < Bullet2s.size(); i++) {
            Bullet2 f = Bullet2s.get(i);
            g.drawImage(B, f.x2, f.y2, 50, 50, null);
        }
    }
    //�����Ӣ�ۻ��ӵ�3
    void paintB3(Graphics g) {
        for (int i = 0; i < Bullet3s.size(); i++) {
            Bullet3 f = Bullet3s.get(i);
            g.drawImage(B, f.x3, f.y3, 50, 50, null);
        }
    }
    //���о��ӵ�
    void paintEB(Graphics g) {
        for (int i = 0; i < EBs.size(); i++) {
            EB f = EBs.get(i);
            if(zd1==1)
            g.drawImage(EB2, f.x, f.y, f.width, f.height, null);
            EBP(f);//�о��ӵ������Ӣ�ۻ�������ײ��Ѫ�ж����β�����Ϊ�о��ӵ�����
        }  
    }
    //��BOSS�ӵ�
    void paintBOB(Graphics g) {
        for (int i = 0; i < BOBs.size(); i++) {
            XBOB f = BOBs.get(i);
            g.drawImage(XBOBT, f.x, f.y, f.width, f.height, null);
            
            
            EBP(f);//BOSS�ӵ������Ӣ�ۻ�������ײ��Ѫ�ж����β�����ΪBOSS�ӵ�����
        }  
    }

    //�����ֱ�ըЧ��
    void paintBz(Graphics g) {
        for (int i = 0; i < baozhas.size(); i++) {
            Baozha f = baozhas.get(i);
           f.sj++;  //�ӳټ���
           if(f.sj<10)//�����ж�
            g.drawImage(BZ1, f.x, f.y, f.width, f.width, null);//ʡ��{}
           if(f.sj<20&&f.sj>10)//�����ж�
        	   g.drawImage(BZ2, f.x, f.y, f.width, f.width, null);//ʡ��{}
           if(f.sj<30&&f.sj>20)//�����ж�
        	   g.drawImage(BZ3, f.x, f.y, f.width, f.width, null);//ʡ��{}
           if(f.sj<40&&f.sj>30)//�����ж�
        	   g.drawImage(BZ4, f.x, f.y, f.width, f.width, null);//ʡ��{}
           
           if(f.sj==40)//�����ж�
             baozhas.remove(i);//��ը����     ʡ��{}
        }
        
        for (int i = 0; i < baozhas2.size(); i++) {
            Baozha f = baozhas2.get(i);
           f.sj++;//�ӳټ���
           if(f.sj<10)//�����ж�
            g.drawImage(BZw1, f.x, f.y, 100, 100, null);//ʡ��{}
           if(f.sj<20&&f.sj>10)//�����ж�
        	   g.drawImage(BZw2, f.x, f.y, 100, 100, null);//ʡ��{}
           if(f.sj<30&&f.sj>20)//�����ж�
        	   g.drawImage(BZw3, f.x, f.y, 100, 100, null);//ʡ��{}
           if(f.sj<40&&f.sj>30)//�����ж�
        	   g.drawImage(BZw4, f.x, f.y, 100, 100, null);//ʡ��{}
           if(f.sj==40) //�����ж�
        	   baozhas2.remove(i);//��ը����     ʡ��{}
        }
        
        for (int i = 0; i < baozhas3.size(); i++) {
            Baozha f = baozhas3.get(i);
           f.sj++;//�ӳټ���
           if(f.sj<10&&f.sj>0)//�����ж�
        	   g.drawImage(BZZ3, f.x+f.width/4, f.y+f.height/4, f.width/2,  f.height/2, null);//ʡ��{}
           
           if(f.sj==10)//�����ж�
             baozhas3.remove(i);//��ը����     ʡ��{}
            

        }
        
        
    }
    
 
    // ���л�
    void paintE(Graphics g) {
        for (int i = 0; i < enemys.size(); i++) {
            Enemy f = enemys.get(i);
            g.drawImage(E, f.x, f.y, f.width, f.height, null);
        }
       
    }
    //��BOSS
    void paintXBOSS(Graphics g) {
        for (int i = 0; i < XBOSSs.size(); i++) {
        	XBOSS f = XBOSSs.get(i);
            g.drawImage(XBOSS, f.x, f.y, f.width, f.height, null);
        }
       
    }
    //�������Ϣ
    void paintGO(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.drawString("ʣ������ֵ��" + play.life, 20, 60);
        g.drawString("���ķ���Ϊ��" + play.score, 20, 40);
        g.drawString("�񱩼���Ϊ��" + KB, 20, 80);
      
        g.setColor(c);
    }
    //��BOSSѪ��
    void paintBOSSHP(Graphics g) {
    	 Color c = g.getColor();
         g.setColor(Color.red);
    	for(int i = 0; i < XBOSSs.size(); i++){
    		XBOSS f = XBOSSs.get(i);
    		if(boss==2)
            g.drawString("BOSSѪ��Ϊ��" + f.life, 20, 100);
    } 	
    	 g.setColor(c);
    }
    //�������ı�
    void paintGO2(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        if(zd1==-1){
        g.drawString("��Ϸ�������ķ���Ϊ��" + play.score+"" ,150, 325  );
        g.drawString("������Ϸ�밴R��" ,160, 355  );
        }
        
        if(zd1==-3||zd1==0){
        	g.drawString("�밴Enter����ʼ��Ϸ" ,150, 325  );
        	EBs.removeAll(EBs);
        	if(re==true)
        		zd1=1;
        }
        
        g.setColor(c);
    }
    //��ʤ����ʾ�ı�
    void paintWINGO2(Graphics g) {
    	if(mapY>-340&&mapY<-305)
    	g.drawImage(WIN, 100, 305, 200, 60, null);
        Color c = g.getColor();
        g.setColor(Color.red);
        if(boss==3){
     	   g.drawString("��ʤ����" , 168, 355);
     	   g.drawString("������Ϸ�밴R��" ,150, 335  );
//     	   g.drawImage(WIN, 100, 355, 226, 62, null);
        }
        g.setColor(c);
    }
    
    
    Run run = new Run();
//    Run2 run2 = new Run2();
    Run3 run3 = new Run3();
    Run4 run4 = new Run4();
    Run5 run5 = new Run5();
    Run6 run6 = new Run6();
    Run7 run7 = new Run7();
    
    public static void main(String[] args) {//������
        AirWar jp1 = new AirWar(); //���������Ϸ���
        JFrame frame = new JFrame("AirWar          by:zyp");//����
        JPanel jp = new JPanel();//�������
        Button a1 = new Button("Start Game");//���尴ť
//        Button a2 = new Button("��Ϸ����");//���尴ť
//        Button a3 = new Button("��Ϸ����");//���尴ť
        Button a4 = new Button("Close the game");//���尴ť
        jp.setLayout(null);//���ò���
        jp1.setLayout(null);//���ò���
        a1.setBounds(148, 370, 100, 40);//���ð�ťλ��
//        a2.setBounds(148, 420, 100, 40);//���ð�ťλ��
//        a3.setBounds(148, 470, 100, 40);//���ð�ťλ��
        a4.setBounds(148, 520, 100, 40);//���ð�ťλ��
        
        a1.addActionListener(new ActionListener() {//a1��ť�����Ϊ������
            @Override
            public void actionPerformed(ActionEvent e) {//�����¼�
                jp1.addKeyListener(new listener());//��Ϸ�����Ӽ��̼�����
                jp.setVisible(false);//���������������
                jp1.setVisible(true);//��Ϸ���������ʾ
                frame.getContentPane().add(jp1);//����Ϸ���������������������
                jp1.requestFocus();//��Ϸ����ý���
                jp1.action();//��Ϸ���ִ�з���action
            }
        });
        a4.addActionListener(new ActionListener() {//a4��ť�����Ϊ������
            @Override
            public void actionPerformed(ActionEvent e) {//�����¼�
                System.exit(0);//�˳�
            }
        });
        jp.add(a1);//���������Ӱ�ť1
//        jp.add(a2);//���������Ӱ�ť2
//        jp.add(a3);//���������Ӱ�ť3
        jp.add(a4);//���������Ӱ�ť4
        frame.getContentPane().add(jp);//������������������
        frame.setSize(WIDTH, HEIGHT); // �����������С
        frame.setAlwaysOnTop(true); // ���������嶥��
        frame.setDefaultCloseOperation(3); // ����������Ĭ�Ϲر�     3�� ��JFrame.EXIT_ON_CLOSE
        frame.setLocationRelativeTo(null); // �����޴����ʼλ��
        frame.setResizable(false);//���ô���ߴ粻�ɸı�
        frame.setVisible(true);//���ô���ɼ�
    }
       void action() {//��Ϸ�����Ϊ����
         run5.start();
//         run1.start();
//         run2.start();
         run3.start();
         run4.start();
         run.start();
         run6.start();
         run7.start();
    }


 class Run extends Thread {   //�߳�1
        public void run() {
            while (true) {
            	 
                  // �ƶ����о����о��ӵ���BOSS��BOSS�ӵ�
//                System.out.println(mapY);  
                if(zd1==1&&boss!=2){ //��Ϸ״̬Ϊ1������boss�����ڣ�ִ��
                if(mapY<0){  //��ͼYֵС��0
                mapY++; //��ͼYֵ+1
              
                if(mapY==-303){//��ͼYֵΪ-303  
                	mapY++;//��
                 		do{
               		   XBOSS x=new XBOSS();//ˢһֻBOSS
                         XBOSSs.add(x);
                         boss=2;//BOSS״̬Ϊ����
                 		}while(false);
                
                }
               
                }
                
                
                }
                try {
                    Thread.sleep(20);//�ӳ�
                } catch (InterruptedException e) {//�쳣����
                    e.printStackTrace();
                }
            }
        }
    }

 class Run7 extends Thread {//�߳�7
     public void run() {
         while (true) {
        	 repaint();//�ػ�
        	 BAction(); //�л������ж�
             try {
                 Thread.sleep(5);//�ӳ�
             } catch (InterruptedException e) {//�쳣����
                 e.printStackTrace();
             }
         }


     }


 }

 class Run6 extends Thread { //�߳�6
     public void run() {
         while (true) {
        	 if(zd1==1)  //ʡ{}
        		 stepAction(); 
             	stepAction2(); //�ƶ�2��Ӣ���ӵ��ƶ�
        	 OX();//��������Ϸ״̬�ж�
             try {
                 Thread.sleep(10);//�ӳ�
             } catch (InterruptedException e) {//�쳣����
                 e.printStackTrace();
             }
         }


     }


 }
 

 class Run3 extends Thread {//�߳�3
        public void run() {
            while (true) {
            	if(zd1==1)  //��Ϸ״̬Ϊ1
                    shootAction(); // Ӣ�ۻ�����ӵ�
            	
            	if(zd1!=1){  //��Ϸ״̬��Ϊ1
            	enemys.removeAll(enemys);//�Ƴ��о�
            	BOBs.removeAll(BOBs);//�Ƴ�BOSS�ӵ�
                Bullets.removeAll(Bullets);//�Ƴ�P�ӵ�
            	}
//            	System.out.println(boss);
                  if(zd1==1){//��Ϸ״̬Ϊ1
                  enemyEnter();  // �о��볡
                  
                 if(boss==2)//BOSS����
                 BF();//BOSS�ӵ�����
                    try {
                        Thread.sleep(300);//�ӳ�
                    } catch (InterruptedException e) {//�쳣����
                        e.printStackTrace();
                    }
                  }
                    
                  
            }
        }
    }
 class Run4 extends Thread {//�߳�4
        public void run() {
            while (true) {
            	
                PE();//Ӣ�ۻ���л�������ײ��Ѫ�����ж�
                try {
                    Thread.sleep(10);//�ӳ�
                } catch (InterruptedException e) {//�쳣����
                    e.printStackTrace();
                }
            }
        }
    }

class Run5 extends Thread {//�߳�5
        public void run() {
            while (true) {
                
                if(zd1==1){//����Ϸ״̬Ϊ1
                if (left) {//�������������
                    if (play.PlayX > 0)//�����Ӣ�ۻ�X����ߴ���0�������ƶ���Χ
                        play.PlayX -= 2;//���Ӣ�ۻ�X�����2����   ʡ��{}
                }
                if (up) {//���Ϸ����������
                    if (play.PlayY > 0)//�����Ӣ�ۻ�Y���������0  �����ƶ���Χ
                        play.PlayY -= 2;//���Ӣ�ۻ�Y�����2����  ʡ��{}
                }
                if (right) {//���ҷ����������
                    if (play.PlayX < WIDTH - play.width*1.1)//�����Ӣ�ۻ���X����С��  ����������Ŀ�ȣ�- ���Ӣ�ۻ��Ŀ�ȵ�1.1���Ĳ�)
                        play.PlayX += 2;//���Ӣ�ۻ�X����+2����   ʡ��{}
                }
                if (down) {//���·����������
                    if (play.PlayY < HEIGHT - play.height*1.5)//����ҵ�Y����С��     ����������ĸ߶ȣ�- ���Ӣ�ۻ��ĸ߶ȵ�1.5���Ĳ
                        play.PlayY += 2;//���Ӣ�ۻ�Y����+2����   ʡ��{}
                }
                }
                
               
                try {
                    Thread.sleep(5);//�ӳ�
                } catch (InterruptedException e) {//�쳣����
                    e.printStackTrace();
                }
            }


        }
    }

static class listener extends KeyAdapter{  //�������࣬  �̳м���������
        @Override
        public void keyPressed(KeyEvent e) {//�����¼�   ��������
            switch(e.getKeyCode()){     //switch��֧ѡ��
                case KeyEvent.VK_CONTROL:    //�����µļ�ΪCONTROL��
                    shoot=true;   //�������ֵΪ��
                    break;//������֧ѡ��
                case KeyEvent.VK_ENTER:    //�����µļ�Ϊ�س���
                    re=true;   //�س�����ֵΪ��
                    break;//������֧ѡ��
                case KeyEvent.VK_R://�����µļ�ΪR��
                    sw=true;  //R������ֵΪ��
                    break;//������֧ѡ��
                case KeyEvent.VK_LEFT:   //37  �����µļ�Ϊ�����
                    left=true;//���������ֵΪ��
                    break;//������֧ѡ��
                case KeyEvent.VK_UP:    //38    �����µļ�Ϊ�Ϸ����

                    up=true;//�Ϸ��������ֵΪ��

                    break;//������֧ѡ��
                case KeyEvent.VK_RIGHT:   //39   �����µļ�Ϊ�ҷ����
                    right=true;//�ҷ��������ֵΪ��

                    break;//������֧ѡ��
                case KeyEvent.VK_DOWN:     //40   �����µļ�Ϊ�·����

                    down=true;//�·��������ֵΪ��
                    break;//������֧ѡ��
            }

        }
        @Override
        public void keyReleased(KeyEvent e) {    //�����¼�   ���ͷ�
//				 System.out.println("�ͷ�"+e.getKeyCode());
            switch(e.getKeyCode()){  //switch��֧ѡ��
                case KeyEvent.VK_CONTROL://���ͷŵļ�ΪCONTROL��
                    shoot=false;//�������ֵΪ��
                    break;//������֧ѡ��
                case KeyEvent.VK_R://���ͷŵļ�ΪR��
                    sw=false;//R������ֵΪ��
                    break;//������֧ѡ��
                case KeyEvent.VK_ENTER://���ͷŵļ�Ϊ�س���
                    re=false;//�س�������ֵΪ��
                    break;//������֧ѡ��
                case KeyEvent.VK_LEFT://���ͷŵļ�Ϊ�����
                	left=false;//���������ֵΪ��
                	break;//������֧ѡ��
                case 38:  //���ͷŵļ�Ϊ�Ϸ����
                	up=false;//�Ϸ��������ֵΪ��
                	break;//������֧ѡ��
                case 39://���ͷŵļ�Ϊ�ҷ����
                	right=false;//�ҷ��������ֵΪ��
                	break;//������֧ѡ��
                case 40://���ͷŵļ�Ϊ�·����
                	down=false;//�·��������ֵΪ��
                	break;//������֧ѡ��
            }
        }
    }
     //�о�����   �볡
     void enemyEnter() {
            Enemy f = new Enemy();
            enemys.add(f);
        }
  
     void stepAction2(){ //�ƶ�   Ӣ���ӵ�
         for (int i = 0; i < Bullets.size(); i++) { // Ӣ�ۻ��ӵ���һ��
             Bullet b = Bullets.get(i);
             b.y -= b.speed;//Ӣ���ӵ�y�������speed����λ������
             if (b.y < 0) //Ӣ���ӵ�Y������С��0
                 Bullets.remove(b);//���ӵ��Ƴ�
         }
         for (int i = 0; i < Bullet2s.size(); i++) { // Ӣ�ۻ��ӵ�2��һ��
             Bullet2 b = Bullet2s.get(i);
             b.y2 -= b.speed;//Ӣ���ӵ�2y�������speed����λ������
             if (b.y2 < 0) //Ӣ���ӵ�Y������С��0
                 Bullet2s.remove(b);//���ӵ��Ƴ�
         }
         for (int i = 0; i < Bullet3s.size(); i++) { // Ӣ�ۻ��ӵ�3��һ��
             Bullet3 b = Bullet3s.get(i);
             b.y3 -= b.speed;//Ӣ���ӵ�2y�������speed����λ������
             if (b.y3 < 0) //Ӣ���ӵ�Y������С��0
                 Bullet3s.remove(b);//���ӵ��Ƴ�
         }
     }
   
   
 public void stepAction() {//�ƶ�   �л�  �л��ӵ�  BOSS   BOSS�ӵ�
        for (int i = 0; i < enemys.size(); i++) { // �л���һ��
            Enemy f = enemys.get(i);
            f.y += f.speed;//�л�Y������+speed����λ������
            if (f.y > 650) //�л�Y���������650
                enemys.remove(f);//�õл��Ƴ�
        }
        

        for (int i = 0; i < EBs.size(); i++) { // �з��ӵ���һ��
            EB b = EBs.get(i);
            b.y += b.speed;//�л��ӵ�Y������+speed����λ������
            if (b.y > 655) //�л��ӵ�Y���������655
                EBs.remove(b);//�õл��ӵ��Ƴ�
        }
        
        for (int i = 0; i < BOBs.size(); i++) { // B�ӵ���һ��
            XBOB b = BOBs.get(i);
            b.y += b.speed;//BOSS�ӵ�Y������+speed����λ������
            if (b.y > 675) //BOSS�ӵ�Y���������675
                BOBs.remove(b);//��BOSS�ӵ��Ƴ�
        }
        for (int i = 0; i < XBOSSs.size(); i++) { // XBOSS��һ��
        	XBOSS b = XBOSSs.get(i);
        	if(b.y<=-50)//BOSS Y������С�ڵ���-50
            b.y += b.speed;//BOSSY������+speed����λ������
        }
 }
     
	void shootAction() {// ���
        if (shoot) { //�������ֵΪ��
        	switch(KB){ //�񱩵ȼ��ж�
        	case 1://��1
            Bullet b = new Bullet();//�ӵ�����1
            Bullets.add(b);
            break;
        	case 2://��2
        	Bullet2 b1 = new Bullet2();//�ӵ�����2
            Bullet2s.add(b1);
            Bullet3 b2 = new Bullet3(); //�ӵ�����3
            Bullet3s.add(b2);
        	
        	break;
        	case 3://��3
            	Bullet2 b3 = new Bullet2();//�ӵ�����2
                Bullet2s.add(b3);
                Bullet3 b4 = new Bullet3();//�ӵ�����3
                Bullet3s.add(b4);
                Bullet b5 = new Bullet();//�ӵ�����1
                Bullets.add(b5);
            	break;
        	
        	}
        	
        	
            	}
        }
 

 public void BAction() {//�����������Ӣ�ۻ��ӵ�
        for (int i = 0; i < Bullets.size(); i++) {
            Bullet f = Bullets.get(i);
            bangAction(f);//���Ӣ�ۻ��ӵ�1��о��ж�
        }
        for (int i = 0; i < Bullet2s.size(); i++) {
            Bullet2 f = Bullet2s.get(i);
            bangAction2(f);//���Ӣ�ۻ��ӵ�2��о��ж�
        }
        for (int i = 0; i < Bullet3s.size(); i++) {
            Bullet3 f = Bullet3s.get(i);
            bangAction3(f);//���Ӣ�ۻ��ӵ�3��о��ж�
        }
        
        
        
    }
    public void PE(){//���Ӣ�ۻ���о��ɻ�������ײ���
        for(int i=0;i<enemys.size();i++) {
            Enemy f=enemys.get(i);
            if (play.Pbang(f)) {   //������Ӣ�ۻ���о���ײ
                EBH(f); //�о���ը��ɫ���
                enemys.remove(f);//�Ƴ��õл�
                play.life--;//�������ֵ����
                PBL(play);   //��ұ�ը��ɫ����
            }
            
            if(f.y==20||f.y==100){//����л�y������Ϊ20��100�������ӵ�
            	 EB m=new EB();
            	 m.x=f.x+f.width/2-11;//�ӵ����ֵ�X������
                 m.y=f.y+f.height-20;//�ӵ����ֵ�Y������
                 EBs.add(m);
            }
        }
    }

       void EBP(EB e) {//�о��ӵ������Ӣ�ۻ���ײ�ж�
    	   if(play.Pbang2(e)){//����л��ӵ������Ӣ�ۻ���ײ
    		   
    		   play.life--;//�������ֵ��1
    		   PBL(play);//��ұ�ը��ɫ����
    		   EBs.remove(e);//�Ƴ��������ײ�ĵо��ӵ�
    	   }
    }
       
       void EBP(XBOB e) {//BOSS�ӵ������Ӣ�ۻ���ײ�ж�   ����
    	   if(play.Pbang2(e)){//���BOSS�ӵ������Ӣ�ۻ���ײ
    		   
    		   play.life--;//�������ֵ��1
    		   PBL(play);//��ұ�ը��ɫ����
    		   BOBs.remove(e);//�Ƴ��������ײ��BOSS�ӵ�
    	   }
    }


	void bangAction(Bullet e) {//���Ӣ�ۻ��ӵ�1��о���ײ�ж�

        for (int i = 0; i < enemys.size(); i++) {
            Enemy f = enemys.get(i);

            if (f.Bbang1(e)) {//�������ӵ���о���ײ
                play.score += 5;//��ҷ�����5
                if(play.score>=200&&play.score<600)//��������200С��600��ֵΪ2
                	KB=2;//��2��ֵ��KB��ֵ
                EBH(f);//�о���ը��ɫ���
                enemys.remove(f);//�Ƴ��õл�
                Bullets.remove(e); //�Ƴ����ӵ�
            }
            }
        for (int i = 0; i < XBOSSs.size(); i++) {
      	  XBOSS f = XBOSSs.get(i);

            if (f.Bbang1(e)) {//�������ӵ���BOSS��ײ
            	f.life--;//BOSS����-1
            	PBZ(f);//��ը��ɫ����
                Bullets.remove(e); //�Ƴ����ӵ�
                if(f.life==0){//���BOSS����ֵΪ0
                
                XBOSSs.remove(f);//�Ƴ���BOSS
                boss=3;//BOSS״̬Ϊ3  
                EBX(f);//BOSS��ը��ɫ����
                }
            }
        	}
        
        }
  void bangAction2(Bullet2 e) {//���Ӣ�ۻ��ӵ�2��о���ײ�ж�

      for (int i = 0; i < enemys.size(); i++) {
          Enemy f = enemys.get(i);

          if (f.Bbang2(e)) {//�������ӵ���о���ײ
              play.score += 5;//��ҷ�����5
              if(play.score>=600)//��������600��ֵΪ3
              	KB=3;//��3��ֵ��KB��ֵ
              EBH(f);//�о���ը��ɫ���
              enemys.remove(f);//�Ƴ��õл�
              Bullet2s.remove(e); //�Ƴ����ӵ�
          }
          }
      for (int i = 0; i < XBOSSs.size(); i++) {
    	  XBOSS f = XBOSSs.get(i);

          if (f.Bbang2(e)) {//�������ӵ���BOSS��ײ
              f.life--;//BOSS����-1
              PBZ(f);//��ը��ɫ����
              Bullet2s.remove(e); //�Ƴ����ӵ�
              if(f.life==0){//���BOSS����ֵΪ0
              XBOSSs.remove(f);//�Ƴ���BOSS
              boss=3;//BOSS״̬Ϊ3  
              EBX(f);//BOSS��ը��ɫ����
              }
          }
      	}
      
      
      }
  
  void bangAction3(Bullet3 e) {//���Ӣ�ۻ��ӵ�3��о���ײ�ж�

      for (int i = 0; i < enemys.size(); i++) {
          Enemy f = enemys.get(i);

          if (f.Bbang3(e)) {//�������ӵ���о���ײ
              play.score += 5;//��ҷ�����5
//              if(play.score==600)
//              	KB++;
              EBH(f);//�о���ը��ɫ���
              enemys.remove(f);//�Ƴ��õл�
              Bullet3s.remove(e); //�Ƴ����ӵ�
          }
      	}
      for (int i = 0; i < XBOSSs.size(); i++) {
    	  XBOSS f = XBOSSs.get(i);

          if (f.Bbang3(e)) {//�������ӵ���BOSS��ײ
              f.life--;//BOSS����-1
              PBZ(f);//��ը��ɫ����
              Bullet3s.remove(e); //�Ƴ����ӵ�
              if(f.life==0){//���BOSS����ֵΪ0
              XBOSSs.remove(f);//�Ƴ���BOSS
              boss=3;//BOSS״̬Ϊ3 
              EBX(f);//BOSS��ը��ɫ����
              }
          }
      	}
      
      
      }
  void EBX(XBOSS f){//BOSS��ը��ɫ����
	   Baozha m=new Baozha();
       m.x=f.x-f.width/2;//��ɫ������ֵ�X������
       m.y=f.y-f.height/2;//��ɫ������ֵ�Y������
       m.width=f.width*2;//��ɫ������ֵĿ��
       m.height=f.height*2;//��ɫ������ֵĸ߶�
       baozhas.add(m);
  }
  
  
  
   void EBH(Enemy f){//�л���ը��ɫ����
	   Baozha m=new Baozha();
       m.x=f.x-f.width/2;//��ɫ������ֵ�X������
       m.y=f.y-f.height/2;//��ɫ������ֵ�Y������
       m.width=f.width*2;//��ɫ������ֵĿ��
       m.height=f.height*2;//��ɫ������ֵĸ߶�
       baozhas.add(m);
   }
   

   

   
   void PBL(Play f){//���Ӣ�ۻ���ը��ɫ����
	   Baozha m=new Baozha();
       m.x=f.PlayX-f.width/2;//��ɫ������ֵ�X������
       m.y=f.PlayY-f.height/2;//��ɫ������ֵ�Y������
       m.width=f.width*2;//��ɫ������ֵĿ��
       m.height=f.height*2;//��ɫ������ֵĸ߶�
       baozhas2.add(m);
   }
   void PBZ(XBOSS f){//���Ӣ�ۻ���ը��ɫ����
	   Baozha m=new Baozha();
       m.x=f.x-f.width/2;//��ɫ������ֵ�X������
       m.y=f.y-f.height/2;//��ɫ������ֵ�Y������
       m.width=f.width*2;//��ɫ������ֵĿ��
       m.height=f.height*2;//��ɫ������ֵĸ߶�
       baozhas3.add(m);
   }
   void BF(){
	   if(boss==2){//BOSS����
		   XBOB f=new XBOB();//BOSS���ӵ�
		   BOBs.add(f);
		   
	   }
	   
	   
   }
  

   public void OX() {
	   if(boss==3){//BOSS������
		   enemys.removeAll(enemys);//�Ƴ��о�
		   BOBs.removeAll(BOBs);//�Ƴ�BOSS�ӵ�
      	
      	
       }
	   
	   
	  if(boss==2){//BOSS����
		  enemys.removeAll(enemys);//�Ƴ��о�
		  EBs.removeAll(EBs);
		 
	  }
	  //�����ж�
	  if(re==true&&zd1==4){
		  zd1=0;
	  }

	   if(sw==true&&zd1==-3){
		  
		   zd1=0;
		   boss=1;
		   
		   
	   }
	   if(re&&zd1==0){
           play.PlayX=175;
           play.PlayY=500;
           mapY=-3100;
           zd1=1;
       }
	   if(play.life<=0){
		   zd1=-1;
              }
	   
        if (zd1==-1) {
            play.life = 0;
            enemys.removeAll(enemys);
            Bullets.removeAll(Bullets);
            EBs.removeAll(EBs);
            }
        if (sw == true) {
        	 boss=1;
            play.life = 30;
            play.score = 0;
            KB=1;
            zd1=0;
            mapY=-3100;
        }
        }
    }







