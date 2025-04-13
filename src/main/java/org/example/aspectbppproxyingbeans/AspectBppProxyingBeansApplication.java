package org.example.aspectbppproxyingbeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectBppProxyingBeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectBppProxyingBeansApplication.class, args);
	}

}
