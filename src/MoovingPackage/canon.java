/*
 * possui as propriedades e particularidades do canhão, controlado pelo jogador.
 */
package MoovingPackage;

import javafx.scene.image.Image;

/**
 *
 * @author willi
 */
public class canon extends entities {
    
    private shot tiro;
    private int vidas = 3;//quantidade de vidas
    
    //private char symbol = 'O';//simbolo do canhão
    public Image spaceShip = new Image("nave.png",60,50,false,false);
    private boolean destroy = false;//boolen resposável pela integridade do canhão, vivo/destruido
    

    public canon(int posX, int posY,int speed) {
        super(posX, posY, speed); 
        
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas() {
        this.vidas -= 1;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }
    
    
    
    
    
    
  
    
   
    
}
