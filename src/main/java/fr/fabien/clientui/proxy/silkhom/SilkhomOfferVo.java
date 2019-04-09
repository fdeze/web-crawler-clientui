package fr.fabien.clientui.proxy.silkhom;

import java.util.ArrayList;
import java.util.List;

import fr.fabien.clientui.proxy.AbstractOfferVo;

public class SilkhomOfferVo extends AbstractOfferVo {

	private List<String> metas = new ArrayList<>();

	private List<String> informations = new ArrayList<>();

	public List<String> getInformations() {
		return informations;
	}

	public List<String> getMetas() {
		return metas;
	}

	public void setInformations(List<String> informations) {
		this.informations = informations;
	}

	public void setMetas(List<String> metas) {
		this.metas = metas;
	}

	@Override
	public String toString() {
		return "Emploi [titre=" + titre + ", url=" + url + ", metas=" + metas + ", datePublication=" + datePublication
				+ ", informations=" + informations + "]";
	}

}
