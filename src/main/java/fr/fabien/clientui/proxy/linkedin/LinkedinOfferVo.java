package fr.fabien.clientui.proxy.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import fr.fabien.clientui.proxy.AbstractOfferVo;

 
public class LinkedinOfferVo extends AbstractOfferVo {

	private String adresse;

	private String entreprise;

	private String numeroOffre;

	private String descriptionHtml;

	private String urlLogo;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private int dateCalculee;

	public int getDateCalculee() {
		return dateCalculee;
	}

	public void setDateCalculee(int dateCalculee) {
		this.dateCalculee = dateCalculee;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getNumeroOffre() {
		return numeroOffre;
	}

	public void setNumeroOffre(String numeroOffre) {
		this.numeroOffre = numeroOffre;
	}

	public String getDescriptionHtml() {
		return descriptionHtml;
	}

	public void setDescriptionHtml(String descriptionHtml) {
		this.descriptionHtml = descriptionHtml;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	@Override
	public String toString() {
		return "LinkedinOfferVo [adresse=" + adresse + ", entreprise=" + entreprise + ", numeroOffre=" + numeroOffre
				+ ", descriptionHtml=" + descriptionHtml + "]";
	}

}
