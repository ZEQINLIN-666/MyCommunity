package com.zeqinlin.MyCommunity.event;

import com.alibaba.fastjson.JSONObject;
import com.zeqinlin.MyCommunity.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Description:事件的生产者
 * date: 2021/6/8 8:50
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    //处理事件
    public void fireEvent(Event event){
        //将事件发布到指定的主题
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }
}
