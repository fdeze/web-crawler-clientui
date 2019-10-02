package fr.fabien.clientui.proxy.ffg;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fabien.contracts.ffg.FfgOfferVo;



@FeignClient(name = "web-crawler-connector-ffg", url = "localhost:9000")
public interface FfgOfferProxy {

	@GetMapping(value = "/getOffers/ffg")
	List<FfgOfferVo> ffgOfferList();

}