package com.example.gerenciadordecarros.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "documentos")
public class Documento implements Serializable {

    private static final long serialVersionUID = 642319745831864005L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="tipo")
    private String tipo;

    @Column(name="numero")
    private String numero;
    
    public Documento() {
		super();
	}
    
	public Documento(int id, String tipo, String numero) {
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
	}

	public Documento(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
