package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String pagador;
	private String documento;
	private Double iva;
	private Double reteIva;
	private Double reteIca;
	private Double reteFuente;
	private String productos;
	private Double total;
	
	public Factura() {
		super();
	}

	public Factura(Integer id, String pagador, String documento, Double iva, Double reteIva, Double reteIca,
			Double reteFuente, String productos, Double total) {
		super();
		Id = id;
		this.pagador = pagador;
		this.documento = documento;
		this.iva = iva;
		this.reteIva = reteIva;
		this.reteIca = reteIca;
		this.reteFuente = reteFuente;
		this.productos = productos;
		this.total = total;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPagador() {
		return pagador;
	}

	public void setPagador(String pagador) {
		this.pagador = pagador;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getReteIva() {
		return reteIva;
	}

	public void setReteIva(Double reteIva) {
		this.reteIva = reteIva;
	}

	public Double getReteIca() {
		return reteIca;
	}

	public void setReteIca(Double reteIca) {
		this.reteIca = reteIca;
	}

	public Double getReteFuente() {
		return reteFuente;
	}

	public void setReteFuente(Double reteFuente) {
		this.reteFuente = reteFuente;
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [Id=" + Id + ", pagador=" + pagador + ", documento=" + documento + ", iva=" + iva + ", reteIva="
				+ reteIva + ", reteIca=" + reteIca + ", reteFuente=" + reteFuente + ", productos=" + productos
				+ ", total=" + total + "]";
	}
	
}
