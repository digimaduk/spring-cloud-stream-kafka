package org.digimad.functions;

public class InvestorMessageHandlerImpl implements InvestorMessageHandler {

    private String msgHandlerName;
    private String msgType;
    private String source;
    private String sink;

    public InvestorMessageHandlerImpl(String msgHandlerName, String msgType, String source, String sink) {
        this.msgHandlerName = msgHandlerName;
        this.msgType = msgType;
        this.source = source;
        this.sink = sink;
    }

    @Override
    public void transform(String msgType) {
        System.out.println("MsgType is " + msgType);
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSink() {
        return sink;
    }

    public void setSink(String sink) {
        this.sink = sink;
    }

    public String getMsgHandlerName() {
        return msgHandlerName;
    }

    public void setMsgHandlerName(String msgHandlerName) {
        this.msgHandlerName = msgHandlerName;
    }
}
