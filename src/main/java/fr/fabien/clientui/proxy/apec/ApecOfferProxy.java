package fr.fabien.clientui.proxy.apec;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.fabien.contracts.apec.ApecOfferVo;

@FeignClient(name = "gateway")
public interface ApecOfferProxy {

	@GetMapping(path = "/getOffers/apec/{location}/{keyword}", produces = { "application/json" })
	List<ApecOfferVo> apecOfferList(@PathVariable(value = "location") String location, @PathVariable(value = "keyword") String keyword);

}