/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circularshift;

import blueprint.InterfacePrint;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vivek Parekh
 */
public interface CSInter extends InterfacePrint
{    
    public abstract List<String> getCircularShiftedLines(List<String>a);
}
    //public List<String> getCircularShiftedLines();
    //public void circularShiftAllLines();
    //public List<String> circularShiftOneLine(String line);
    //public String[] linetoTokens(String line);