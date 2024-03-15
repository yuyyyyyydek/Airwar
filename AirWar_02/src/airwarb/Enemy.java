package airwarb;
import java.util.Random;
public class Enemy extends AirWar{
 int x,y,width=60,height=60,speed=2,enemylife=1;

    Random rd=new Random();
    
    public Enemy(){

        x=rd.nextInt(AirWar.WIDTH-width);

        y=-100;

    }





    public boolean Bbang1(Bullet b){ //鏁屾満鍦ㄥ瓙寮瑰唴

        int bx=b.x;
        int by=b.y;
        int bw=b.width;
        int bh=b.height;


        boolean m1,A,B,C,D,E;
        A=(x<bx+bw)&&(x>bx)&&(y<by+bh)&&(y>by);  //敌机左上
        B=(x+width<bx+bw)&&(x+width>bx)&&(y<by+bh)&&(y>by);  //敌机右上
        C=(x<bx+bw)&&(x>bx)&&(y+height<by+bh)&&(y+height>by);//敌机左下
        D=(x+width<bx+bw)&&(x+width>bx)&&(y+height<by+bh)&&(y+height>by);//敌机右下
        E=(x+width/2<bx+bw)&&(x+width/2>bx)&&(y+height/2<by+bh)&&(y+height/2>by);
        m1=A||B||C||D||E;

        return m1;
    }
    
    public boolean Bbang2(Bullet2 b){ //鏁屾満鍦ㄥ瓙寮瑰唴

        int bx=b.x2;
        int by=b.y2;
        int bw=b.width;
        int bh=b.height;


        boolean m1,A,B,C,D,E;
        A=(x<bx+bw)&&(x>bx)&&(y<by+bh)&&(y>by);  //敌机左上
        B=(x+width<bx+bw)&&(x+width>bx)&&(y<by+bh)&&(y>by);  //敌机右上
        C=(x<bx+bw)&&(x>bx)&&(y+height<by+bh)&&(y+height>by);//敌机左下
        D=(x+width<bx+bw)&&(x+width>bx)&&(y+height<by+bh)&&(y+height>by);//敌机右下
        E=(x+width/2<bx+bw)&&(x+width/2>bx)&&(y+height/2<by+bh)&&(y+height/2>by);
        m1=A||B||C||D||E;

        return m1;
    }
    public boolean Bbang3(Bullet3 b){ //鏁屾満鍦ㄥ瓙寮瑰唴

        int bx=b.x3;
        int by=b.y3;
        int bw=b.width;
        int bh=b.height;


        boolean m1,A,B,C,D,E;
        A=(x<bx+bw)&&(x>bx)&&(y<by+bh)&&(y>by);  //敌机左上
        B=(x+width<bx+bw)&&(x+width>bx)&&(y<by+bh)&&(y>by);  //敌机右上
        C=(x<bx+bw)&&(x>bx)&&(y+height<by+bh)&&(y+height>by);//敌机左下
        D=(x+width<bx+bw)&&(x+width>bx)&&(y+height<by+bh)&&(y+height>by);//敌机右下
        E=(x+width/2<bx+bw)&&(x+width/2>bx)&&(y+height/2<by+bh)&&(y+height/2>by);
        m1=A||B||C||D||E;

        return m1;
    }

}
