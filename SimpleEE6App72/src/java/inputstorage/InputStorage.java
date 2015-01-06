/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inputstorage;

import blueprint.InterfacePrint;
import blueprint.StoragePrint;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vivek Parekh
 */
public class InputStorage extends StoragePrint implements InputStorageInterface
{
    public InputStorage()
    {
        super();
        System.out.println("Input Storage: "+this.ls.size());
    } 
}

    
    /*
    @Override
    public synchronized List<String> getLines() {
        System.out.println("In getLines"+this.inputLines.size());
        return this.inputLines;
    }    
    @Override
    public synchronized void setLines(String[] input) {
        //this.inputLines.clear();
        System.out.println("Input Lines b4 adding to list:"+input[0]+"&"+input[1]);
        
        for(int i=0;i<input.length;i++)
        {
            this.inputLines.add(input[i]);
            System.out.println("Inside for"+this.inputLines.size()+"Element: "+this.inputLines.get(i));
        }
        System.out.println("In InputStorage"+this.inputLines.get(1));
    }
}
*/