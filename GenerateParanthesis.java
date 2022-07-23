package p5_workspace;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class GenerateParanthesis {

	private final Map<Integer, List<String>> nToParaListMap;

	public GenerateParanthesis () {
		this.nToParaListMap = new HashMap<>();
	}


	public List<String> generateParenthesis(int n) {
        if(n == 1) {
        	return List.of("()");
        }
        if (!this.nToParaListMap.containsKey(n)) {
        	Set<String> collection = new HashSet<>();
	        for(int i = 1; i < n; i++) {
	        	List<String> paraNi = generateParenthesis(n - i);
	        	List<String> paraI = generateParenthesis(i);
	        	if(i == 1) {
	        		paraNi.stream()
	        			.map(para -> "(" + para + ")")
	        			.forEach(collection::add);

	        	}
	        	for(String para1 : paraNi) {
	        		for(String para2 : paraI) {
	        			collection.add(para1 + para2);
	        			collection.add(para2 + para1);
	        		}
	        	}
	        }
	        this.nToParaListMap.put(n, new ArrayList<>(collection));
	    }
        return this.nToParaListMap.get(n);
    }

    /*
    	n = 5

    	nToParaListMap = {
    		para4 = 
    		para3 = {"((()))", "(()())", ()(()), ()()(), (())()}
    		para2 = {"(())", "()()"}
    		para1 = {"()"}

    	}

    */
}