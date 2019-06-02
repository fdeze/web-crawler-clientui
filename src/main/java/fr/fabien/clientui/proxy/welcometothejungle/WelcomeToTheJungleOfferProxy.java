package fr.fabien.clientui.proxy.welcometothejungle;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.fabien.contracts.welcometothejungle.WelcomeToTheJungleOfferVo;

@FeignClient(name = "web-crawler-connector-welcometothejungle", url = "localhost:9004")
public interface WelcomeToTheJungleOfferProxy {

	@GetMapping(path = "/getOffers/welcometothejungle/{keyword}", produces = { "application/json" })
	List<WelcomeToTheJungleOfferVo> welcometothejungleOfferList(@PathVariable String keyword);

}