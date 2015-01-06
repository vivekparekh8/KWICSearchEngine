/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Vivek Parekh
 */
@ManagedBean(name = "MessageView1")
@RequestScoped
public class MessageView1 {
    List<Message> dataList = new ArrayList<Message>();
    @EJB
    private MessageFacade messageFacade;
    
    
   public List<Message> getDataList() {
        this.dataList = messageFacade.findAll();
        System.out.print(this.dataList.get(0).getMessage());
        return this.dataList;
    }
   public String deleteURL(Message m)
   {
       System.out.println("To be deleted"+m.getId()+m.getURL()+m.getMessage());
       messageFacade.remove(m);
       this.dataList = messageFacade.findAll();
       return null;
   }
    
    
}
