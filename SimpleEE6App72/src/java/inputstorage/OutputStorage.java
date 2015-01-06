/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inputstorage;

import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author Vivek Parekh
 */
public class OutputStorage implements OutputStorageInterFace{
public void onputCSLines(List<String> lines, JTextArea j) {
        j.setText("");
        for(String line:lines)
        {
            j.append(line);
            j.append("\n");
        }
        
    }
    @Override
    public void onputLines(List<String> lines, JTextArea j) {
        j.setText("");
        for(String line:lines)
        {
            j.append(line);
            j.append("\n");
        }
        
    }
    
}
