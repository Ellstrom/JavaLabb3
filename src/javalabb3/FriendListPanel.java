/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabb3;



import static javalabb3.MainWindow.myFrame;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.*;
import java.awt.font.*;

/**
 *
 * @author Jonathan
 * Skapar en publik JPanel "t", och en JList "list".
 */
public class FriendListPanel extends JPanel {
    
    public JPanel t;
    public JList list;
    //public JLabel label;
      
    
    
    
    /**
     * 
     * @param ctp: Tar emot en "ChatTextPanel" som en parameter, vilket är en annan klass.
     * @param mb : Tar emot en "Menubar" som en parameter, vilket är en annan klass.
     * Skapar en JScrollPanel på en JList som innehåller nicknames. 
     * Skapar en ListSelectionListener.
     * Gör en panel "p" som är en borderlayout där "Friends List" är i north och en klickbar JList list med nicknamsen i center.
     */
    public FriendListPanel(final ChatTextPanel ctp, final MenuBar mb){
        JLabel label;
        label = new JLabel("Friends List");
    
        
        final FriendList fl = new FriendList();
        final ChatLog cl = new ChatLog();
        fl.readFile();
        System.out.println(fl.printNickname());
      
        final String[] nicknames = fl.printNickname().split("\\s+");
        
        
        
        list = new JList(nicknames);
        list.repaint();
        list.revalidate();
        list.setVisibleRowCount(10);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        
        /**
         * Om boolen enablePrivate är sann (hanteras i klassen MenuBar), så lägger den till en viss persons chatt ifall man klickar på dess namn. 
         */
        list.addListSelectionListener(new ListSelectionListener(){    
            @Override     
            public void valueChanged(ListSelectionEvent event) {

                if (mb.enablePrivate == true){
                    cl.readFile(nicknames[list.getSelectedIndex()]);
                    ctp.yText.setText(cl.print());
                    ctp.label.setText("Chat " + nicknames[list.getSelectedIndex()]);  
                }
            }
        }); 

        fl.readFile();
        
        t = new JPanel(new BorderLayout());
        Dimension frameSize = new Dimension(120,150);
        list.setSize(frameSize);
        list.setSize(frameSize);

        setVisible(true);
   
        t.add(label,BorderLayout.NORTH);
        t.add(list,BorderLayout.CENTER);
    }
}
