package fr.fabien.clientui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.fabien.clientui.proxy.adsearch.AdsearchOfferProxy;
import fr.fabien.clientui.proxy.adsearch.AdsearchOfferVo;
import fr.fabien.clientui.proxy.apec.ApecOfferProxy;
import fr.fabien.clientui.proxy.apec.ApecOfferVo;
import fr.fabien.clientui.proxy.linkedin.LinkedinOfferProxy;
import fr.fabien.clientui.proxy.linkedin.LinkedinOfferVo;
import fr.fabien.clientui.proxy.silkhom.SilkhomOfferProxy;
import fr.fabien.clientui.proxy.silkhom.SilkhomOfferVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ClientController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static String MODEL = "offres";
	
	@Autowired
	private ApecOfferProxy apecProxy;

	@Autowired
	private SilkhomOfferProxy silkhomProxy;

	@Autowired
	private AdsearchOfferProxy adsearchProxy;

	@Autowired
	private LinkedinOfferProxy linkedinProxy;

	@GetMapping("/")
	public String accueil(Model model) {
		return accueilApecWithKeyword(model, "java");
	}

	@GetMapping("/apec")
	public String accueilApec(Model model) {
		return accueilApecWithKeyword(model, "java");
	}

	@GetMapping("/apec/{keyword}")
	public String accueilApecWithKeyword(Model model, @PathVariable String keyword) {
		logger.info("Envoi requête vers apec-microservice - mots clé : {}", keyword);
		List<ApecOfferVo> apecOfferList = apecProxy.apecOfferList(keyword);
		logger.info("Retour requête vers apec-microservice - nombre de résultats : {}", apecOfferList.size());

		model.addAttribute(MODEL, apecOfferList);
		return "AccueilApec";
	}

	@GetMapping("/silkhom")
	public String accueilSilkhom(Model model) {
		logger.info("Envoi requête vers silkhom-microservice");
		List<SilkhomOfferVo> silkhomOfferList = silkhomProxy.adsearchsilkhomOfferList();
		logger.info("Retour requête vers silkhom-microservice - nombre de résultats : {}", silkhomOfferList.size());

		model.addAttribute(MODEL, silkhomOfferList);
		return "AccueilSilkhom";
	}

	@GetMapping("/adsearch")
	public String accueilAdsearch(Model model) {
		logger.info("Envoi requête vers asearch-microservice");
		List<AdsearchOfferVo> adsearchOfferList = adsearchProxy.adsearchOfferList();
		logger.info("Retour requête vers asearch-microservice - nombre de résultats : {}", adsearchOfferList.size());

		model.addAttribute(MODEL, adsearchOfferList);
		return "AccueilAdsearch";
	}

	@GetMapping("/linkedin")
	public String accueilLinkedin(Model model) {
		logger.info("Envoi requête vers linkedin-microservice");
		List<LinkedinOfferVo> linkedinOfferList = linkedinProxy.linkedinOfferList();
		logger.info("Retour requête vers linkedin-microservice - nombre de résultats : {}", linkedinOfferList.size());

		model.addAttribute(MODEL, linkedinOfferList);
		return "AccueilLinkedin";
	}

}