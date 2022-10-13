package com.example.gerenciadordecarros.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carros")
public class Carro implements Serializable {

    private static final long serialVersionUID = 1848135320742265025L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "id_fabricante", referencedColumnName = "id")
    private Fabricante fabricante;
    @OneToOne
    private Documento documento;
    @OneToOne
    private Chave chave;
    @ManyToMany
    @JoinTable(
    		name = "carro_acessorio",
    		joinColumns = { @JoinColumn(name = "carro_id")},
    		inverseJoinColumns = { @JoinColumn(name = "acessorio_id")}
    )
    private List<Acessorio> acessorios;
    
    public Carro() {
		super();
	}

	public Carro(Integer id, String modelo, Fabricante fabricante, Documento documento, Chave chave,
			List<Acessorio> acessorios) {
		this.id = id;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.documento = documento;
		this.chave = chave;
		this.acessorios = acessorios;
	}

	public Carro(String modelo, Fabricante fabricante, Documento documento, Chave chave, List<Acessorio> acessorios) {
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.documento = documento;
		this.chave = chave;
		this.acessorios = acessorios;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
    
}
