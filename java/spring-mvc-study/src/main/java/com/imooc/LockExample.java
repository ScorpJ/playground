package com.imooc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock ;

public class LockExample  implements Runnable{

	
	private static final Lock lock = new ReentrantLock();
	private static final Condition someCondition = lock.newCondition();
	private static final ReadWriteLock rwLock = new ReentrantReadWriteLock ();
	private ThreadLocal<Integer> lockCounter = new ThreadLocal<Integer>(){	    
	    protected Integer initialValue(){
	        return 0;	
	    }
	};
	
	
	

	public void run() {
		boolean getLock = false;
		lockCounter.get();
        do{
        	try {
				getLock = lock.tryLock(1000,TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
        	
        	lockCounter.set(lockCounter.get()+1);        	
        }while(!getLock && lockCounter.get().intValue() < 20);
		
		/*
		 *  Do business process with lock
		 */
        try {
			someCondition.await(1000,TimeUnit.MILLISECONDS);
			
			/*Do something*/		
			
			someCondition.signalAll();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        rwLock.readLock().lock();
        
        
        lock.unlock();
        
	}
	
	
	public static void main(String[] args) {
		
		
	}

}
