package leetcode.questions.x2400.to.x2499;

public class Problem_2468 {

	public static String[] splitMessage(String message, int limit) {
		
        int parts=0;  
        int suffixLen =5; //minimum suffix len ie <1/1>
        int index=0; //index of message

        int target =10; //if we hit a target we go back target-1 chars, so decrement index by that
        int available= limit-suffixLen; //number of chars we can pull from message
        
        if(available <= 0) return new String[] {};
        
        while(index < message.length()) {
        	index +=available;
        	parts++;
        	if(parts == target) {
        		index = index - target -1;
        		target*=10; //next time char len of suffix will be hit will be when we hit *10 that -> part 9 to 10
        		suffixLen+=2;//every time target hits *10 suffix len goes up by 2
        		available= limit-suffixLen;
        		if(available <= 0) return new String[] {};
        	}
        }
        index=0;
        String[] output = new String [parts];
        
        for(int part=1; part<=parts; part++) {
        	StringBuilder builder = new StringBuilder();
        	builder.append("<");builder.append(part);builder.append("/");
        	builder.append(parts);builder.append(">");
        	available= limit-builder.length();
        	if(index+ available > message.length()) {
        		output[part-1]= message.substring(index).concat(builder.toString());
        	}else {
        		output[part-1]= message.substring(index, index += available).concat(builder.toString());
        	}
        	
        }
        return output;
    }
}
