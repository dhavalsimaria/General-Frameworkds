/**
 * 
 */
package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dhaval
 */

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String sayHi(){
		return "Hi";
	}
}
