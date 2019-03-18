package fr.fabien.clientui.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fabien.webcrawler.common.model.AdsearchOfferVo;



@FeignClient(name = "adsearch-microservice", url = "localhost:9000")
public interface AdsearchOfferProxy {

	@GetMapping(value = "/getOffers/adsearch")
	List<AdsearchOfferVo> adsearchOfferList();

}