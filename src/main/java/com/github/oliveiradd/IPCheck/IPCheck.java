package com.github.oliveiradd.something;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@SpringBootApplication
public class IPCheck {

    public static void main(String[] args) {
        SpringApplication.run(IPCheck.class, args);
    }

    @RestController
    public static class IfConfigController {

        @GetMapping("/")
        public String getClientInfo(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Host") String host) {
            String clientIp = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
            return String.format("IP Address: %s%nUser-Agent: %s%nHost: %s%n", clientIp, userAgent, host);
        }
    }
}
