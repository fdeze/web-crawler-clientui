package fr.fabien.clientui.proxy.silkhom;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fabien.contracts.OfferVo;


@FeignClient(name = "web-crawler-connector-silkhom", url = "localhost:9002")
public interface SilkhomOfferProxy {

	@GetMapping(value = "/getOffers/silkhom", produces = { "application/json" })
	List<OfferVo> adsearchsilkhomOfferList();

}