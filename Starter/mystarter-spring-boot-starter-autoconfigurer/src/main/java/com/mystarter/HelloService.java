package com.mystarter;

/**
 * @author lijichen
 * @date 2021/1/7 - 20:26
 */
public class HelloService {

    HelloProperties helloProperties = new HelloProperties();

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public HelloService setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
        return this;
    }

    public String sayHello(String name) {
        return helloProperties.getPrefix() + name + helloProperties.getSuffix();
    }
}
