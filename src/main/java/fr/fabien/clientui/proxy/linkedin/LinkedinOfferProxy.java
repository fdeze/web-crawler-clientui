package fr.fabien.clientui.proxy.linkedin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "web-crawler-connector-linkedin", url = "localhost:9003")
public interface LinkedinOfferProxy {

	@GetMapping(value = "/getOffers/linkedin/{keyword}", produces = { "application/json" })
	List<LinkedinOfferVo> linkedinOfferList(@PathVariable String keyword);

}