package fr.fabien.clientui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.fabien.clientui.proxy.AdsearchOfferProxy;
import fr.fabien.clientui.proxy.ApecOfferProxy;
import fr.fabien.clientui.proxy.SilkhomOfferProxy;
import fr.fabien.webcrawler.common.model.AdsearchOfferVo;
import fr.fabien.webcrawler.common.model.ApecOfferVo;
import fr.fabien.webcrawler.common.model.SilkhomOfferVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ClientController {
	
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ApecOfferProxy apecProxy;

    @Autowired
    private SilkhomOfferProxy silkhomProxy;
  
    @Autowired
    private AdsearchOfferProxy adsearchProxy;
 
    
    @GetMapping("/")
    public String accueil(Model model){
    	return accueilApecWithKeyword(model,"java");
    }
    
    @GetMapping("/apec")
    public String accueilApec(Model model){
    	return accueilApecWithKeyword(model,"java");
    }
    
    @GetMapping("/apec/{keyword}")
    public String accueilApecWithKeyword(Model model, @PathVariable String keyword){
    	logger.info("Envoi requête vers apec-microservice - mots clé : {}",keyword);
    	List<ApecOfferVo> apecOfferList =  apecProxy.apecOfferList(keyword);
    	logger.info("Retour requête vers apec-microservice - nombre de résultats : {}", apecOfferList.size());

    	model.addAttribute("offres", apecOfferList);
        return "AccueilApec";
    }
    
    @GetMapping("/silkhom")
    public String accueilSilkhom(Model model){
    	logger.info("Envoi requête vers silkhom-microservice");
        List<SilkhomOfferVo> silkhomOfferList =  silkhomProxy.adsearchsilkhomOfferList();
        model.addAttribute("offres", silkhomOfferList);
        return "AccueilSilkhom";
    }
    
    @GetMapping("/adsearch")
    public String accueilAdsearch(Model model){
    	logger.info("Envoi requête vers asearch-microservice");
        List<AdsearchOfferVo> adsearchOfferList =  adsearchProxy.adsearchOfferList();
        model.addAttribute("offres", adsearchOfferList);
        return "AccueilAdsearch";
    }

}