
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;


class Ates{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}

public class Oyun extends JPanel implements KeyListener,ActionListener{
    Timer timer = new Timer(5, this);
    private int gecenSure = 0;
    private int harcananAtes = 0;
    
    private BufferedImage image;
    
    ArrayList<Ates> atesler = new ArrayList<Ates>();
    
    private int atesdirY=1;//ateşi y ekseninde hareket için
    
    private int topX =0;//topun başlanğıc konumu
    private int topdirX=4;//topu sağa sola  gitmesi için
    
    private int uzayGemisiX=0;//uzay gemisinin nerden başladğını
    private int dirUzayGemisi=20;//her seferinde kayması için

    public Oyun() {
        try {
            image = ImageIO.read(new FileImageInputStream(new File("uzaygemisi.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setBackground(Color.BLACK);
        timer.start();
        
    }

    @Override
    public void paint(Graphics g) {
         super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        
        g.fillOval(topX, 0, 20, 20);//topu oluşturduk.
        
        g.drawImage(image, uzayGemisiX, 490,image.getWidth()/10,image.getHeight()/10,this);
        //burada ımage ayarladık ve projeye ekledik
        
      
    }

    
    @Override
    public void repaint() {//oyunlar için gerekli
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        topX += topdirX;
        
        if(topX>=750){
            topdirX = -topdirX;
        }
        if(topX<=0){
            topdirX = -topdirX;
        }
        repaint();
    }
    
}
