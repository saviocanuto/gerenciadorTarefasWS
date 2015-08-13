package br.com.saviocanuto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_tarefas")
public class Tarefa implements Serializable {

	private static final long serialVersionUID = -8840457120458861245L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ISSUE")
	@SequenceGenerator(name="SEQ_ISSUE", sequenceName="SEQ_ISSUE", allocationSize=1)
	@Column(name="id_tarefa")
    private Long id;

	@Column(length=80)
    private String nome;

	@Column(length=80)
    private String responsavel;

	@Temporal(TemporalType.DATE)
    private Date prazo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

}