package com.example.demo.model;

import java.util.Date;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Destinazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
	private Double prezzo;
    
    @NotNull(message = "Total Earnings is mandatory")
    @Min(value = 0, message = "Total Earnings must be greater than or equal to 0")
	private Double introiti;
    
    @NotNull(message = "Total Number of Participants is mandatory")
    @Min(value = 0, message = "Total Number of Participants must be greater than or equal to 0")
    private Integer party;
    
    @NotBlank(message="Starting Date of a Destination is mandatory")
    @Past(message="Starting Date must be set in the past")
    private Date startingDate;
    
    @NotBlank(message = "Name is mandatory")
    private String nome;
    
    @Size(max = 200, message = "Description must be less than 20 characters")
    private String descrizione;
    
    @NotBlank(message = "Continent is mandatory")
    private String continente;
    
    @Range(min = 1, max = 5, message = "Rating must be between 1 and 5")
    private String review;
    
    @NotBlank(message = "Type is mandatory")
    private String tipo;
    
    @NotBlank(message = "Coordinator is mandatory")
    private String coord;
	
    public Double getIntroiti() {
		return introiti;
	}

	public void setIntroiti(Double introiti) {
		this.introiti = introiti;
	}

	public Integer getParty() {
		return party;
	}

	public void setParty(Integer party) {
		this.party = party;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public String getCoord() {
		return coord;
	}

	public void setCoord(String coord) {
		this.coord = coord;
	}

    
    // Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String desc) {
		this.descrizione = desc;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}