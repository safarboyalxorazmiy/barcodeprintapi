package com.fridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");

		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		SpringApplication.run(DemoApplication.class, args);
	}

}
