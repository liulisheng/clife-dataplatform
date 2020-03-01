package com.clife.dataplatform.config;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class Config {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String ip;
    @Value("${spring.data.elasticsearch.port}")
    private String port;
    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    @Bean
    public TransportClient getTransportClient() {
        TransportClient transportClient = null;
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name",clusterName)
                    .put("client.transport.sniff",true)
                    .build();
            transportClient = new PreBuiltTransportClient(settings);
            TransportAddress firstAddress = new TransportAddress(InetAddress.getByName(ip),Integer.parseInt(port));
            transportClient.addTransportAddress(firstAddress);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("getTransportClient fail：" +  e.getMessage(),e);
        }
        return transportClient;
    }

}
