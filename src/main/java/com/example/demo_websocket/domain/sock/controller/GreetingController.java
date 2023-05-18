package com.example.demo_websocket.domain.sock.controller;

import com.example.demo_websocket.domain.sock.dto.GreetingVo;
import com.example.demo_websocket.domain.sock.dto.HelloMessageVo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GreetingController {
	private final SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Object greeting(HelloMessageVo message) throws Exception {
//		Thread.sleep(1000); // simulated delay

		System.out.println(message.getName());
		System.out.println("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		return new GreetingVo("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

	@MessageMapping("/hello2")
	@SendTo("/topic/greetings")
	public Object greeting2(HelloMessageVo message) throws Exception {
//		Thread.sleep(1000); // simulated delay

		System.out.println(message.getName());
		System.out.println("Hello2, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		return new GreetingVo("Hello2, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

	@MessageMapping("/chat/send")
	//public void sendMsg(@Payload Map<String,Object> data){
	public void sendMsg(@Payload Map<String,Object> data){

		System.out.println(data.toString());
		simpMessagingTemplate.convertAndSend("/topic/1",data);
	}

}
