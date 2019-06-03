package projekat.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the "Nacionalnost" database table.
 * 
 */
@Entity
@Table(name="\"Nacionalnost\"")
@NamedQuery(name="Nacionalnost.findAll", query="SELECT n FROM Nacionalnost n")
public class Nacionalnost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="\"Naziv\"")
	private String naziv;

	@Column(name="\"Skracenica\"")
	private String skracenica;

	//bi-directional many-to-one association to Igrac
	@OneToMany(mappedBy="nacionalnostBean")
	@JsonIgnore
	private List<Igrac> igracs;

	public Nacionalnost() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkracenica() {
		return this.skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}

	public List<Igrac> getIgracs() {
		return this.igracs;
	}

	public void setIgracs(List<Igrac> igracs) {
		this.igracs = igracs;
	}

	public Igrac addIgrac(Igrac igrac) {
		getIgracs().add(igrac);
		igrac.setNacionalnostBean(this);

		return igrac;
	}

	public Igrac removeIgrac(Igrac igrac) {
		getIgracs().remove(igrac);
		igrac.setNacionalnostBean(null);

		return igrac;
	}

}