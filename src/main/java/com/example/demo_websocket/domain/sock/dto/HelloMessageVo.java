package com.example.demo_websocket.domain.sock.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelloMessageVo {

	private String name;

	public String getName() {
		return this.name;
	}
}
