package fr.fabien.clientui.proxy;

public abstract class AbstractOfferVo {
	
	protected String numeroOffreExterne;
	
	protected String titre;

	protected String url;

	protected String datePublication;

	public String getDatePublication() {
		return datePublication;
	}

	public String getTitre() {
		return titre;
	}

	public String getUrl() {
		return url;
	}

	public void setDatePublication(String datePublication) {
		this.datePublication = datePublication;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
	public String getNumeroOffreExterne() {
		return numeroOffreExterne;
	}

	public void setNumeroOffreExterne(String numeroOffreExterne) {
		this.numeroOffreExterne = numeroOffreExterne;
	}

	@Override
	public String toString() {
		return "AbstractOfferVo [numeroOffreExterne=" + numeroOffreExterne + ", titre=" + titre + ", url=" + url
				+ ", datePublication=" + datePublication + "]";
	}

}
