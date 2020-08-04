package com.sunline.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqConfig {
    @Value("${activemq.user}")
    private String usrName;

    @Value("${activemq.password}")
    private  String password;

    @Value("${activemq.broker-url}")
    private  String brokerUrl;

    // 使用生产消息时配置
    //@Value("${spring.activemq.queueName}")
    //private String queueName;
    //
    //@Value("${spring.activemq.topicName}")
    //private String topicName;
    //
    //@Bean
    //public Queue queue(){
    //    return new ActiveMQQueue(queueName);
    //}
    //
    //@Bean
    //public Topic topic(){
    //    return new ActiveMQTopic(topicName);
    //}

    @Bean
    public RedeliveryPolicy redeliveryPolicy(){
        RedeliveryPolicy  redeliveryPolicy= new RedeliveryPolicy();
        //是否在每次尝试重新发送失败后,增长这个等待时间
        redeliveryPolicy.setUseExponentialBackOff(true);
        //重发次数,默认为6次   这里设置为10次
        redeliveryPolicy.setMaximumRedeliveries(10);
        //重发时间间隔,默认为1秒
        redeliveryPolicy.setInitialRedeliveryDelay(1000);
        //第一次失败后重新发送之前等待500毫秒,第二次失败再等待500 * 2毫秒,这里的2就是value
        redeliveryPolicy.setBackOffMultiplier(2);
        //是否避免消息碰撞
        redeliveryPolicy.setUseCollisionAvoidance(false);
        //设置重发最大拖延时间-1,只有UseExponentialBackOff(true)为true时生效
        redeliveryPolicy.setMaximumRedeliveryDelay(5000);
        return redeliveryPolicy;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory(RedeliveryPolicy redeliveryPolicy) {
//        return new ActiveMQConnectionFactory(usrName, password, brokerUrl);
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(usrName, password, brokerUrl);
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

//    @Bean
//    public JmsListenerContainerFactory jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory){
//        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
//        //设置为发布订阅方式, 默认情况下使用的生产消费者方式
//        bean.setPubSubDomain(true);
//        bean.setConnectionFactory(connectionFactory);
//        return bean;
//    }

    //定义一个消息监听器连接工厂，这里定义的是点对点模式的监听器连接工厂
    @Bean(name = "jmsQueueListener")
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory);
        //设置连接数
        factory.setConcurrency("1-10");
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        //0-事务提交并确认;1-自动确认;2-客户端手动确认;3-自动批量确认;4-单条消息确认activemq独有
        factory.setSessionAcknowledgeMode(4);
        return factory;
    }

    @Bean
    public JmsTemplate  jmsTemplate(ActiveMQConnectionFactory connectionFactory){
        JmsTemplate jmsTemplate=new JmsTemplate ();
        jmsTemplate.setDeliveryMode(2);//进行持久化配置 1表示非持久化，2表示持久化
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setSessionAcknowledgeMode(4);//客户端签收模式
        return jmsTemplate;
    }
}
