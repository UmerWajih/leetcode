package leetcode.questions.x900.to.x999;

public class Problem_937 {
	//https://leetcode.com/problems/reorder-data-in-log-files/description/
	public String[] reorderLogFiles(String[] logs) {
        String [] arr = new String[logs.length];
        int count=0, letterCount=0;
        
        for(int i=logs.length-1; i>=0; i--){
            boolean ket=true;
            String [] log = logs[i].split(" ");
            char[] charArr = log[1].toCharArray();
            for(char c : charArr){
                if(Character.getNumericValue(c) > 9){
                    ket=false;
                    break;
                }
            }
            
            
            //digit thingy
            if(ket){
                arr[logs.length-1-count] = logs[i]; //point 3 is satisfied here
                count++;
            }else{
                //do lexicographic insertion here
                //we need to make sure that insertion is sorted
                
                int insertionIndex=0;
                for(int j=0; j<letterCount; j++ ){
                    String [] compare = arr[j].split(" ");
                    int k=1;
                    boolean flag=false;
                    while(log[k].compareTo(compare[k])==0){
                        k++;
                        
                        if(k == log.length && k < compare.length){
                            break;
                        }
                        if(k < log.length && k == compare.length){
                           insertionIndex++;flag=true;break;
                        }
                        if(k == log.length || k == compare.length){
                           break;
                        }
                        
                    }
                    if(flag){
                        continue;
                    }
                    if(k == log.length && k == compare.length){
                        k=0;
                    }
                    if(log[k].compareTo(compare[k]) > 0){
                        insertionIndex++;
                    }else{
                        break;
                    }
                }
                for(int j= letterCount; j > insertionIndex; j--){
                    arr[j] = arr[j-1];
                }
                
                arr[insertionIndex]=logs[i]; //point 1 is satisfied here
                letterCount++;
            }
        }
        return arr;
    }
}
