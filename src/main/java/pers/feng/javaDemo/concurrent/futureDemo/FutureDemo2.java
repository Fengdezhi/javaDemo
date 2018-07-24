package pers.feng.javaDemo.concurrent.futureDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ʹ��Callable+FutureTask��ȡִ�н�� <br/>
 * 
 * Ӧ�ó������߳�A��Ҫ�߳�B��ִ�н������û��Ҫһֱ�ȴ��߳�Bִ���꣬���ʱ��������õ�δ����Future���󣬵��߳�Bִ��������ȡ��ʵ���
 * @author fengdezhi
 *
 */
public class FutureDemo2 {
	private static final Logger log = LoggerFactory.getLogger(FutureDemo2.class);
	
    public static void main(String[] args) {
        //��һ�ַ�ʽ
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task());
        executor.submit(futureTask);
        executor.shutdown();
         
        //�ڶ��ַ�ʽ��ע�����ַ�ʽ�͵�һ�ַ�ʽЧ�������Ƶģ�ֻ����һ��ʹ�õ���ExecutorService��һ��ʹ�õ���Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/
         
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        log.debug("���߳���ִ������");
         
        try {
        	log.debug("task���н��{}",futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
        log.debug("��������ִ�����");
    } 
}
