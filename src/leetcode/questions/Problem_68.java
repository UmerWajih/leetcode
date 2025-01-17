package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/text-justification
public class Problem_68 {

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String>  output = new ArrayList<>();
		int len=0;
		List<String>  tem = new ArrayList<>();
		for(String str : words) {
			if(len + str.length() >maxWidth) {
				output.add(getSentence(tem,  len,maxWidth));
				len =0; tem.clear();
			}
			tem.add(str);
			len+= str.length()+1;
		}
	
		output.add(lefAligned(tem,  len,maxWidth));
		
		return output;
    }
	
	private static String lefAligned(List<String>  tem, int len, int maxWidth) {
		//remove space len
		len = len - tem.size();
		
		StringBuilder builder = new StringBuilder();
		
		for(int i =0; i< tem.size(); i++) {
			builder.append(tem.get(i));
			
			if(builder.length()+1 < maxWidth) {
				builder.append(" ");
			}
		}
		//fill out spaces at the end
		while(builder.length() != maxWidth) {
			builder.append(" ");
		}
		
		return builder.toString();
	}
	
	private static String getSentence(List<String>  tem, int len, int maxWidth) {
		//remove space len
		len = len - tem.size();
		int numberOfSpaces = maxWidth - len;
		//these words will have extraSpaces
		int space = tem.size() == 1 ? 0 : numberOfSpaces / (tem.size()-1);
		int extraSpaces = tem.size() == 1 ? 0 : numberOfSpaces % (tem.size()-1);
		
		StringBuilder builder = new StringBuilder();
		
		for(int i =0; i< tem.size(); i++) {
			builder.append(tem.get(i));
			if(i < tem.size()-1) {
				for (int j = 0; j< space; j++) {
					builder.append(" ");
				}
				if(i+1 <= extraSpaces) {
					builder.append(" ");
				}
			}else {
				while(builder.length() != maxWidth) {
					builder.append(" ");
				}
			}
			
		}
		return builder.toString();
	}
}
