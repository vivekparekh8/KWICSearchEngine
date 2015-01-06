/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainControl;

import alphabetizer.AInter;
import alphabetizer.Alphabetizer;
import circularshift.CSInter;
import circularshift.CircularShift;
import inputstorage.InputStorage;
import inputstorage.InputStorageInterface;
import inputstorage.OutputStorage;
import inputstorage.OutputStorageInterFace;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author Vivek Parekh
 */
public class MasterControl {
    private static InputStorageInterface input=new InputStorage();
    private static OutputStorageInterFace output=new OutputStorage();
   
    private static CSInter cs=new CircularShift();
    private static AInter ai=new Alphabetizer();
    
    
    public static List<String> start(String a)
    {
        String[] lines=a.toString().split("@");
        System.out.println(lines[0]);
//        System.out.println(lines[1]);
        input.addLines(lines);
        System.out.println("Size of ls"+input.getLines().size());
       // cs.getCircularShiftedLines(input.getLines());
        System.out.println(input.getLines().size());
        List<String> CSlines=new ArrayList<String>();
        CSlines=cs.getCircularShiftedLines(input.getLines());
        //output.onputCSLines(CSlines,c);
       List<String> out=ai.getAlphaShiftedLines(CSlines);
       return out;
    }
}
