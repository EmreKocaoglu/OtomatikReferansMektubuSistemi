package com.baskent.OtomatikReferansMektubu.web.view;

import com.baskent.OtomatikReferansMektubu.web.entity.Ogrenci;
import com.baskent.OtomatikReferansMektubu.web.service.OgrenciService;
import com.baskent.OtomatikReferansMektubu.web.utilities.PagingResult;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Emre Kocaoglu
 */
@Controller("ogrenciView")
@Scope("view")
public class OgrenciView implements Serializable{
    private static final long serialVersionUID = -6657286050378044309L;
    @Autowired
    private transient OgrenciService ogrenciService;
    
    Ogrenci ogrenci;
    LazyDataModel<Ogrenci> lazyModel;

    public OgrenciView(OgrenciService ogrenciService) {
        super();
    }
    @PostConstruct
	private void init() {
		ogrenci=new Ogrenci();
		listele();
	}
    public void save() {
		try {
			if(ogrenci.getId()!=null){
				ogrenciService.update(ogrenci);
			}else{
				ogrenciService.save(ogrenci);
			}
			ogrenci=new Ogrenci();
			listele();
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata Olustu",  e.getMessage()) );
		}

	}
                public void listele(){
		lazyModel=new LazyDataModel<Ogrenci>() {
    
                    public List<Ogrenci> load(int first, int pageSize, String sortField, SortOrder sortOrder,Map<String, Object> filters) {
			
				PagingResult result = ogrenciService.getAllByPaging(first,pageSize,sortOrder , filters);
				this.setRowCount(result.getRowCount());
				return result.getList();
			}
                
                        public Ogrenci getRowData(String rowKey) {
			        for(Ogrenci o : lazyModel) {
			            if(o.getId().equals(rowKey))
			                return o;
			        }
			 
			        return null;
			    }
			
		};
                }
       public Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

	public LazyDataModel<Ogrenci> getLazyModel() {
		return lazyModel;
	}
}


