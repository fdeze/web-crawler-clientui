package fr.fabien.clientui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.fabien.clientui.proxy.ffg.FfgOfferProxy;
import fr.fabien.clientui.proxy.apec.ApecOfferProxy;
import fr.fabien.clientui.proxy.cyclable.CycableOfferProxy;
import fr.fabien.clientui.proxy.indeed.IndeedOfferProxy;
import fr.fabien.clientui.proxy.linkedin.LinkedinOfferProxy;
import fr.fabien.clientui.proxy.silkhom.SilkhomOfferProxy;
import fr.fabien.clientui.proxy.welcometothejungle.WelcomeToTheJungleOfferProxy;
import fr.fabien.contracts.OfferVo;
import fr.fabien.contracts.ffg.FfgOfferVo;
import fr.fabien.contracts.apec.ApecOfferVo;
import fr.fabien.contracts.linkedin.LinkedinOfferVo;
import fr.fabien.contracts.welcometothejungle.WelcomeToTheJungleOfferVo;
import fr.fabien.product.ProductVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ClientController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static String MODEL = "offres";
	private static String MODEL_PRODUITS = "produits";

	private static String AccueilComplet = "AccueilOffresComplet";
	private static String AccueilProduitsComplet = "AccueilProduitsComplet";
	@Autowired
	private ApecOfferProxy apecProxy;

	@Autowired
	private SilkhomOfferProxy silkhomProxy;

	@Autowired
	private FfgOfferProxy ffgProxy;

	@Autowired
	private LinkedinOfferProxy linkedinProxy;

	@Autowired
	private WelcomeToTheJungleOfferProxy welcomeToTheJungleProxy;

	@Autowired
	private IndeedOfferProxy indeedProxy;

	@Autowired
	private CycableOfferProxy cyclableProxy;
	
	@GetMapping("/")
	public String accueil(Model model) {
		return "Accueil";
	}

	@GetMapping("/apec")
	public String accueilApec(Model model) {
		return accueilApecWithLocationAndKeyword(model, "69", "java");
	}

	@GetMapping("/apec/{location}/{keyword}")
	public String accueilApecWithLocationAndKeyword(Model model, @PathVariable String location,
			@PathVariable String keyword) {
		logger.info("Envoi requête vers apec-microservice - localisation : {} - mots clé : {}", location, keyword);
		List<ApecOfferVo> apecOfferList = apecProxy.apecOfferList(location, keyword);
		logger.info("Retour requête vers apec-microservice - nombre de résultats : {}", apecOfferList.size());

		model.addAttribute(MODEL, apecOfferList);
		return AccueilComplet;
	}

	@GetMapping("/silkhom")
	public String accueilSilkhom(Model model) {
		logger.info("Envoi requête vers silkhom-microservice");
		List<OfferVo> silkhomOfferList = silkhomProxy.silkhomOfferList();
		logger.info("Retour requête vers silkhom-microservice - nombre de résultats : {}", silkhomOfferList.size());

		model.addAttribute(MODEL, silkhomOfferList);
		return AccueilComplet;
	}

	@GetMapping("/ffg")
	public String accueilffg(Model model) {
		logger.info("Envoi requête vers ffg-microservice");
		List<FfgOfferVo> ffgOfferList = ffgProxy.ffgOfferList();
		logger.info("Retour requête vers ffg-microservice - nombre de résultats : {}", ffgOfferList.size());

		model.addAttribute(MODEL, ffgOfferList);
		return AccueilComplet;
	}

	@GetMapping("/linkedin")
	public String accueilLinkedin(Model model) {
		return accueilLinkedinWithKeyword(model, "java");
	}

	@GetMapping("/linkedin/{keyword}")
	public String accueilLinkedinWithKeyword(Model model, @PathVariable String keyword) {
		logger.info("Envoi requête vers linkedin-microservice - mots clé : {}", keyword);
		List<LinkedinOfferVo> linkedinOfferList = linkedinProxy.linkedinOfferList(keyword);
		logger.info("Retour requête vers linkedin-microservice - nombre de résultats : {}", linkedinOfferList.size());

		model.addAttribute(MODEL, linkedinOfferList);
		return AccueilComplet;
	}

	@GetMapping("/welcomeToTheJungle")
	public String accueilWelcomeToTheJungle(Model model) {
		return accueilWelcomeToTheJungleWithKeyword(model, "java");
	}

	@GetMapping("/welcomeToTheJungle/{keyword}")
	public String accueilWelcomeToTheJungleWithKeyword(Model model, @PathVariable String keyword) {
		logger.info("Envoi requête vers welcomeToTheJungle-microservice - mots clé : {}", keyword);
		List<WelcomeToTheJungleOfferVo> welcomeToTheJungleOfferList = welcomeToTheJungleProxy
				.welcometothejungleOfferList(keyword);
		logger.info("Retour requête vers welcomeToTheJungle-microservice - nombre de résultats : {}",
				welcomeToTheJungleOfferList.size());

		model.addAttribute(MODEL, welcomeToTheJungleOfferList);
		return AccueilComplet;
	}

	@GetMapping("/indeed")
	public String accueilIndeed(Model model) {
		return accueilIndeedWithKeyword(model, "java");
	}

	@GetMapping("/indeed/{keyword}")
	public String accueilIndeedWithKeyword(Model model, @PathVariable String keyword) {
		logger.info("Envoi requête vers indeed-microservice - mots clé : {}", keyword);
		List<OfferVo> indeedOfferList = indeedProxy.indeedOfferList("Lyon", keyword);
		logger.info("Retour requête vers indeed-microservice - nombre de résultats : {}", indeedOfferList.size());

		model.addAttribute(MODEL, indeedOfferList);
		return AccueilComplet;
	}

	@GetMapping("/indeed/{location}/{keyword}")
	public String accueilIndeedWithLocationAndKeyword(Model model, @PathVariable String location,
			@PathVariable String keyword) {
		logger.info("Envoi requête vers indeed-microservice - mots clé : {}", keyword);
		List<OfferVo> indeedOfferList = indeedProxy.indeedOfferList(location, keyword);
		logger.info("Retour requête vers indeed-microservice - nombre de résultats : {}", indeedOfferList.size());

		model.addAttribute(MODEL, indeedOfferList);
		return AccueilComplet;
	}
	
	
	@GetMapping("/cyclable")
	public String accueilCyclable(Model model) {
		logger.info("Envoi requête vers cyclable-microservice");
		List<ProductVo> cyclableProductList = cyclableProxy.cyclableProductList();
		logger.info("Retour requête vers cyclable-microservice - nombre de résultats : {}", cyclableProductList.size());
		
		model.addAttribute(MODEL_PRODUITS, cyclableProductList);
		return AccueilProduitsComplet;
	}
}