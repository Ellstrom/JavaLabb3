/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabb3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing. *;

/**
 *
 * @author Jonathan
 * Skapar publika J-komponenter
 */
public class MenuBar {
    
    public JMenuBar menuBar;
    public JMenu menu1, menu2;
    public JMenuItem exit;
    public JCheckBoxMenuItem PrChat, PuChat;
    public boolean enablePrivate;

    /**
     * 
     * @param ctp: Tar emot en ChatTextPanel som parameter, vilket är en annan klass.
     * Skapar Menubaren med File>Exit och Show>Public Chat/Private Chat. 
     */
    public MenuBar(final ChatTextPanel ctp){
        menuBar = new JMenuBar();
        menu1 = new JMenu("File");
        menuBar.add(menu1);
        
        exit = new JMenuItem("Exit");

        /**
         * gör så att rutan stängs om man klickar på file>exit.
         */
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
    
        menu1.add(exit);
        
        
        
        menu2 = new JMenu("Show");
        menuBar.add(menu2);
        
        PrChat = new JCheckBoxMenuItem("Private Chat");
        /**
         * Om du klickar på Private Chat så markeras den och Public Chat avmarkeras. enablePrivate = true.
         */
        PrChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton aButton = (AbstractButton) e.getSource();
                boolean selected1 = aButton.getModel().isSelected();
                if (selected1) {
                    ctp.yText.setText("");
                    PuChat.setSelected(false);
                    enablePrivate = true;             
                } 
            }
        });
        
 
        menu2.add(PrChat);
        
        PuChat = new JCheckBoxMenuItem("Public Chat");
        /**
         * Om du klickar på Public Chat så markeras den och Private chat avmarkeras. enablePrivate = false.
         * Ändrar labeln på FriendListPaneln om du klickar på ett nickname, Skriver ut personens chat i chatrutan.
         */
        PuChat.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                AbstractButton bButton = (AbstractButton) e.getSource();
                boolean selected2 = bButton.getModel().isSelected();
                if (selected2) {
                    PrChat.setSelected(false);
                    userName u = new userName();
                    ctp.label.setText("Chat " + u.get());
                    ChatLog cl = new ChatLog();
                    
                    cl.readFile(u.get());
                    ctp.yText.setText(cl.print());
                    enablePrivate = false;
                } else {
                    System.out.println("Public Chat not selected");
                }
            }
        });
        menu2.add(PuChat);
        
    }
}
