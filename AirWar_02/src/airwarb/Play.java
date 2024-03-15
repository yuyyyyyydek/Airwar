package airwarb;

public class Play {

    int score=0;
    static int PlayX=175;
    static int PlayY=500;
    int width=50;
    int height=50;
   static  int life=30;

public boolean Pbang(Enemy e){//判定玩家英雄机与敌方
    int ex=e.x;
    int ey=e.y;
    int ew=e.width;
    int eh=e.height;

    boolean a,b,c,d,m,q;
    a=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+20<ey+eh)&&(PlayY+20>ey);//左上
    b=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+20<ey+eh)&&(PlayY+20>ey);//右上
    c=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//左下
    d=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//右下
    q=(PlayX+width/2<ex+ew)&&(PlayX+width/2>ex)&&(PlayY+height/2<ey+eh)&&(PlayY+height/2>ey);



    m=a||b||c||d||q;
    return m;
}




public boolean Pbang2(EB e){//与d子弹
    int ex=e.x;
    int ey=e.y;
    int ew=e.width;
    int eh=e.height;

    boolean a,b,c,d,m,q;
    a=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);//左上
    b=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);//右上
    c=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//左下
    d=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//右下
    q=(PlayX+width/2<ex+ew)&&(PlayX+width/2>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);



    m=a||b||c||d||q;
    return m;
}

public boolean Pbang2(XBOB e){//判定玩家英雄机与B
    int ex=e.x;
    int ey=e.y;
    int ew=e.width;
    int eh=e.height;
    boolean a,b,c,d,m,q;
    a=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);//左上
    b=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);//右上
    c=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//左下
    d=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//右下
    q=(PlayX+width/2<ex+ew)&&(PlayX+width/2>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);



    m=a||b||c||d||q;
    return m;
}



}

