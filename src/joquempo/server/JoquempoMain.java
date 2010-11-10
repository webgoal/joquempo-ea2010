package joquempo.server;

import httprevayler.PrevalentServer;

import java.io.File;

import joquempo.domain.Joquempo;
import sneer.bricks.hardware.clock.ticker.ClockTicker;
import sneer.bricks.hardware.cpu.threads.Threads;
import sneer.bricks.hardware.io.log.exceptions.robust.RobustExceptionLogging;
import sneer.bricks.snapps.system.log.file.LogToFile;
import sneer.bricks.snapps.system.log.sysout.LogToSysout;
import sneer.foundation.brickness.Brickness;
import sneer.foundation.environments.Environments;
import sneer.foundation.lang.ClosureX;
import static sneer.foundation.environments.Environments.my;

public class JoquempoMain {
	
	public static void main(String[] args) throws Exception {
		Environments.runWith(Brickness.newBrickContainer(), new ClosureX<Exception>() { @Override public void run() throws Exception {
			start();
		}});
	}

	
	private static void start() throws Exception {
		startLogging();
		
		my(ClockTicker.class);
		
		PrevalentServer.startRunning(new Joquempo());
		
		my(Threads.class).waitUntilCrash();
	}
	
	
	private static void startLogging() {
		my(RobustExceptionLogging.class).turnOn();
		my(LogToSysout.class);
		my(LogToFile.class).startWritingLogTo(newLogFile());
	}

	
	private static File newLogFile() {
		return new File("logs/log_" + System.currentTimeMillis() + ".log");
	}
}
