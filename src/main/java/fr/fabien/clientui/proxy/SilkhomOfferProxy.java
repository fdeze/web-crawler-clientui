package fr.fabien.clientui.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fabien.webcrawler.common.model.SilkhomOfferVo;


@FeignClient(name = "gateway")
public interface SilkhomOfferProxy {

	@GetMapping(value = "/getOffers/silkhom", produces = { "application/json" })
	List<SilkhomOfferVo> adsearchsilkhomOfferList();

}