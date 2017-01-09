/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javalabb3;


import java.io. *; // BufferedReader och IOException
import java.util. *; // HashMap

/**
 *
 * @author joel1401
 * Innehåller metoderna readFile(), print() och pInfo
 * Skapar en publik HashMap "myMap".
 * HashMap istället för TreeMap pga att den är mer effektiv prestandamässigt. 
 */
public class FriendList
{
        
    HashMap <String, Friend> myMap = new HashMap <>(); 
    
    /**
     * Läser från en Friends.list filen och bygger upp en Map av Personens delar.
     */
    public void readFile(){
     
        String nickname;
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("logs/Friends.list"));
            while ((nickname = br.readLine()) != null) { 
                
                Friend person = new Friend();
                
                nickname = nickname.substring(1, nickname.length()-1);
                
                person.fullname = br.readLine();      
                person.lastip = br.readLine();                
                person.image = br.readLine();   
        
                myMap.put(nickname, person);
                }

        }
        
        catch (IOException e) {
        System.err.println("Could not find file, Error: " + e);
        }
    } 
  
    /**
     * 
     * @return: returerar en sträng på en persons nickname, fullname, lastip, och image.
     */
    public String print(){
    //public void print(){
        String line = "";               
        Iterator<String>  iterator = myMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Friend value = myMap.get(key);   
            line += key + "\n" + value.fullname + "\n" + value.lastip + "\n" + value.image + "\n" + " ";

        }   
        return(line);       
    }
    
    /**
     * 
     * @return: returnerar en stränga på en persons nickname.
     */
    public String printNickname(){
        String line = "";               
        Iterator<String>  iterator = myMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();           
            line += key+ "\n";
        }
        return(line);    
    }
    
    /**
     * 
     * @param n: Tar emot ett nickname och om den finns i mappen så returnerar den personens nickname, fullname, lastip, och image.
     * @return: om "n" finns i mappen så returnerar den personens nickname, fullname, lastip, och image.
     */
    public String pInfo(String n){
     
        if (myMap.containsKey(n) == false){
            return "Person did not exist";
        }

        else{
            Friend value = myMap.get(n);
            return(n + "\n" + value.fullname + "\n" + value.lastip + "\n" + value.image + "\n" + " ");

        }      
    } 
}