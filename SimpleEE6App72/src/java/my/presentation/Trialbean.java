/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

/**
 *
 * @author Vivek Parekh
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import boundary.MessageFacade;
import entities.Message;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Vivek Parekh
 */
@ManagedBean(name = "TrialBean1")
@SessionScoped
public class Trialbean {
    List<Message> dataList = new ArrayList<Message>();
    @EJB
    private MessageFacade messageFacade;
    private Integer pageSize=5;
    private Integer[]values=new Integer[3];

    public Integer[] getValues() {
        return values;
    }

    public void setValues(Integer[] values) {
        this.values = values;
    }
    
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public Trialbean()
    {
        values[0]=2;
        values[1]=5;
        values[2]=10;
    }
    private Message message;

    public Message getMessage() {
        return message;
    }

    public DataModel getDtmdl() {
        return dtmdl;
    }
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private DataModel dtmdl ;
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
   
   /*Paging Code*/
   public PaginationHelper getPagination() {

        if (pagination == null) {

            pagination = new PaginationHelper(this.pageSize) {
                @Override
                public int getItemsCount() {
                    return messageFacade.count();
                }

                @Override
                public DataModel createPageDataModel() {

                    return new ListDataModel(messageFacade.findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }
   
   public DataModel getdtmdl() {
        if (dtmdl == null) {
            dtmdl = getPagination().createPageDataModel();
        }
        return dtmdl;
    }
    private void recreateModel() {
        dtmdl = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    private void updateCurrentItem() {
        int count = messageFacade.count();
        if (selectedItemIndex >= count) {

            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;

            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {

                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            message = this.messageFacade.findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return null;
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return null;
    }
    public void valueChangeMethod(ValueChangeEvent e){
		this.pageSize=Integer.parseInt(e.getNewValue().toString());
                recreatePagination();
                this.dtmdl = getPagination().createPageDataModel();
	}
    
    
}
