package fr.fabien.clientui.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.fabien.webcrawler.common.model.ApecOfferVo;

@FeignClient(name = "gateway")
public interface ApecOfferProxy {

	@GetMapping(path = "/getOffers/apec/{keyword}", produces = { "application/json" })
	List<ApecOfferVo> apecOfferList( @PathVariable String keyword);

}