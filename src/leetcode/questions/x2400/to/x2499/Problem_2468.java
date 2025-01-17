package leetcode.questions.x2400.to.x2499;

public class Problem_2468 {

	public static String[] splitMessage(String message, int limit) {
		
        int parts=0, target =10, suffixLen =5, index=0;
        int available= limit-suffixLen;
        
        if(available == 0) return new String[] {};
        
        while(index < message.length()) {
        	index +=available;
        	parts++;
        	if(parts == target) {
        		index = index - target -1;
        		target*=10;
        		suffixLen+=2;
        		available= limit-suffixLen;
        		if(available == 0) return new String[] {};
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
