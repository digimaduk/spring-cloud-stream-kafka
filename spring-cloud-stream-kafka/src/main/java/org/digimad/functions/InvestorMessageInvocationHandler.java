package org.digimad.functions;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvestorMessageInvocationHandler implements InvocationHandler {

    private InvestorMessageHandler target;

    public InvestorMessageInvocationHandler(InvestorMessageHandler target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
