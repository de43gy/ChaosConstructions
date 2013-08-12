package engine;

import java.util.concurrent.TimeUnit;

import enter.StartTest;

public class TimeCounter implements Runnable{
	
	protected int counter;
	protected int Denominator;
	protected int TimeSpeed;
	
	public TimeCounter(){
		counter=0;
		Denominator=1;
		TimeSpeed=1;
	}
	
	public void incrDenominator(int increment){
		Denominator+=increment;
		System.out.println("Denominator ="+Denominator);
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(counter);

			try {
				TimeUnit.SECONDS.sleep(TimeSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter+=Denominator;
		}
		
	}
	
	public int getCounter(){
		return counter;
	}

}