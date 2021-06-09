package com.zeqinlin.MyCommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication	//一般程序的入口用这个配置
public class MyCommunityApplication {

	@PostConstruct
	public void init(){
		//解决netty启动冲突问题
		System.setProperty("es.set.netty.runtime.available.processors","false");
	}



	public static void main(String[] args) {
		SpringApplication.run(MyCommunityApplication.class, args);
	}

}
