package test;

import javax.jms.Destination;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import epay.activemq.service.ProducerService;

public class MqTest extends BaseTest {

	@Autowired
	private ProducerService producerService;

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;
	
	@Test
	public void send() {
		for (int i = 0; i < 2; i++) {
			producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i + 1));
		}
	}
}
