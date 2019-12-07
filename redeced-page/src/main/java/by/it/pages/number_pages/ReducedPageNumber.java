package by.it.pages.number_pages;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ReducedPageNumber {

	 public static String reducedPageNumbers (String str) throws NumberFormatException{
	        boolean flag = true;
	        Map<Integer, String> map = new TreeMap<Integer, String>();
	        StringBuilder sb = new StringBuilder();
	        try {
	            String[] arr = str.replaceAll(" ", "").split(",");
	            for (String el : arr) {
	                Integer key = Integer.parseInt(el);
	                if (key<=0){
	                    throw new NumberFormatException();
	                }
	                map.put(key, el);
	            }
	        } catch (NumberFormatException e){
	            throw new NumberFormatException("incorrect format");
	        }
	        Iterator<Map.Entry<Integer,String>> iterator=map.entrySet().iterator();
	        Entry<Integer, String> first = iterator.next();
	        while (iterator.hasNext()){
	            Entry<Integer, String> last = iterator.next();
	            int f = (Integer) first.getKey();
	            int l = (Integer) last.getKey();
	            if (l-f==1 && flag){
	                sb.append(first.getValue());
	                sb.append("-");
	                flag=false;
	            } else if (!flag){
	                if (l-f!=1){
	                    flag=true;
	                    sb.append(first.getValue());
	                    sb.append(",");
	                }
	            }
	            else {
	                sb.append(first.getValue());
	                sb.append(",");
	            }
	            first=last;
	        }
	        sb.append(first.getValue());
	        String res = sb.toString();
	        return res;
	    }
}
