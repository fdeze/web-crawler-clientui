package fr.fabien.clientui.proxy.indeed;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.fabien.contracts.OfferVo;

@FeignClient(name = "web-crawler-connector-indeed", url = "localhost:9005")
public interface IndeedOfferProxy {

	@GetMapping(value = "/getOffers/indeed/{location}/{keyword}", produces = { "application/json" })
	List<OfferVo> indeedOfferList(@PathVariable(value = "location") String location, @PathVariable(value = "keyword") String keyword);

}