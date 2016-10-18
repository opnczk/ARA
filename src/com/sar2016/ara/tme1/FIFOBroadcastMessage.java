package com.sar2016.ara.tme1;

public class FIFOBroadcastMessage extends ReliableBroadcastMessage{

	public FIFOBroadcastMessage(long idsrc, long iddest, long idSender,
			long numseq, String tag, Object content, int pid) {
		super(idsrc, iddest, idSender, numseq, tag, content, pid);
		// TODO Auto-generated constructor stub
	}
}
