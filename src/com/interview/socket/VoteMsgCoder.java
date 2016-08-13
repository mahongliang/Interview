package com.interview.socket;

import java.io.IOException;

public interface VoteMsgCoder {

	byte[] toWrite(VoteMsg msg) throws IOException;
	VoteMsg formWrite(byte[] input) throws IOException;
}
