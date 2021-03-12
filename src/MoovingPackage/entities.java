/*
 * Esta classe tem como objetivo a representação de todas grande parte
 * das entidades representadas dentro do programa, entidades como o canhão,
 * alienígena e os tiros.
 * Contém informações básicas como a posição da entidade dentro da matriz board,
 * velocidade de movimento que será relacionado em ourtra etapa, simbolo defalt'.' e etc
 */
package MoovingPackage;

/**
 *
 * @author willi
 */
public class entities {
    
    public canon ship;
    
    private char symbol = '.';
    
    private int posX;
    private int posY;
    protected int index;

    public entities(int posX, int posY, int index) {
        this.posX = posX;
        this.posY = posY;
        this.index = index;
    }
    
    
    public void mooveEntitieAlien(int dx, int dy){// Seu método de movimentação correto se encontra na subclasse alien
        
    }
    
    

    public int getPosX() { //retorna posição da entidade
        return posX;
    }

    public void setPosX(int dx) {//seta a posição da entidade
        this.posX += dx;
    }

    public int getPosY() {//retorna posição da entidade
        return posY;
    }

    public void setPosY(int dy) {//seta a posição da entidade
        this.posY += dy;
    }
    
    public char getSymbol(){//retorna o simbolo de uma entidade defalt(não canhao e não alienígena, um espaço em branco na matriz '.')
        return this.symbol;
    }
    
  
    public int getIndex(){
        return this.index;
    }
        
    
    
    
}
