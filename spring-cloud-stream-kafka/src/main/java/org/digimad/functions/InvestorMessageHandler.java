package org.digimad.functions;

@FunctionalInterface
public interface InvestorMessageHandler {
    void transform(String msgType);
}
