package org.digimad.functions;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.Proxy;

public class InvestorMessageDynamicProxyFactory implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // Create the original object
        InvestorMessageHandlerImpl arnold = new InvestorMessageHandlerImpl("fizzBuzzConsumer", "ADDR", "xxx", "yyy");

        // Get the class loader from the original object
        ClassLoader arnoldClassLoader = arnold.getClass().getClassLoader();

        // Get all the interfaces that the original object implements
        Class[] interfaces = arnold.getClass().getInterfaces();

        // Create a proxy for our arnold object
        InvestorMessageHandler proxyArnold = (InvestorMessageHandler) Proxy.newProxyInstance(arnoldClassLoader, interfaces, new InvestorMessageInvocationHandler(arnold));

        // Call one of our original object's methods on the proxy object
//        proxyArnold.transform(arnold.getMsgType());
        beanFactory.registerSingleton(arnold.getMsgHandlerName(), proxyArnold);
    }
}
