package airwarb;

import java.awt.Image;
import java.awt.Toolkit;

public class GetImage{
    private GetImage(){}
    public static Image getImage(String path){
        Image img=Toolkit.getDefaultToolkit().getImage(GetImage.class.getClassLoader().getResource(path));


        return img;

    }



}