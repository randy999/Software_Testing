package lab2;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
	boolean isSucess=false;
    public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return dataList;
    }
    public static void main(String args[]){
    	 List<String> dataList=CSVUtils.importCsv(new File("D:\\eclipse_workplace\\inputgit.csv"));
	        if(dataList!=null && !dataList.isEmpty()){
	        	int i = 0;
	            for(String data : dataList){
	            	i++;
	            	if(i == 1)
	            		continue;
	                System.out.println(data.substring(0,10));
	                int a = 11 ,b = 12;
	                while(b<data.length()){
	                	if(data.charAt(b) == ','){
//	                		System.out.println(data.substring(a,b));
//	    	                System.out.println(data.substring(b+1));
	    	                break;
	                	}
	                		
	                	b++;
	                }
	                System.out.println(data.substring(4,10));
	                System.out.println(data.substring(a,b));
	                System.out.println(data.substring(b+1));
	                
	            }
	        }
    }
}