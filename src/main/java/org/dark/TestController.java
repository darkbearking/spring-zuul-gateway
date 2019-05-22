package org.dark;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	//貌似這裡的路徑/source/hello要與application.yml中的“url: forward:”後面的內容相同才能轉發。
	//當然，無論你寫的是一級路徑抑或二級路徑，都是對轉發結果沒有影響的。
	//比如這裡也可以寫成類似“/sfdgser”這樣的效果，只要application.yml中的“url: forward:”後面的內容與這裡相同就行
	@RequestMapping(value = "/source/hello/{name}", method = RequestMethod.GET)
	public String receive(@PathVariable("name") String name) {
		return "receive " + name;
	}
}
