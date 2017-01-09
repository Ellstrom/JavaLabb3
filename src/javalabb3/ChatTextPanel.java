/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabb3;


import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jonathan
 * Gör tre publika J-komponenter
 */
public class ChatTextPanel extends JPanel{

    public JPanel p;
    public JTextArea yText;
    public JLabel label;
    
    /**
     * Gör en JPanel "p" och lägger till en textruta i center och label i north.
     */
    public ChatTextPanel(){
        label = new JLabel("Chat PRIVATE");
        yText = new JTextArea(5,20);
        yText.setLineWrap(true);
        yText.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(yText);
       
        p = new JPanel(new BorderLayout());
        Dimension frameSize = new Dimension(200,150);
        setSize(frameSize);
        setVisible(true);

        p.add(scroll,BorderLayout.CENTER);
        p.add(label,BorderLayout.NORTH);
        }     
}
