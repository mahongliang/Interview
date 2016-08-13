package com.interview.cuncurrent;

import java.util.ArrayList;
import java.util.List;

public class FairLock {
	private boolean isLocked =false;
	private Thread lockThread = null;
	private List watingThreads = new ArrayList<>();
	
}
