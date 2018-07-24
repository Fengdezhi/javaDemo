package pers.feng.javaDemo.concurrent.futureDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用Callable+Future获取执行结果 <br/>
 * 应用场景：线程A需要线程B的执行结果，但没必要一直等待线程B执行完，这个时候可以先拿到未来的Future对象，等线程B执行完再来取真实结果
 * @author fengdezhi
 */
public class FutureDemo1 {
	private static final Logger log = LoggerFactory.getLogger(FutureDemo1.class);
	
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Task());
        
        executor.shutdown(); //已经添加到队列中的任务对继续执行
         
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
         
        log.debug("主线程在执行任务");
         
        try {
        	log.debug("task运行结果{}", result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
        log.debug("所有任务执行完毕");
    } 
}
