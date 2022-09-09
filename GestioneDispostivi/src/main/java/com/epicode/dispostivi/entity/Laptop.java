package com.epicode.dispostivi.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptops")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptop extends Dispositivi {
	
	private String operatingSystem;

//	public Laptop() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Laptop(Long id, Integer schermo, String marca, TipoStato tipoStato) {
//		super(id, schermo, marca, tipoStato);
//		// TODO Auto-generated constructor stub
//	}

}
