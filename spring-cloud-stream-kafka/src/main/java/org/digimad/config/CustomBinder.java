//package org.digimad.config;
//
//import org.springframework.cloud.stream.binder.Binder;
//import org.springframework.cloud.stream.binder.Binding;
//import org.springframework.cloud.stream.binder.ConsumerProperties;
//import org.springframework.cloud.stream.binder.ProducerProperties;
//
///*
//binder implementation
// */
//
//public class CustomBinder implements Binder {
//    @Override
//    public String getBinderIdentity() {
//        return Binder.super.getBinderIdentity();
//    }
//
//    @Override
//    public Binding bindConsumer(String name, String group, Object inboundBindTarget, ConsumerProperties consumerProperties) {
//        return null;
//    }
//
//    @Override
//    public Binding bindProducer(String name, Object outboundBindTarget, ProducerProperties producerProperties) {
//        return null;
//    }
//}
