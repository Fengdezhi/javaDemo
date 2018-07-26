package pers.feng.javaDemo.concurrent.futureDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用Callable+FutureTask获取执行结果 <br/>
 * 
 * 应用场景：线程A需要线程B的执行结果，但没必要一直等待线程B执行完，这个时候可以先拿到未来的Future对象，等线程B执行完再来取真实结果
 * @author fengdezhi
 *
 */
public class FutureDemo2 {
	private static final Logger log = LoggerFactory.getLogger(FutureDemo2.class);
	
    public static void main(String[] args) {
        //第一种方式
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task());
        executor.submit(futureTask);
        executor.shutdown();
         
        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/
         
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        log.debug("主线程在执行任务");
         
        try {
        	log.debug("task运行结果{}",futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
        log.debug("所有任务执行完毕");
    } 
}
