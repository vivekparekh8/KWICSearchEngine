/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import boundary.RecentFacade;
import entities.Message;
import entities.Recent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Vivek Parekh
 */
@ManagedBean(name = "MessageView2")
@SessionScoped
public class MessageView2 {
    @EJB
    MessageFacade messageFacade;
    @EJB
    RecentFacade rs;
    
    HashMap<String, String> listOfMatched ;
    List set;
    List setofr;

    public List getSetofr() {
        return setofr;
    }
    String keyword;
    int noOfResults;
    PagingInfo p = new PagingInfo();
    int searchsize;

    public int getNoOfResults() {
        return noOfResults;
    }

    public void setNoOfResults(int noOfResults) {
        this.noOfResults = noOfResults;
    }
    public List getSet() {
        return set;
    }

    public void setSet(List set) {
        this.set = set;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public HashMap<String,String> getListOfMatched() {
        return listOfMatched;
    }

    public void setListOfMatched(HashMap<String,String> listOfMatched) {
        this.listOfMatched = listOfMatched;
    }
    public String searchOr()
    {
        postKeyword();
        List<Message> list = messageFacade.findAll();
        this.listOfMatched=new HashMap<String,String>();
        String[] tokens = this.keyword.split(" ");
        for(int i=0;i < list.size() ; i++)
        {
            for(int j=0; j<tokens.length; j++)
            {
                if(list.get(i).getMessage().contains(tokens[j]))
                {
                    listOfMatched.put(list.get(i).getURL(),list.get(i).getMessage());
                }
            }
        }
        this.set = new ArrayList(this.listOfMatched.entrySet());
        this.searchsize=this.set.size();
        this.getRecent();
       // this.listOfMatched = new ArrayList<Message>(new HashSet<Message>(listOfMatched));
        return null;
    }
    
    public String searchAnd()
    { 
        postKeyword();
        List<Message> list = messageFacade.findAll();
        this.listOfMatched=new HashMap<String,String>();
        for(int i=0;i < list.size() ; i++)
        {
            if(list.get(i).getMessage().equals(this.keyword))
            {
                listOfMatched.put(list.get(i).getURL(),list.get(i).getMessage());
            }
        }
        this.set = new ArrayList(this.listOfMatched.entrySet());
        this.searchsize=this.set.size();
        this.getRecent();
        return null;
    }
    public String searchNot()
    {
        postKeyword();
        List<Message> list = messageFacade.findAll();
        this.listOfMatched=new HashMap<String,String>();
        String[] tokens = this.keyword.split(" ");
        for(int i=0;i < list.size() ; i++)
        {
            for(int j=0; j<tokens.length; j++)
            {
                if(!(list.get(i).getMessage().contains(tokens[j])))
                {
                    listOfMatched.put(list.get(i).getURL(),list.get(i).getMessage());
                }
            }
        }
        this.set = new ArrayList(this.listOfMatched.entrySet());
        this.searchsize=this.set.size();
        this.getRecent();
       // this.listOfMatched = new ArrayList<Message>(new HashSet<Message>(listOfMatched));
        return null;
    }
    
    public String rangedSearch(int start,int end)
    {
        int[] arrayOfRange={start,end};
        List<Message> local=this.messageFacade.findRange(arrayOfRange);
        return null;
    }
    public String nextNResults()
    {
        this.p.setBatchSize(this.noOfResults);
        this.p.setItemCount(this.searchsize);
        this.p.nextPage();
        int start = this.p.getFirstItem();
        int end = this.p.getLastItem();
        int[]range={start,end};
       // List<Message> local=this.messageFacade.findRange(range);
        for(int i=start ; i< end ; i++)
        {
            System.out.println(this.set.get(i));
        }
        
       
        return "null";
    }  
    public void postKeyword()
    {
        Recent r=new Recent();
        r.setWords(keyword);
        rs.create(r);
    }
    public void getRecent()
    {
        List<Recent> listofr=this.rs.findAll();
        HashMap<Long,String> a = new HashMap<Long, String>();
        for(int i=0;i<listofr.size();i++)
        {
            a.put(listofr.get(i).getId(),listofr.get(i).getWords());
        }
       this.setofr=new ArrayList(a.entrySet());
    }
}
