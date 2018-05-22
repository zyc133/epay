package epay.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import epay.activemq.service.ProducerService;
import epay.base.model.Student;
import epay.base.service.StudentService;


@Controller
public class EpayrController {
	
    @Autowired
    private ProducerService producerService;
    
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Autowired
    @Qualifier("topicDestination")
    private Destination topicDestination ;

	@Resource(name="studentService")
	StudentService service;
	
	@RequestMapping(value="/save")
	public void hello() {
		System.out.println("1222qwq11");
		service.save(new Student());
	}
	@RequestMapping(value="/send")
	public void hello2() {
        for (int i=0; i<2; i++) {
            producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));
        }
    
	}
}
