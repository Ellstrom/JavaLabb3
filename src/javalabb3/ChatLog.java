/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javalabb3;


import java.io. *; // BufferedReader och IOException
import java.util. *; // ArrayList


/**
 *
 * @author joel1401
 * Har metoderna readFile() och print().
 * Skapar en public ArrayList a1.
 */
public class ChatLog 
{
    
    public ArrayList a1 = new ArrayList();
    
    /**
     * 
     * @param u: Tar emot en sträng, userName som parameter.
     * Bygger upp en ArrayList med det som står i filen.
     */
    public void readFile(String u){
     
        String username = "logs\\" + u + ".log";
        a1.clear();
        String thisLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(username));
            while ((thisLine = br.readLine()) != null) { 
                a1.add(thisLine);
            } 
        } 
        catch (IOException e) {
            System.err.println("File not found., Error: " + e);
            a1.add("File not found.");
        }        
    }
        
    /**
     * 
     * @return: returnerar strängen på det som fanns i filen.
     */
    public String print(){

        String line = "";        
        int i;
        for(i=0; i < a1.size(); i++)
            line += a1.get(i) +"\n";
        return(line);
      }
    }
    





