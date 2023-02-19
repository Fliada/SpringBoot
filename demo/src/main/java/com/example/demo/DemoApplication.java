package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		String port = context.getEnvironment().getProperty("server.port");

		InetAddress ip = InetAddress.getLocalHost();
		String hostname = ip.getHostName();

		System.out.println("http://localhost:" + port + "/");
	}

}
