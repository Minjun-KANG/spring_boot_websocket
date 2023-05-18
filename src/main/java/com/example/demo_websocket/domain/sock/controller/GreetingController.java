package com.example.demo_websocket.domain.sock.controller;

import com.example.demo_websocket.domain.sock.dto.GreetingVo;
import com.example.demo_websocket.domain.sock.dto.HelloMessageVo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public GreetingVo greeting(HelloMessageVo message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new GreetingVo("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}
