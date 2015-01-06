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
public interface OutputStorageInterFace {
    public void onputLines(List<String> lines,JTextArea j);
    public void onputCSLines(List<String> lines,JTextArea j);
}
