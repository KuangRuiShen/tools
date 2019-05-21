package com.krs.uitls.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author krs
 * @time 2019年5月21日 上午9:22:02
 * @describe 限制线程
 */
@Slf4j
public class CountDownLatchExample {
	  private final static int threadCount = 200;

	    public static void main(String[] args) throws InterruptedException {
	        ExecutorService exec = Executors.newCachedThreadPool();

	        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

	        for (int i = 0; i < threadCount; i++) {
	            final int threadNum = i;
	            exec.execute(() -> {
	                try {
	                    test(threadNum);
	                    System.out.println("ddd");
	                } catch (Exception e) {
	                    log.error("exception", e);
	                } finally {
	                    countDownLatch.countDown();
	                }
	            });
	        }
	        countDownLatch.await(10, TimeUnit.MICROSECONDS);
	        log.info("finish");
	        System.out.println("finish");
	        exec.shutdown();
	    }

	    private static void test(int threadNum) throws Exception {
	        Thread.sleep(100);
	        System.out.println("threadNum："+threadNum);
	        log.info("{}", threadNum);
	    }

}
