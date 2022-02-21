package mes.broanex.dash.controller;

import mes.broanex.dash.service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ApiController {
	private final ApiService apiService;

	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}

	@GetMapping(value = "/api")
	public ResponseEntity<List<Object>> getByParam(@RequestParam(required = false, defaultValue = "Y") String typeYn,
	                                               @RequestParam(required = false, defaultValue = "Y") String positionYn,
	                                               @RequestParam(required = false, defaultValue = "Y") String dataColumnYn) {
		List<Object> objectList = apiService.getByParam(new HashMap<String, Object>() {{
			put("typeYn", typeYn);
			put("positionYn", positionYn);
			put("dataColumnYn", dataColumnYn);
		}});
		return ok(objectList);
	}
}
