package org.sikuli.slides.api.actions;

import java.util.concurrent.TimeUnit;

import org.sikuli.slides.api.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Objects;

public class DelayAction extends DefaultAction {

	Logger logger = LoggerFactory.getLogger(DelayAction.class);

	private long duration;

	@Override
	public void execute(Context context) {
		logger.info("Performing delay operation...");
		try {
			String waitMessage="Execution will be delayed for "+ duration + " milliseconds";
			logger.info(waitMessage);
			TimeUnit.MILLISECONDS.sleep(duration);
			logger.info("Waking up...");		} 
		catch (InterruptedException e) {
			logger.error("Error in wait operation:" + e.getMessage());
		}
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	
	public String toString(){
		return Objects.toStringHelper(this).add("duration", duration).toString();
	}
}