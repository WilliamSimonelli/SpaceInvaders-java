/*
 * subclasse de entidade. Representa cada alinígena do jogo, e possui
 * suas respectivas diferenças da classe mãe.
 * and open the template in the editor.
 */
package MoovingPackage;

import javafx.scene.image.Image;

/**
 *
 * @author willi
 */
public class alien extends entities{
    
    //private char symbol = 'X'; //diferenciação de uma entidade defalt para uma entidade alienígena
    private shot tiro;  //este atira
    private int index;
    private int  flagDirec = 1;
    private boolean vida = true;
    public Image invader = new Image("alien.png",30,20,false,false);
    
    
    public alien(int posX, int posY,int index) {
        super(posX, posY, index);
    }
    
    @Override
    public void mooveEntitieAlien(int dx, int dy){ //implementa o movimento dos alienígenas dentro da matriz conforme uma 
        setPosX(dx);
        setPosY(dy);                                         
    }
    
    //@Override
    //public char getSymbol(){//retorna simbolo do alienígena
        //return this.symbol;
    //}
    
    @Override
    public int getIndex(){
        return this.index;
    }
    
    public boolean getVida(){
        return this.vida;
    }
    
    public void setVida(Boolean vida) { 
        this.vida = vida; 
    }
    
    public int getFlagDirec(){
        return this.flagDirec;
    }
    
    public void setFlagDirec(int flagDirec) { 
        this.flagDirec = flagDirec;
    }
    
    
    
}


