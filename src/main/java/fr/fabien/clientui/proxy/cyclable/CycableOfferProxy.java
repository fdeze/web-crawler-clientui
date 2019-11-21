package fr.fabien.clientui.proxy.cyclable;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fabien.contracts.OfferVo;
import fr.fabien.product.ProductVo;

@FeignClient(name = "web-crawler-connector-cyclable", url = "localhost:9006")
public interface CycableOfferProxy {

	@GetMapping(value = "/getProducts/cyclable/", produces = { "application/json" })
	List<ProductVo> cyclableProductList();

}