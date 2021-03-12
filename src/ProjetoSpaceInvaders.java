/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willi
 */



import MoovingPackage.*;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class ProjetoSpaceInvaders extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       launch(args);
    
    }
    
    static canon spaceShip = spaceShip = new canon( 400, 520, 0);
    static ArrayList<shot> shotsArrey = new ArrayList();
    static ArrayList<shot> alienShot = new ArrayList();
    static HashSet<String> activeKeys;
    static Scene mainScene;
    
    @Override
    public void start(Stage stage){
        
        //gera os alienígenas em uma matriz de acordo coma  resolução da tela
        
        
        alien [][]mat = new alien[8][6];        
        for(int i = 0; i<8; i++){
            for(int j = 0;j<6; j++){      
                    mat[i][j] = new alien((i+1)*60, (j+1)*30, 0);    
            }
        } 
        
        stage.setTitle("Space Invaders");
        
        
        
        Group root = new Group();
        
       
        
        Canvas canvas = new Canvas(800, 600);
        
        GraphicsContext grafC = canvas.getGraphicsContext2D();
       
        root.getChildren().add(canvas);
        
        mainScene = new Scene(root);
        
        stage.setScene(mainScene);
        stage.setMaxHeight(600);
        stage.setMaxWidth(800);
        Image blackHole = new Image("blackHole.png");
        HandlersPrepare();
        int top1 = 8;
        int top2 = 6;
        Random rand = new Random();
        
        
        
    
        
        new AnimationTimer(){
            
            public void handle(long currentNanoTime) {
              
                grafC.clearRect(0, 0, 800, 600);
                grafC.drawImage(blackHole, 0, 0, 800, 600);
                
                /*int r1, r2;
                int randomShot = rand.nextInt(10);

                if(randomShot >= 4 ){
                    
                    r1 = rand.nextInt(8);
                    r2 = rand.nextInt(6);
                    System.out.println(r1);
                    System.out.println(r2);
                    shot shotAuxAlien;
                    shotAuxAlien= new shot(mat[r1][r2].getPosX(), mat[r1][r2].getPosY(), 5);
                    alienShot.add(shotAuxAlien);      
                    
                }
                
                for(int i = 0; i<alienShot.size(); i++){
                    System.out.println("passa aqui?");
                    alienShot.get(i).mooveEntitieShot(0, 1);
                    
                    if((alienShot.get(i).getPosX()> (spaceShip.getPosX()-25)) && (alienShot.get(i).getPosX()< (spaceShip.getPosX()+ 25))){
                        if(alienShot.get(i).getPosY()== spaceShip.getPosY() && spaceShip.isDestroy()==false){
                                    System.out.println("acerto mizeravi");
                                    spaceShip.setVidas();
                                    alienShot.remove(i);
                                    if(spaceShip.getVidas()<=0){
                                        spaceShip.setDestroy(true);
                                        System.exit(0);
                                    }
                                }
                    }
                    System.out.println("DESENHA FDP");
                    grafC.drawImage(alienShot.get(i).tiro,shotsArrey.get(i).getPosX() ,alienShot.get(i).getPosY());
                }*/
                
                
                
                for(int i = 0; i<shotsArrey.size(); i++){
                    shotsArrey.get(i).mooveEntitieShot(0, -1);
                    for(int j = 0; j<8 ; j++){
                        for(int k  = 0 ; k<6 ;k++){
                            if((shotsArrey.get(i).getPosX()> (mat[j][k].getPosX()-25)) && (shotsArrey.get(i).getPosX()< (mat[j][k].getPosX()+25))){
                                if(shotsArrey.get(i).getPosY()== mat[j][k].getPosY() && mat[j][k].getVida()==true){
                                    mat[j][k].setVida(false);
                                    shotsArrey.remove(i); 
                                }
                            }
                        }
                    }
                    grafC.drawImage(shotsArrey.get(i).tiro,shotsArrey.get(i).getPosX() ,shotsArrey.get(i).getPosY());
                }
                
                mooveShip();
                
                
                for(int i = 0;i<8;i++){
                    for(int j = 0; j<6;j++){
                        if(mat[i][j].getVida()==true){
                            grafC.drawImage(mat[i][j].invader,mat[i][j].getPosX() , mat[i][j].getPosY());
                        }
                    }
                }
                
                grafC.drawImage(spaceShip.spaceShip,spaceShip.getPosX(), spaceShip.getPosY());
                
                
                
                if(mat[7][0].getPosY()>300){                
                    System.exit(0);
                }
                    for(int i = 0; i<8 ; i++){
                        for(int j = 0; j<6 ; j++){
                            if(mat[7][0].getPosX()>750 && mat[i][j].getFlagDirec()==1){
                                mat[i][j].setFlagDirec(-1);
                                mat[i][j].setPosY(20);
                            }else if(mat[7][0].getPosX()< 430 && mat[i][j].getFlagDirec()==-1) {
                                mat[i][j].setFlagDirec(1);
                                mat[i][j].setPosY(20);
                            }else
                                mat[i][j].setPosX((mat[7][0].getFlagDirec())*1);
                        }
                    }   
                    
                    
            }  
        }.start();
        
      
     
        stage.show(); 
    }
    
    private static void mooveShip(){
        
            if(activeKeys.contains("SPACE")){
                System.out.println("banana");
                shot shotAux;
                shotAux= new shot(spaceShip.getPosX()+25, spaceShip.getPosY(), 5);
                shotsArrey.add(shotAux);
                
            }
            
            if(activeKeys.contains("LEFT")){
                if(spaceShip.getPosX()>10){
                        spaceShip.setPosX(-10);
                    }
            }
            if(activeKeys.contains("RIGHT")){   
                if(spaceShip.getPosX()< 720){
                    spaceShip.setPosX(10);
                   
                }
            }
            activeKeys.clear();
        
    }
    
    private static void HandlersPrepare()
    {
        
        activeKeys = new HashSet<>();
        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event)
            {
                activeKeys.add(event.getCode().toString());
            }
        });
        mainScene.setOnKeyReleased(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event)
            {
                activeKeys.remove(event.getCode().toString());
            }
        });
    }

    
    
}
