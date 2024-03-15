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
   	static int WIDTH = 400; // 面板宽
    static int HEIGHT = 654; // 面板高
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
    	g.drawImage(map, mapX, mapY, null); // 画背景图
        if(zd1==1)//简写
        paintP(g); // 画英雄机
        paintB(g); // 画子弹
        paintB2(g);//画子弹2
        paintB3(g);//画子弹3
        paintEB(g);//画敌军子弹
        paintE(g); // 画敌军
        paintXBOSS(g);//画BOSS
        paintBOB(g);//画BOSS子弹
        paintBz(g);//画爆炸
        paintBOSSHP(g);//画BOSS血量值
        paintGO2(g);//画结束游戏文本
        paintGO(g);//画玩家信息
        paintWINGO2(g);//画胜利提示文本
    	}
     // 画英雄机
    void paintP(Graphics g) {
        g.drawImage(hero, play.PlayX, play.PlayY, 50, 50, null);
    }
     //画玩家英雄机子弹1
    void paintB(Graphics g) {
        for (int i = 0; i < Bullets.size(); i++) {
            Bullet f = Bullets.get(i);
            g.drawImage(B, f.x, f.y, 50, 50, null);
        }
    }
    //画玩家英雄机子弹2
    void paintB2(Graphics g) {
        for (int i = 0; i < Bullet2s.size(); i++) {
            Bullet2 f = Bullet2s.get(i);
            g.drawImage(B, f.x2, f.y2, 50, 50, null);
        }
    }
    //画玩家英雄机子弹3
    void paintB3(Graphics g) {
        for (int i = 0; i < Bullet3s.size(); i++) {
            Bullet3 f = Bullet3s.get(i);
            g.drawImage(B, f.x3, f.y3, 50, 50, null);
        }
    }
    //画敌军子弹
    void paintEB(Graphics g) {
        for (int i = 0; i < EBs.size(); i++) {
            EB f = EBs.get(i);
            if(zd1==1)
            g.drawImage(EB2, f.x, f.y, f.width, f.height, null);
            EBP(f);//敌军子弹与玩家英雄机物理碰撞消血判定，形参类型为敌军子弹类型
        }  
    }
    //画BOSS子弹
    void paintBOB(Graphics g) {
        for (int i = 0; i < BOBs.size(); i++) {
            XBOB f = BOBs.get(i);
            g.drawImage(XBOBT, f.x, f.y, f.width, f.height, null);
            
            
            EBP(f);//BOSS子弹与玩家英雄机物理碰撞消血判定，形参类型为BOSS子弹类型
        }  
    }

    //画各种爆炸效果
    void paintBz(Graphics g) {
        for (int i = 0; i < baozhas.size(); i++) {
            Baozha f = baozhas.get(i);
           f.sj++;  //延迟计数
           if(f.sj<10)//条件判定
            g.drawImage(BZ1, f.x, f.y, f.width, f.width, null);//省略{}
           if(f.sj<20&&f.sj>10)//条件判定
        	   g.drawImage(BZ2, f.x, f.y, f.width, f.width, null);//省略{}
           if(f.sj<30&&f.sj>20)//条件判定
        	   g.drawImage(BZ3, f.x, f.y, f.width, f.width, null);//省略{}
           if(f.sj<40&&f.sj>30)//条件判定
        	   g.drawImage(BZ4, f.x, f.y, f.width, f.width, null);//省略{}
           
           if(f.sj==40)//条件判定
             baozhas.remove(i);//爆炸消除     省略{}
        }
        
        for (int i = 0; i < baozhas2.size(); i++) {
            Baozha f = baozhas2.get(i);
           f.sj++;//延迟计数
           if(f.sj<10)//条件判定
            g.drawImage(BZw1, f.x, f.y, 100, 100, null);//省略{}
           if(f.sj<20&&f.sj>10)//条件判定
        	   g.drawImage(BZw2, f.x, f.y, 100, 100, null);//省略{}
           if(f.sj<30&&f.sj>20)//条件判定
        	   g.drawImage(BZw3, f.x, f.y, 100, 100, null);//省略{}
           if(f.sj<40&&f.sj>30)//条件判定
        	   g.drawImage(BZw4, f.x, f.y, 100, 100, null);//省略{}
           if(f.sj==40) //条件判定
        	   baozhas2.remove(i);//爆炸消除     省略{}
        }
        
        for (int i = 0; i < baozhas3.size(); i++) {
            Baozha f = baozhas3.get(i);
           f.sj++;//延迟计数
           if(f.sj<10&&f.sj>0)//条件判定
        	   g.drawImage(BZZ3, f.x+f.width/4, f.y+f.height/4, f.width/2,  f.height/2, null);//省略{}
           
           if(f.sj==10)//条件判定
             baozhas3.remove(i);//爆炸消除     省略{}
            

        }
        
        
    }
    
 
    // 画敌机
    void paintE(Graphics g) {
        for (int i = 0; i < enemys.size(); i++) {
            Enemy f = enemys.get(i);
            g.drawImage(E, f.x, f.y, f.width, f.height, null);
        }
       
    }
    //画BOSS
    void paintXBOSS(Graphics g) {
        for (int i = 0; i < XBOSSs.size(); i++) {
        	XBOSS f = XBOSSs.get(i);
            g.drawImage(XBOSS, f.x, f.y, f.width, f.height, null);
        }
       
    }
    //画玩家信息
    void paintGO(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.drawString("剩余生命值：" + play.life, 20, 60);
        g.drawString("您的分数为：" + play.score, 20, 40);
        g.drawString("狂暴级别为：" + KB, 20, 80);
      
        g.setColor(c);
    }
    //画BOSS血量
    void paintBOSSHP(Graphics g) {
    	 Color c = g.getColor();
         g.setColor(Color.red);
    	for(int i = 0; i < XBOSSs.size(); i++){
    		XBOSS f = XBOSSs.get(i);
    		if(boss==2)
            g.drawString("BOSS血量为：" + f.life, 20, 100);
    } 	
    	 g.setColor(c);
    }
    //画结束文本
    void paintGO2(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        if(zd1==-1){
        g.drawString("游戏结束您的分数为：" + play.score+"" ,150, 325  );
        g.drawString("重置游戏请按R键" ,160, 355  );
        }
        
        if(zd1==-3||zd1==0){
        	g.drawString("请按Enter键开始游戏" ,150, 325  );
        	EBs.removeAll(EBs);
        	if(re==true)
        		zd1=1;
        }
        
        g.setColor(c);
    }
    //画胜利提示文本
    void paintWINGO2(Graphics g) {
    	if(mapY>-340&&mapY<-305)
    	g.drawImage(WIN, 100, 305, 200, 60, null);
        Color c = g.getColor();
        g.setColor(Color.red);
        if(boss==3){
     	   g.drawString("您胜利了" , 168, 355);
     	   g.drawString("重置游戏请按R键" ,150, 335  );
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
    
    public static void main(String[] args) {//主方法
        AirWar jp1 = new AirWar(); //本类对象，游戏面板
        JFrame frame = new JFrame("AirWar          by:zyp");//窗口
        JPanel jp = new JPanel();//创建面板
        Button a1 = new Button("Start Game");//定义按钮
//        Button a2 = new Button("游戏设置");//定义按钮
//        Button a3 = new Button("游戏排名");//定义按钮
        Button a4 = new Button("Close the game");//定义按钮
        jp.setLayout(null);//设置布局
        jp1.setLayout(null);//设置布局
        a1.setBounds(148, 370, 100, 40);//设置按钮位置
//        a2.setBounds(148, 420, 100, 40);//设置按钮位置
//        a3.setBounds(148, 470, 100, 40);//设置按钮位置
        a4.setBounds(148, 520, 100, 40);//设置按钮位置
        
        a1.addActionListener(new ActionListener() {//a1按钮添加行为监听器
            @Override
            public void actionPerformed(ActionEvent e) {//单击事件
                jp1.addKeyListener(new listener());//游戏面板添加键盘监听器
                jp.setVisible(false);//启动面板设置隐藏
                jp1.setVisible(true);//游戏面板设置显示
                frame.getContentPane().add(jp1);//将游戏面板添加至主窗体内容面板
                jp1.requestFocus();//游戏面板获得焦点
                jp1.action();//游戏面板执行方法action
            }
        });
        a4.addActionListener(new ActionListener() {//a4按钮添加行为监听器
            @Override
            public void actionPerformed(ActionEvent e) {//单击事件
                System.exit(0);//退出
            }
        });
        jp.add(a1);//启动面板添加按钮1
//        jp.add(a2);//启动面板添加按钮2
//        jp.add(a3);//启动面板添加按钮3
        jp.add(a4);//启动面板添加按钮4
        frame.getContentPane().add(jp);//启动面板添加至主窗体
        frame.setSize(WIDTH, HEIGHT); // 设置主窗体大小
        frame.setAlwaysOnTop(true); // 设置主窗体顶置
        frame.setDefaultCloseOperation(3); // 主窗体设置默认关闭     3或 换JFrame.EXIT_ON_CLOSE
        frame.setLocationRelativeTo(null); // 设置无窗体初始位置
        frame.setResizable(false);//设置窗体尺寸不可改变
        frame.setVisible(true);//设置窗体可见
    }
       void action() {//游戏面板行为方法
         run5.start();
//         run1.start();
//         run2.start();
         run3.start();
         run4.start();
         run.start();
         run6.start();
         run7.start();
    }


 class Run extends Thread {   //线程1
        public void run() {
            while (true) {
            	 
                  // 移动，敌军，敌军子弹，BOSS，BOSS子弹
//                System.out.println(mapY);  
                if(zd1==1&&boss!=2){ //游戏状态为1，并且boss不存在，执行
                if(mapY<0){  //地图Y值小于0
                mapY++; //地图Y值+1
              
                if(mapY==-303){//地图Y值为-303  
                	mapY++;//？
                 		do{
               		   XBOSS x=new XBOSS();//刷一只BOSS
                         XBOSSs.add(x);
                         boss=2;//BOSS状态为存在
                 		}while(false);
                
                }
               
                }
                
                
                }
                try {
                    Thread.sleep(20);//延迟
                } catch (InterruptedException e) {//异常处理
                    e.printStackTrace();
                }
            }
        }
    }

 class Run7 extends Thread {//线程7
     public void run() {
         while (true) {
        	 repaint();//重画
        	 BAction(); //敌机消除判定
             try {
                 Thread.sleep(5);//延迟
             } catch (InterruptedException e) {//异常处理
                 e.printStackTrace();
             }
         }


     }


 }

 class Run6 extends Thread { //线程6
     public void run() {
         while (true) {
        	 if(zd1==1)  //省{}
        		 stepAction(); 
             	stepAction2(); //移动2，英雄子弹移动
        	 OX();//按键，游戏状态判定
             try {
                 Thread.sleep(10);//延迟
             } catch (InterruptedException e) {//异常处理
                 e.printStackTrace();
             }
         }


     }


 }
 

 class Run3 extends Thread {//线程3
        public void run() {
            while (true) {
            	if(zd1==1)  //游戏状态为1
                    shootAction(); // 英雄机射击子弹
            	
            	if(zd1!=1){  //游戏状态不为1
            	enemys.removeAll(enemys);//移除敌军
            	BOBs.removeAll(BOBs);//移除BOSS子弹
                Bullets.removeAll(Bullets);//移除P子弹
            	}
//            	System.out.println(boss);
                  if(zd1==1){//游戏状态为1
                  enemyEnter();  // 敌军入场
                  
                 if(boss==2)//BOSS存在
                 BF();//BOSS子弹出现
                    try {
                        Thread.sleep(300);//延迟
                    } catch (InterruptedException e) {//异常处理
                        e.printStackTrace();
                    }
                  }
                    
                  
            }
        }
    }
 class Run4 extends Thread {//线程4
        public void run() {
            while (true) {
            	
                PE();//英雄机与敌机物理碰撞减血消除判定
                try {
                    Thread.sleep(10);//延迟
                } catch (InterruptedException e) {//异常处理
                    e.printStackTrace();
                }
            }
        }
    }

class Run5 extends Thread {//线程5
        public void run() {
            while (true) {
                
                if(zd1==1){//若游戏状态为1
                if (left) {//若左方向键被按下
                    if (play.PlayX > 0)//若玩家英雄机X轴左边大于0，限制移动范围
                        play.PlayX -= 2;//玩家英雄机X坐标减2像素   省略{}
                }
                if (up) {//若上方向键被按下
                    if (play.PlayY > 0)//若玩家英雄机Y轴坐标大于0  限制移动范围
                        play.PlayY -= 2;//玩家英雄机Y坐标减2像素  省略{}
                }
                if (right) {//若右方向键被按下
                    if (play.PlayX < WIDTH - play.width*1.1)//若玩家英雄机的X坐标小于  （（主窗体的宽度）- 玩家英雄机的宽度的1.1倍的差)
                        play.PlayX += 2;//玩家英雄机X坐标+2像素   省略{}
                }
                if (down) {//若下方向键被按下
                    if (play.PlayY < HEIGHT - play.height*1.5)//若玩家的Y坐标小于     （（主窗体的高度）- 玩家英雄机的高度的1.5倍的差）
                        play.PlayY += 2;//玩家英雄机Y坐标+2像素   省略{}
                }
                }
                
               
                try {
                    Thread.sleep(5);//延迟
                } catch (InterruptedException e) {//异常处理
                    e.printStackTrace();
                }
            }


        }
    }

static class listener extends KeyAdapter{  //监听器类，  继承键盘适配器
        @Override
        public void keyPressed(KeyEvent e) {//键盘事件   ，被按下
            switch(e.getKeyCode()){     //switch分支选择
                case KeyEvent.VK_CONTROL:    //被按下的键为CONTROL键
                    shoot=true;   //射击布尔值为真
                    break;//跳出分支选择
                case KeyEvent.VK_ENTER:    //被按下的键为回车键
                    re=true;   //回车布尔值为真
                    break;//跳出分支选择
                case KeyEvent.VK_R://被按下的键为R键
                    sw=true;  //R键布尔值为真
                    break;//跳出分支选择
                case KeyEvent.VK_LEFT:   //37  被按下的键为左方向键
                    left=true;//左方向键布尔值为真
                    break;//跳出分支选择
                case KeyEvent.VK_UP:    //38    被按下的键为上方向键

                    up=true;//上方向键布尔值为真

                    break;//跳出分支选择
                case KeyEvent.VK_RIGHT:   //39   被按下的键为右方向键
                    right=true;//右方向键布尔值为真

                    break;//跳出分支选择
                case KeyEvent.VK_DOWN:     //40   被按下的键为下方向键

                    down=true;//下方向键布尔值为真
                    break;//跳出分支选择
            }

        }
        @Override
        public void keyReleased(KeyEvent e) {    //键盘事件   被释放
//				 System.out.println("释放"+e.getKeyCode());
            switch(e.getKeyCode()){  //switch分支选择
                case KeyEvent.VK_CONTROL://被释放的键为CONTROL键
                    shoot=false;//射击布尔值为假
                    break;//跳出分支选择
                case KeyEvent.VK_R://被释放的键为R键
                    sw=false;//R键布尔值为假
                    break;//跳出分支选择
                case KeyEvent.VK_ENTER://被释放的键为回车键
                    re=false;//回车键布尔值为假
                    break;//跳出分支选择
                case KeyEvent.VK_LEFT://被释放的键为左方向键
                	left=false;//左方向键布尔值为假
                	break;//跳出分支选择
                case 38:  //被释放的键为上方向键
                	up=false;//上方向键布尔值为假
                	break;//跳出分支选择
                case 39://被释放的键为右方向键
                	right=false;//右方向键布尔值为假
                	break;//跳出分支选择
                case 40://被释放的键为下方向键
                	down=false;//下方向键布尔值为假
                	break;//跳出分支选择
            }
        }
    }
     //敌军创建   入场
     void enemyEnter() {
            Enemy f = new Enemy();
            enemys.add(f);
        }
  
     void stepAction2(){ //移动   英雄子弹
         for (int i = 0; i < Bullets.size(); i++) { // 英雄机子弹走一步
             Bullet b = Bullets.get(i);
             b.y -= b.speed;//英雄子弹y轴坐标减speed个单位的像素
             if (b.y < 0) //英雄子弹Y轴坐标小于0
                 Bullets.remove(b);//该子弹移除
         }
         for (int i = 0; i < Bullet2s.size(); i++) { // 英雄机子弹2走一步
             Bullet2 b = Bullet2s.get(i);
             b.y2 -= b.speed;//英雄子弹2y轴坐标减speed个单位的像素
             if (b.y2 < 0) //英雄子弹Y轴坐标小于0
                 Bullet2s.remove(b);//该子弹移除
         }
         for (int i = 0; i < Bullet3s.size(); i++) { // 英雄机子弹3走一步
             Bullet3 b = Bullet3s.get(i);
             b.y3 -= b.speed;//英雄子弹2y轴坐标减speed个单位的像素
             if (b.y3 < 0) //英雄子弹Y轴坐标小于0
                 Bullet3s.remove(b);//该子弹移除
         }
     }
   
   
 public void stepAction() {//移动   敌机  敌机子弹  BOSS   BOSS子弹
        for (int i = 0; i < enemys.size(); i++) { // 敌机走一步
            Enemy f = enemys.get(i);
            f.y += f.speed;//敌机Y轴坐标+speed个单位的像素
            if (f.y > 650) //敌机Y轴坐标大于650
                enemys.remove(f);//该敌机移除
        }
        

        for (int i = 0; i < EBs.size(); i++) { // 敌方子弹走一步
            EB b = EBs.get(i);
            b.y += b.speed;//敌机子弹Y轴坐标+speed个单位的像素
            if (b.y > 655) //敌机子弹Y轴坐标大于655
                EBs.remove(b);//该敌机子弹移除
        }
        
        for (int i = 0; i < BOBs.size(); i++) { // B子弹走一步
            XBOB b = BOBs.get(i);
            b.y += b.speed;//BOSS子弹Y轴坐标+speed个单位的像素
            if (b.y > 675) //BOSS子弹Y轴坐标大于675
                BOBs.remove(b);//该BOSS子弹移除
        }
        for (int i = 0; i < XBOSSs.size(); i++) { // XBOSS走一步
        	XBOSS b = XBOSSs.get(i);
        	if(b.y<=-50)//BOSS Y轴坐标小于等于-50
            b.y += b.speed;//BOSSY轴坐标+speed个单位的像素
        }
 }
     
	void shootAction() {// 射击
        if (shoot) { //射击布尔值为真
        	switch(KB){ //狂暴等级判定
        	case 1://狂暴1
            Bullet b = new Bullet();//子弹类型1
            Bullets.add(b);
            break;
        	case 2://狂暴2
        	Bullet2 b1 = new Bullet2();//子弹类型2
            Bullet2s.add(b1);
            Bullet3 b2 = new Bullet3(); //子弹类型3
            Bullet3s.add(b2);
        	
        	break;
        	case 3://狂暴3
            	Bullet2 b3 = new Bullet2();//子弹类型2
                Bullet2s.add(b3);
                Bullet3 b4 = new Bullet3();//子弹类型3
                Bullet3s.add(b4);
                Bullet b5 = new Bullet();//子弹类型1
                Bullets.add(b5);
            	break;
        	
        	}
        	
        	
            	}
        }
 

 public void BAction() {//遍历所有玩家英雄机子弹
        for (int i = 0; i < Bullets.size(); i++) {
            Bullet f = Bullets.get(i);
            bangAction(f);//玩家英雄机子弹1与敌军判定
        }
        for (int i = 0; i < Bullet2s.size(); i++) {
            Bullet2 f = Bullet2s.get(i);
            bangAction2(f);//玩家英雄机子弹2与敌军判定
        }
        for (int i = 0; i < Bullet3s.size(); i++) {
            Bullet3 f = Bullet3s.get(i);
            bangAction3(f);//玩家英雄机子弹3与敌军判定
        }
        
        
        
    }
    public void PE(){//玩家英雄机与敌军飞机物理碰撞检测
        for(int i=0;i<enemys.size();i++) {
            Enemy f=enemys.get(i);
            if (play.Pbang(f)) {   //如果玩家英雄机与敌军相撞
                EBH(f); //敌军爆炸红色焰火
                enemys.remove(f);//移除该敌机
                play.life--;//玩家生命值减少
                PBL(play);   //玩家爆炸蓝色火焰
            }
            
            if(f.y==20||f.y==100){//如果敌机y轴坐标为20或100，发射子弹
            	 EB m=new EB();
            	 m.x=f.x+f.width/2-11;//子弹出现的X轴坐标
                 m.y=f.y+f.height-20;//子弹出现的Y轴坐标
                 EBs.add(m);
            }
        }
    }

       void EBP(EB e) {//敌军子弹与玩家英雄机相撞判定
    	   if(play.Pbang2(e)){//如果敌机子弹与玩家英雄机相撞
    		   
    		   play.life--;//玩家生命值减1
    		   PBL(play);//玩家爆炸蓝色火焰
    		   EBs.remove(e);//移除与玩家相撞的敌军子弹
    	   }
    }
       
       void EBP(XBOB e) {//BOSS子弹与玩家英雄机相撞判定   重载
    	   if(play.Pbang2(e)){//如果BOSS子弹与玩家英雄机相撞
    		   
    		   play.life--;//玩家生命值减1
    		   PBL(play);//玩家爆炸蓝色火焰
    		   BOBs.remove(e);//移除与玩家相撞的BOSS子弹
    	   }
    }


	void bangAction(Bullet e) {//玩家英雄机子弹1与敌军相撞判定

        for (int i = 0; i < enemys.size(); i++) {
            Enemy f = enemys.get(i);

            if (f.Bbang1(e)) {//如果玩家子弹与敌军相撞
                play.score += 5;//玩家分数加5
                if(play.score>=200&&play.score<600)//分数大于200小于600狂暴值为2
                	KB=2;//把2赋值给KB狂暴值
                EBH(f);//敌军爆炸红色焰火
                enemys.remove(f);//移除该敌机
                Bullets.remove(e); //移除该子弹
            }
            }
        for (int i = 0; i < XBOSSs.size(); i++) {
      	  XBOSS f = XBOSSs.get(i);

            if (f.Bbang1(e)) {//如果玩家子弹与BOSS相撞
            	f.life--;//BOSS生命-1
            	PBZ(f);//爆炸黑色闪光
                Bullets.remove(e); //移除该子弹
                if(f.life==0){//如果BOSS生命值为0
                
                XBOSSs.remove(f);//移除该BOSS
                boss=3;//BOSS状态为3  
                EBX(f);//BOSS爆炸黄色火焰
                }
            }
        	}
        
        }
  void bangAction2(Bullet2 e) {//玩家英雄机子弹2与敌军相撞判定

      for (int i = 0; i < enemys.size(); i++) {
          Enemy f = enemys.get(i);

          if (f.Bbang2(e)) {//如果玩家子弹与敌军相撞
              play.score += 5;//玩家分数加5
              if(play.score>=600)//分数大于600狂暴值为3
              	KB=3;//把3赋值给KB狂暴值
              EBH(f);//敌军爆炸红色焰火
              enemys.remove(f);//移除该敌机
              Bullet2s.remove(e); //移除该子弹
          }
          }
      for (int i = 0; i < XBOSSs.size(); i++) {
    	  XBOSS f = XBOSSs.get(i);

          if (f.Bbang2(e)) {//如果玩家子弹与BOSS相撞
              f.life--;//BOSS生命-1
              PBZ(f);//爆炸黑色闪光
              Bullet2s.remove(e); //移除该子弹
              if(f.life==0){//如果BOSS生命值为0
              XBOSSs.remove(f);//移除该BOSS
              boss=3;//BOSS状态为3  
              EBX(f);//BOSS爆炸黄色火焰
              }
          }
      	}
      
      
      }
  
  void bangAction3(Bullet3 e) {//玩家英雄机子弹3与敌军相撞判定

      for (int i = 0; i < enemys.size(); i++) {
          Enemy f = enemys.get(i);

          if (f.Bbang3(e)) {//如果玩家子弹与敌军相撞
              play.score += 5;//玩家分数加5
//              if(play.score==600)
//              	KB++;
              EBH(f);//敌军爆炸红色焰火
              enemys.remove(f);//移除该敌机
              Bullet3s.remove(e); //移除该子弹
          }
      	}
      for (int i = 0; i < XBOSSs.size(); i++) {
    	  XBOSS f = XBOSSs.get(i);

          if (f.Bbang3(e)) {//如果玩家子弹与BOSS相撞
              f.life--;//BOSS生命-1
              PBZ(f);//爆炸黑色闪光
              Bullet3s.remove(e); //移除该子弹
              if(f.life==0){//如果BOSS生命值为0
              XBOSSs.remove(f);//移除该BOSS
              boss=3;//BOSS状态为3 
              EBX(f);//BOSS爆炸黄色火焰
              }
          }
      	}
      
      
      }
  void EBX(XBOSS f){//BOSS爆炸黄色火焰
	   Baozha m=new Baozha();
       m.x=f.x-f.width/2;//黄色火焰出现的X轴坐标
       m.y=f.y-f.height/2;//黄色火焰出现的Y轴坐标
       m.width=f.width*2;//黄色火焰出现的宽度
       m.height=f.height*2;//黄色火焰出现的高度
       baozhas.add(m);
  }
  
  
  
   void EBH(Enemy f){//敌机爆炸黄色火焰
	   Baozha m=new Baozha();
       m.x=f.x-f.width/2;//黄色火焰出现的X轴坐标
       m.y=f.y-f.height/2;//黄色火焰出现的Y轴坐标
       m.width=f.width*2;//黄色火焰出现的宽度
       m.height=f.height*2;//黄色火焰出现的高度
       baozhas.add(m);
   }
   

   

   
   void PBL(Play f){//玩家英雄机爆炸蓝色火焰
	   Baozha m=new Baozha();
       m.x=f.PlayX-f.width/2;//蓝色火焰出现的X轴坐标
       m.y=f.PlayY-f.height/2;//蓝色火焰出现的Y轴坐标
       m.width=f.width*2;//蓝色火焰出现的宽度
       m.height=f.height*2;//蓝色火焰出现的高度
       baozhas2.add(m);
   }
   void PBZ(XBOSS f){//玩家英雄机爆炸蓝色火焰
	   Baozha m=new Baozha();
       m.x=f.x-f.width/2;//蓝色火焰出现的X轴坐标
       m.y=f.y-f.height/2;//蓝色火焰出现的Y轴坐标
       m.width=f.width*2;//蓝色火焰出现的宽度
       m.height=f.height*2;//蓝色火焰出现的高度
       baozhas3.add(m);
   }
   void BF(){
	   if(boss==2){//BOSS存在
		   XBOB f=new XBOB();//BOSS发子弹
		   BOBs.add(f);
		   
	   }
	   
	   
   }
  

   public void OX() {
	   if(boss==3){//BOSS被消灭
		   enemys.removeAll(enemys);//移除敌军
		   BOBs.removeAll(BOBs);//移除BOSS子弹
      	
      	
       }
	   
	   
	  if(boss==2){//BOSS存在
		  enemys.removeAll(enemys);//移除敌军
		  EBs.removeAll(EBs);
		 
	  }
	  //条件判定
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







