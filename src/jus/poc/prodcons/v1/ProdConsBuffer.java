package jus.poc.prodcons.v1;

import java.util.ArrayList;

public class ProdConsBuffer implements IProdConsBuffer {

	private static final int sizeMax = 20;
	
	private ArrayList<Message> buffer;
	
	public ProdConsBuffer() {
		buffer = new ArrayList<Message>();
	}

	public void put(Message m) throws InterruptedException{
		if(buffer.size() < sizeMax) {
			buffer.add(m);
		}
	}

	public Message get() throws InterruptedException {		
		if(buffer.size() <= 0) {
			throw new InterruptedException();
		}
		return buffer.remove(buffer.size());
	}

	public int nmsg() {
		return buffer.size();
	}

}
