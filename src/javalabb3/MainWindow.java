/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabb3;





import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;


/**
 *
 * @author Jonathan
 * Gör en publik Jframe "myFrame".
 */
public class MainWindow extends JFrame { 
    

    public static JFrame myFrame; 
        /**
         * Gör en JFrame, lägger till panelen från FriendListPanel till EAST och panelen från ChatTextPanel till CENTER.
         */
        public MainWindow(){
    
        myFrame = new JFrame();      
        myFrame.setTitle("Hello world");
        Dimension frameSize = new Dimension(410,320);
        myFrame.setSize(frameSize);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        myFrame.revalidate();
        myFrame.repaint();
            
        ChatTextPanel panel1 = new ChatTextPanel();
        MenuBar myMenu = new MenuBar(panel1);
        myFrame.setJMenuBar(myMenu.menuBar);
        FriendListPanel panel2 = new FriendListPanel(panel1, myMenu);
               
        myFrame.add(panel2.t, BorderLayout.EAST);
        myFrame.add(panel1.p, BorderLayout.CENTER);
        
        
        myFrame.pack();
        myFrame.revalidate();
        myFrame.repaint();
        
    }       
}
