/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabb3;

import java.util.List;

/**
 *
 * @author Jonathan
 */
public interface ChatInterface {

    public void  addMessage( Message msg );
            
    public List< Message > getMessages();
}
