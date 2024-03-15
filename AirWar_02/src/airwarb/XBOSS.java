package airwarb;

public class XBOSS {
	 int  x=50,width=300,height=300,speed=1;
	 int life=100;
	 static int y=-300; 
	 
	 







	    public boolean Bbang1(Bullet b){ //敌机在子弹内

	        int bx=b.x;
	        int by=b.y;
	        int bw=b.width;
	        int bh=b.height;


	   boolean E;
	        
	        

	   E=(bx+bw<=x+width)&&(bx+bw>=x)&&(by+bh<=y+height)&&(by+bh>=y);
	        
	        return E;
	    }
	    
	    public boolean Bbang2(Bullet2 b){ //敌机在子弹内

	        int bx=b.x2;
	        int by=b.y2;
	        int bw=b.width;
	        int bh=b.height;


	        boolean E;
	        
	        

	        E=(bx+bw<=x+width)&&(bx+bw>=x)&&(by+bh<=y+height)&&(by+bh>=y);
	        
	        return E;
	    }
	    public boolean Bbang3(Bullet3 b){ //敌机在子弹内=
	        int bx=b.x3;
	        int by=b.y3;
	        int bw=b.width;
	        int bh=b.height;

	   boolean E;

	   E=(bx+bw<=x+width)&&(bx+bw>=x)&&(by+bh<=y+height)&&(by+bh>=y);
	        
	        return E;
	    }

	}
