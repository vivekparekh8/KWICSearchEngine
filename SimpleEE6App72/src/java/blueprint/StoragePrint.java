/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blueprint;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vivek Parekh
 */
public class StoragePrint implements InterfacePrint{
        public List<String> ls;
    public StoragePrint()
    {
        this.ls=new ArrayList<String>();
    }
    @Override
    public synchronized void addLines(String[] input) 
    {
        this.ls.clear();
        //System.out.println("Input Lines b4 adding to list:"+input[0]+"&"+input[1]);
        
        for(int i=0;i<input.length;i++)
        {
            this.ls.add(input[i]);
            //System.out.println("Inside for"+this.ls.size()+"Element: "+this.ls.get(i));
        }
//        System.out.println("after addlines"+this.ls.get(1));
    }
    @Override
    public List<String> getLines()
    {
        return ls;
    }
    
    
}
