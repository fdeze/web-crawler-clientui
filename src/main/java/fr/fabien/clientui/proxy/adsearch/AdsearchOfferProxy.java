package fr.fabien.clientui.proxy.adsearch;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fabien.contracts.adsearch.AdsearchOfferVo;



@FeignClient(name = "web-crawler-connector-adsearch", url = "localhost:9000")
public interface AdsearchOfferProxy {

	@GetMapping(value = "/getOffers/adsearch")
	List<AdsearchOfferVo> adsearchOfferList();

}