/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabb3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 *
 * @author joel1401
 * Innehåller metoden "userName"
 */
public class userName {
    
    /**
     * Metoden läser från filen Username.txt och sätter att userName är lika med första raden i det dokumentet.
     * @return: returnerar strängen, dvs usernamet.
     */
    public String get(){
        String thisLine;
        String userName = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("logs\\Username.txt"));
            while ((thisLine = br.readLine()) != null) {
                userName = thisLine;
            }
            
        } 
        catch (IOException e) {
            System.err.println("File not found., Error: " + e);
        }
       
        return userName;
    }   
}
