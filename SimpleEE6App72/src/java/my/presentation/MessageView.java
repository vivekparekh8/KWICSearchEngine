/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import MainControl.MasterControl;
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
 * @author nb
 */
@ManagedBean(name = "MessageView")
@RequestScoped
public class MessageView {
    @EJB
    private MessageFacade messageFacade;
    
    private Message message1;
    private List<Message> dataList = new ArrayList<Message>();

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message1 = new Message();
        //this.dataList = new ArrayList<Message>();
        
    }
    
    public Message getMessage1() {
        return message1;
    }
    
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }
    
    public List<Message> getDataList()
    {
        this.dataList=this.messageFacade.findAll();
        return dataList;
    }
    public String getListOfURLs(){
        List<Message> listOfURLs= new ArrayList<Message>(); 
        listOfURLs=messageFacade.findAll();
        String list= new String();
        for(int i=0; i<listOfURLs.size(); i++)
        {
            list += listOfURLs.get(i).getMessage() + listOfURLs.get(i).getURL()+"\n";
        }
        return list;
       // this.dataList = this.messageFacade.findAll();
    }
   
    public String postMessage() {
        //System.out.println(message.getMessage().length());
        List<String> messagesToMany = MasterControl.start(message1.getMessage().toString());
        for(int i=0;i <messagesToMany.size();i++)
        {
            Message message=new Message();
            message.setMessage(messagesToMany.get(i));
            message.setURL(message1.getURL());
            messageFacade.create(message);
        }
        return "listofurls";
    }
    
}
