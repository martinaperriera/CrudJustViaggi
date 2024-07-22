package com.example.demo.model;

import java.util.Date;


import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Range(min = 1, max = 12, message = "Rating must be between 1 and 12")
	private Integer num_viaggiatori;
	
    @Range(min = 7, max = 30, message = "Rating must be between 7 and 30")
	private Integer giorni;
	
    @Past(message = "Date of birth must be in the past")
	private Date data_nascita;
	
    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
	private Double totale;
	
	@NotBlank(message = "Name is mandatory")
	private String nome;

	@NotBlank(message = "Last name is mandatory")
	private String  cognome;
	
	@Email(message = "Supplier email should be valid")
	private String  email;
	
	@Future(message="Departure must be set in the future")
	private String  partenza; 
	
	@NotBlank(message = "Destination is mandatory")
	private String  destinazione;
	
	@NotBlank(message = "Reservation is mandatory")
	private String  sistemazione;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNum_viaggiatori() {
		return num_viaggiatori;
	}

	public void setNum_viaggiatori(Integer num_viaggiatori) {
		this.num_viaggiatori = num_viaggiatori;
	}

	public Integer getGiorni() {
		return giorni;
	}

	public void setGiorni(Integer giorni) {
		this.giorni = giorni;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public Double getTotale() {
		return totale;
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPartenza() {
		return partenza;
	}

	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public String getSistemazione() {
		return sistemazione;
	}

	public void setSistemazione(String sistemazione) {
		this.sistemazione = sistemazione;
	}
}

