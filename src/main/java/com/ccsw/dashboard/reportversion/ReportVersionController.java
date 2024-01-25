package com.ccsw.dashboard.reportversion;


import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.dashboard.reportversion.model.ReportVersion;
import com.ccsw.dashboard.reportversion.model.ReportVersionDto;

@RequestMapping(value = "/reportimports")
@RestController
public class ReportVersionController {

    @Autowired
    private ReportVersionService reportVersionService;
    
    @Autowired
    DozerBeanMapper mapper;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<ReportVersion> findAll(){        
        return this.reportVersionService.findAll(); 
    }
    
    @RequestMapping(path = "/all/{year}", method = RequestMethod.GET)
    public List<ReportVersionDto> findAllYear(@PathVariable String year){       
    	return this.reportVersionService.findAll().stream().filter(rv->String.valueOf(rv.getFechaImportacion().getYear()).equals(year))
    			//.map(rv->mapper.map(rv, ReportVersionDto.class))
    			.map(rv-> { 
	    			ReportVersionDto rvdto = new ReportVersionDto();
	    			rvdto.setId(rv.getId());	    			
	    			rvdto.setIdVersionCapacidades(rv.getIdVersionCapacidades());
	    			rvdto.setIdVersionStaffing(rv.getIdVersionStaffing());
	    			rvdto.setUsuario(rv.getUsuario());
	    			rvdto.setDescripcion(rv.getDescripcion());
	    			rvdto.setScreenshot(rv.getScreenshot());
	    			rvdto.setComentarios(rv.getComentarios());
	    			rvdto.setFechaImportacion(rv.getFechaImportacion());
	    			rvdto.setFechaModificacion(rv.getFechaModificacion());
	    			return rvdto;
    			})
    			.toList();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ReportVersion findById(@PathVariable String id){
        return this.reportVersionService.findByIdVersionCapacidades(Long.valueOf(id));     
    }
    
    @RequestMapping(path = "/years", method = RequestMethod.GET)
    public List<String> findYears(){
       return this.reportVersionService.findYears();
    }
    
    @RequestMapping(path = { "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ReportVersionDto dto) {
        this.reportVersionService.save(id, dto);
    }
}
