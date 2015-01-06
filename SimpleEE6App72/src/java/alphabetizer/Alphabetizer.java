/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabetizer;

import blueprint.StoragePrint;
import java.util.List;
import circularshift.CircularShift;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/**
 *
 * @author Vivek Parekh
 */
public class Alphabetizer extends StoragePrint implements AInter {
    public Alphabetizer()
    {
        super();
    }
     private void filterLines(List<String> in) {
        Iterator<String> iter = in.iterator();
          while(iter.hasNext()){
              if(iter.next().startsWith("a"))
              {
                  iter.remove();
              }
          }

          System.out.println("list::"+in);
    }

    @Override
    public List<String> getAlphaShiftedLines(List<String> vp) {
        //Ignoring the case
        System.out.println("passsed form cshift"+vp.get(0));
        filterLines(vp);
        System.out.println("Pre Alpha"+vp.get(0));
        Collections.sort(vp, new Comparator<String>() {
                        public int compare(String a, String b) {
                                return a.compareToIgnoreCase(b);
                        }
                });
        System.out.println("Aftr alpha"+vp.get(0));
        this.ls.clear();
        this.ls.addAll(vp);
        return vp;
    }

    
}
