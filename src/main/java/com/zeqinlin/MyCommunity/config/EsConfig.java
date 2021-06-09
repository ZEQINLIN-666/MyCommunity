package com.zeqinlin.MyCommunity.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

/**
 * Description:
 * date: 2021/6/9 12:09
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Configuration
public class  EsConfig{
    @Value("${elasticSearch.url}")
    private String esUrl;

    //localhost:9200 写在配置文件中就可以了
    @Bean
    RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(esUrl)//elasticsearch地址
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
