package ec.edu.ups.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class FacesMessage {
	private FacesMessages msg;
	
	@PostConstruct
	public void ionit() {
		msg=new FacesMessages();
	}
	
    public void error() {
        msg.errorMessage("Error");
    }
 
    public void fatal() {
    	 msg.fatalMessage("Fatal");
    }
 
    public void delete() {
    	 msg.infoMessage("Infomesage");
    }
 
    public void buttonAction() {
    	 msg.warningMessage("Advertencia");
    }

}
