package pers.feng.javaDemo.concurrent.futureDemo;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ������
 * @author fengdezhi
 */
public class Task implements Callable<Integer>{
	private static final Logger log = LoggerFactory.getLogger(Task.class);
	
    public Integer call() throws Exception {
    	log.debug("���߳��ڽ��м���");
    	
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}
