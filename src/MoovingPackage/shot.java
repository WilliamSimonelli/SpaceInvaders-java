/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoovingPackage;

import javafx.scene.image.Image;

/**
 *
 * @author willi
 */
public class shot extends entities {
    
    public Image tiro = new Image("tiro2.png",10,30,false,false);
    private long time;
    
    public shot(int posX, int posY, int index) {
        super(posX, posY, index);
        
    }
    
    public void mooveEntitieShot(int dx, int dy){//este n se move conforme uma entrada do jogador, e sim com uma velocidade constante p/ cima ou p/ baixo 
        
        setPosY(dy*5);
    }
    
    
}
