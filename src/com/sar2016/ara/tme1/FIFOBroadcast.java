package com.sar2016.ara.tme1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import peersim.config.Configuration;
import peersim.core.Node;
import peersim.edsim.EDProtocol;

public class FIFOBroadcast implements EDProtocol, BroadcastProtocol {
	private static final String PAR_TRANSPORT = "transport";
	
	private final int protocol_id;
	private final int transport_id;
	
	private final Set<FIFOBroadcastMessage> pendMsg;
	private final Map<Long,Integer> nextMessage;
	
	public FIFOBroadcast(String prefix){
		String tmp[]=prefix.split("\\.");
		protocol_id=Configuration.lookupPid(tmp[tmp.length-1]);
		transport_id=Configuration.getPid(prefix+"."+PAR_TRANSPORT);
		pendMsg = new HashSet<FIFOBroadcastMessage>();
		
		int nb_nodes = Configuration.getInt("network.size");
		nextMessage = new HashMap<Long,Integer>();
	}
	
	
	@Override
	public void broadcast(Node src, Message m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliver(Node host, Message m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processEvent(Node node, int pid, Object event) {
		//equivalent Real_deliver
		if(protocol_id != pid){
			throw new RuntimeException("Receive Message for wrong protocol");
		}
		if(event instanceof FIFOBroadcastMessage ){
			FIFOBroadcastMessage message = (FIFOBroadcastMessage)event;
			
			long sender = message.getIdSender();
			pendMsg.add(message);
			
			FIFOBroadcastMessage[] tmpArray = (FIFOBroadcastMessage[]) pendMsg.toArray();
			
			for(int i =0; i < tmpArray.length; i++){
				if(tmpArray[i].getIdSender() == sender && tmpArray[i].getNumseq() == this.nextMessage.get(sender)){
					
				}
			}
		}
	}

	@Override
	public Object clone(){
		ReliableBroadcast rb = null;
		try { rb = (ReliableBroadcast) super.clone();
		
		}
		catch( CloneNotSupportedException e ) {} // never happens
		return rb;
	}
}
