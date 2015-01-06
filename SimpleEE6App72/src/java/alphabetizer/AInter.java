/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabetizer;

import blueprint.InterfacePrint;
import java.util.List;

/**
 *
 * @author Vivek Parekh
 */
public interface AInter extends InterfacePrint{
    public List<String> getAlphaShiftedLines(List<String> ms);
}
