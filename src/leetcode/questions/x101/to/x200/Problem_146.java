package leetcode.questions.x101.to.x200;

public class Problem_146 {
	//https://leetcode.com/problems/lru-cache
	
	public static class LRUCache {
		//one solution
		//create a Map, too expensive
		//would need to update call rate on every iteration
		public  static class LRUNode {
			int key;
			int value;
			LRUNode next;
			LRUNode prev;
		}
		int capacity;
		LRUNode node; //most recent used node
		int cacheSize=0;
		
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	    	LRUNode val = node;
	    	while(val!=null && val.key!=key) {
	    		val=val.next;
	    	}
	    	if(val==null)return -1;
	    	//update LRU if a node from the back was called
	    	if(val.key!=node.key) {
	    		val.prev.next=val.next;
		    	val.next=node;
		    	if(this.node!=null)node.prev=val;
		    	val.prev=null;
		    	node=val;
	    	}
	    	
	    	
	    	return val.value;
	    }
	    
	    public LRUNode getNodeByKey(int key) {
	    	LRUNode val = node;
	    	while(val!=null && val.key!=key) {
	    		val=val.next;
	    	}
	    	if(val==null)return null;
	    	//update LRU if a node from the back was called
	    	if(val.key!=node.key) {
	    		val.prev.next=val.next;
		    	val.next=node;
		    	if(this.node!=null)node.prev=val;
		    	val.prev=null;
		    	node=val;
	    	}
	    	
	    	
	    	return val;
	    }
	    
	    public void put(int key, int value) {
	    	LRUNode node = new LRUNode();
	    	node.key=key;
	    	node.value=value;	
	    	if(this.capacity==1) {
	    		this.node =node;
	    		return;
	    	}
	    	
	    	
	    	LRUNode check=getNodeByKey(key);
	    	if(check!=null) {
	    		check.value=value;
	    		return;
	    	}
	    	
	        if(this.cacheSize < this.capacity) {
	        	this.cacheSize++;
	        }else {
	        	//we need to evict the last value
	        	LRUNode evict = this.node;
	        	while(evict.next!=null) {
	        		evict=evict.next;
	        	}
	        	if(evict.prev!=null)evict.prev.next=null; //evicted the last value
	        }

        	node.next=this.node;
        	if(this.node!=null)this.node.prev=node;
        	this.node = node;
	    }
	}
}
