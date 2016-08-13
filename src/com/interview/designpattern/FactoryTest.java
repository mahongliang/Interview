package com.interview.designpattern;

interface Logger{
	public void writeLog();
}

class DatabaseLogger implements Logger{

	@Override
	public void writeLog() {
		// TODO Auto-generated method stub
		System.out.println("database logger recorded");
	}
}

class FileLogger implements Logger{

	@Override
	public void writeLog() {
		// TODO Auto-generated method stub
		System.out.println("file logger recorded");
	}
}

interface LoggerFactory{
	public Logger createLogger();
}

class DatabaseLoggerFactory implements LoggerFactory{

	@Override
	public Logger createLogger() {
		// TODO Auto-generated method stub
		return new DatabaseLogger();
	}
}
class FileLoggerFactory implements LoggerFactory{

	@Override
	public Logger createLogger() {
		// TODO Auto-generated method stub
		return new FileLogger();
	}
}

public class FactoryTest {
	public static void main(String[] args) {
		LoggerFactory factory = new FileLoggerFactory();
		Logger logger = factory.createLogger();
		logger.writeLog();
	}
}
