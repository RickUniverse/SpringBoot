package com.mystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lijichen
 * @date 2021/1/7 - 20:27
 */
@ConfigurationProperties(prefix = "mystarter.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public HelloProperties setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getSuffix() {
        return suffix;
    }

    public HelloProperties setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }
}
