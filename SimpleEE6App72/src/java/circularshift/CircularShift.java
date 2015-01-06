/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circularshift;

import blueprint.StoragePrint;
import inputstorage.InputStorageInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Vivek Parekh
 */
public class CircularShift extends StoragePrint implements CSInter
{
    
    @Override
    public List<String> getCircularShiftedLines(List<String> a) {
       this.circularShiftAllLines(a);
       return this.ls;
    }

 
    public void circularShiftAllLines(List<String>a) 
    {
        List<String> circularShiftedLines; 
        circularShiftedLines = new ArrayList<String>();
        System.out.println("In the function circ shift all: "+a.size());
        int i=0;
        for (String linet : a) 
        {
                       circularShiftedLines.addAll(circularShiftOneLine(linet));
                       //System.out.println("All lines: "+circularShiftedLines.get(i++));
        }
            
                this.ls.clear();
                this.ls.addAll(circularShiftedLines);
                System.out.println("CS lines separate : ");
                for(String ty:ls)
                {
                    System.out.println(ty);
                }

    }         
       /*System.out.println("In the function circ shift all: "+this.ls.size());
        for(int i=0;i<this.ls.size();i++)
        {
            circularShiftedLines.addAll(circularShiftOneLine(this.ls.get(i)));
        }   
         this.ls.clear();
         this.ls.addAll(circularShiftedLines);*/
    
    public String[] linetoTokens(String line) {
        String[] words = line.split(" ");
                return words;
    }
    protected String combineWordsToLine(String[] w) {
                String line = "";
                for (String word : w) {
                        line += word + " ";
                }
                line = line.substring(0, line.length() - 1);
                return line;
        }
    public List<String> circularShiftOneLine(String line) {
        List<String> l=new ArrayList<String>();
        l.add(line);
        String[] tokens=linetoTokens(line);
        String linetobepassed="";
        String temp="";
        for(int i=0;i<tokens.length-1;i++)
        {
            temp=tokens[0];
            for(int j=0;j<tokens.length-1;j++)
            {
                tokens[j]=tokens[j+1];
                linetobepassed=linetobepassed+tokens[j]+" ";
            }
            tokens[tokens.length-1]=temp;
            linetobepassed=combineWordsToLine(tokens);
            l.add(linetobepassed);
        }
        System.out.println("For one line");
        
        return l;
    }
   
  
   
    
}
    /*
    List<String> in=new ArrayList<>();
     List<String> circShifted=new ArrayList<String>();
    
    @Override
    public List<String> getCircularShiftedLines() {
       this.circularShiftAllLines();
       return this.circShifted;
    }

    @Override
    public void circularShiftAllLines() {
        this.circShifted.clear();
        this.in=inputLines;
        System.out.println("In the function circ shift all: "+inputLines.size());
        for(int i=0;i<in.size();i++)
        {
            this.circShifted.addAll(circularShiftOneLine(in.get(i)));
        }   
        
    }

    @Override
    public List<String> circularShiftOneLine(String line) {
        List<String> l=new ArrayList<>();
        String[] tokens=linetoTokens(line);
        String linetobepassed="null";
        for(int i=0;i<tokens.length-1;i++)
        {
            String temp=tokens[0];
            for(int j=0;j<tokens.length-1;j++)
            {
                tokens[j]=tokens[j+1];
                linetobepassed=linetobepassed+tokens[j]+" ";
            }
            tokens[tokens.length-1]=temp;
            linetobepassed=linetobepassed+temp+" ";
            linetobepassed=linetobepassed.substring(0,linetobepassed.length()-1);
            l.add(linetobepassed);
        }
        return l;
    }

    @Override
    public String[] linetoTokens(String line) {
        String[] words = line.split(" ");
                return words;
    }
 */   

