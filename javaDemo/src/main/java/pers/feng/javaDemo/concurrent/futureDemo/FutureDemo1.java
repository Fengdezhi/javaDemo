package pers.feng.javaDemo.concurrent.futureDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ʹ��Callable+Future��ȡִ�н�� <br/>
 * Ӧ�ó������߳�A��Ҫ�߳�B��ִ�н������û��Ҫһֱ�ȴ��߳�Bִ���꣬���ʱ��������õ�δ����Future���󣬵��߳�Bִ��������ȡ��ʵ���
 * @author fengdezhi
 */
public class FutureDemo1 {
	private static final Logger log = LoggerFactory.getLogger(FutureDemo1.class);
	
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Task());
        
        executor.shutdown(); //�Ѿ���ӵ������е�����Լ���ִ��
         
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
         
        log.debug("���߳���ִ������");
         
        try {
        	log.debug("task���н��{}", result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
        log.debug("��������ִ�����");
    } 
}
