package com.example.demo.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the igrac database table.
 * 
 */
@Entity
@Table(name="\"igrac\"")
@NamedQuery(name="igrac.findAll", query="SELECT i FROM Igrac i")
public class Igrac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="broj_red")
	private String brojRed;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_rodjenja")
	private Date datumRodjenja;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Nacionalnost
	@ManyToOne
	@JoinColumn(name="nacionalnost")
	private Nacionalnost nacionalnostBean;

	//bi-directional many-to-one association to Tim
	@ManyToOne
	@JoinColumn(name="tim")
	private Tim timBean;

	public Igrac() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrojRed() {
		return this.brojRed;
	}

	public void setBrojRed(String brojRed) {
		this.brojRed = brojRed;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Nacionalnost getNacionalnostBean() {
		return this.nacionalnostBean;
	}

	public void setNacionalnostBean(Nacionalnost nacionalnostBean) {
		this.nacionalnostBean = nacionalnostBean;
	}

	public Tim getTimBean() {
		return this.timBean;
	}

	public void setTimBean(Tim timBean) {
		this.timBean = timBean;
	}

}