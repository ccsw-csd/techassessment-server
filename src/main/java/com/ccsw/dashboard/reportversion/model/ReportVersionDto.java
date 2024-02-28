package com.ccsw.dashboard.reportversion.model;

import java.time.LocalDateTime;

import com.ccsw.dashboard.roleversion.model.RoleVersionDto;
import com.ccsw.dashboard.staffingversion.model.StaffingVersionDto;


public class ReportVersionDto {
	

	private Long id;
    private RoleVersionDto idVersionCapacidades;
    private StaffingVersionDto idVersionStaffing;
    private int screenshot;
    private LocalDateTime fechaImportacion;
    private String descripcion;
    private String usuario;
    private LocalDateTime fechaModificacion;
    private String comentarios;       
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
	public RoleVersionDto getIdVersionCapacidades() {
		return idVersionCapacidades;
	}
	public void setIdVersionCapacidades(RoleVersionDto idVersionCapacidades) {
		this.idVersionCapacidades = idVersionCapacidades;
	}
	public StaffingVersionDto getIdVersionStaffing() {
		return idVersionStaffing;
	}
	public void setIdVersionStaffing(StaffingVersionDto idVersionStaffing) {
		this.idVersionStaffing = idVersionStaffing;
	}
	public int getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(int screenshot) {
		this.screenshot = screenshot;
	}
	public LocalDateTime getFechaImportacion() {
		return fechaImportacion;
	}
	public void setFechaImportacion(LocalDateTime fechaImportacion) {
		this.fechaImportacion = fechaImportacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
