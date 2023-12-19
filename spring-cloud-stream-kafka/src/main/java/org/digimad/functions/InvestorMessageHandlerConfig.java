package org.digimad.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvestorMessageHandlerConfig {

    @Bean
    public InvestorMessageDynamicProxyFactory investorMessageDynamicProxyFactory() {
        return new InvestorMessageDynamicProxyFactory();
    }
}
