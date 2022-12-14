package com.example.gerenciadordecarros.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chaves")
public class Chave implements Serializable {

    private static final long serialVersionUID = 1734132513458272458L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigo;
    
    public Chave() {
		super();
    }

	public Chave(int id, String codigo) {
		this.id = id;
		this.codigo = codigo;
	}

	public Chave(String codigo) {
		super();
		this.codigo = codigo;
	}

	public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setId(int id) {
        this.id = id;
    }
}
