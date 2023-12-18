package org.digimad.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.stream.binder.BinderFactory;
import org.springframework.cloud.stream.binding.BindingService;
import org.springframework.cloud.stream.config.BinderProperties;
import org.springframework.cloud.stream.config.BindingProperties;
import org.springframework.cloud.stream.config.BindingServiceProperties;
import org.springframework.cloud.stream.function.FunctionConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.TaskScheduler;

import java.util.Map;
import java.util.TreeMap;

@Configuration
//@ConditionalOnBean(BindingService.class)
//@AutoConfigureAfter(BindingServiceConfiguration.class)
//BindingHandlerAdvise
@AutoConfigureBefore(FunctionConfiguration.class)
@Slf4j
//@DependsOn("bindingConfig")
public class CustomBindingService {

    @Bean
    public BindingService bindingService(BindingServiceProperties bindingServiceProperties,
                                         BinderFactory binderFactory, TaskScheduler taskScheduler, @Nullable ObjectMapper objectMapper) throws Exception {
        Map<String, BindingProperties> bindings = bindingServiceProperties.getBindings();
        if (MapUtils.isEmpty(bindings)) {
            bindings = new TreeMap<>();
        }
        setBindings(bindings);
        Map<String, BinderProperties> binders = bindingServiceProperties.getBinders();
        return new BindingService(bindingServiceProperties, binderFactory, taskScheduler, objectMapper);
    }

    private static void setBindings(Map<String, BindingProperties> bindings) {
        BindingProperties bindingProperties1 = new BindingProperties();
        bindingProperties1.setContentType("application/json");
        bindingProperties1.setDestination("fizz-buzz");
        bindings.put("fizzBuzzConsumer-in-0", bindingProperties1);
        BindingProperties bindingProperties3 = new BindingProperties();
        bindingProperties3.setContentType("application/json");
        bindingProperties3.setDestination("numbers");
        bindings.put("fizzBuzzProcessor-in-0", bindingProperties3);
        BindingProperties bindingProperties2 = new BindingProperties();
        bindingProperties2.setContentType("application/json");
        bindingProperties2.setDestination("fizz-buzz");
        bindings.put("fizzBuzzProcessor-out-0", bindingProperties2);
        BindingProperties bindingProperties4 = new BindingProperties();
        bindingProperties4.setContentType("application/json");
        bindingProperties4.setDestination("numbers");
//        bindings.put("fizzBuzzProducer-out", bindingProperties4);
    }
}
