package airwarb;

public class Play {

    int score=0;
    static int PlayX=175;
    static int PlayY=500;
    int width=50;
    int height=50;
   static  int life=30;

public boolean Pbang(Enemy e){//�ж����Ӣ�ۻ���з�
    int ex=e.x;
    int ey=e.y;
    int ew=e.width;
    int eh=e.height;

    boolean a,b,c,d,m,q;
    a=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+20<ey+eh)&&(PlayY+20>ey);//����
    b=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+20<ey+eh)&&(PlayY+20>ey);//����
    c=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//����
    d=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//����
    q=(PlayX+width/2<ex+ew)&&(PlayX+width/2>ex)&&(PlayY+height/2<ey+eh)&&(PlayY+height/2>ey);



    m=a||b||c||d||q;
    return m;
}




public boolean Pbang2(EB e){//��d�ӵ�
    int ex=e.x;
    int ey=e.y;
    int ew=e.width;
    int eh=e.height;

    boolean a,b,c,d,m,q;
    a=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);//����
    b=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);//����
    c=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//����
    d=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//����
    q=(PlayX+width/2<ex+ew)&&(PlayX+width/2>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);



    m=a||b||c||d||q;
    return m;
}

public boolean Pbang2(XBOB e){//�ж����Ӣ�ۻ���B
    int ex=e.x;
    int ey=e.y;
    int ew=e.width;
    int eh=e.height;
    boolean a,b,c,d,m,q;
    a=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);//����
    b=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);//����
    c=(PlayX+10<ex+ew)&&(PlayX+10>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//����
    d=(PlayX+width-8<ex+ew)&&(PlayX+width-8>ex)&&(PlayY+height<ey+eh)&&(PlayY+height>ey);//����
    q=(PlayX+width/2<ex+ew)&&(PlayX+width/2>ex)&&(PlayY+10<ey+eh)&&(PlayY+10>ey);



    m=a||b||c||d||q;
    return m;
}



}

