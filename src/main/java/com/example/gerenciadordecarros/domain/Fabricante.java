package com.example.gerenciadordecarros.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fabricantes")
public class Fabricante implements Serializable {

    private static final long serialVersionUID = 3505973152444949958L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    
    public Fabricante() {
		super();
	}

	public Fabricante(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Fabricante(String nome) {
		this.nome = nome;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
