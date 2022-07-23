package p5_workspace;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class LetterCombinationPhoneNo {

	private final Map<Character, List<Character>> digToLetterMap = Map.of(
			'2', List.of('a', 'b', 'c'), 
			'3', List.of('d', 'e', 'f'),
			'4', List.of('g', 'h', 'i'),
			'5', List.of('j', 'k', 'l'),
			'6', List.of('m', 'n', 'o'),
			'7', List.of('p', 'q', 'r', 's'),
			'8', List.of('t', 'u', 'v'),
			'9', List.of('w', 'x', 'y', 'z')
	);

	public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) 
            return Collections.emptyList();
        return buildLetterCombinations(digits, 0);
    }

    private List<String> buildLetterCombinations(String digits, int idx) {
    	if(idx == digits.length() - 1) {
    		return digToLetterMap.get(digits.charAt(idx))
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    	} 
    	List<String> combinations = new ArrayList<>();
    	List<String> laterCombinations = buildLetterCombinations(digits, idx + 1);
    	for(Character c : digToLetterMap.get(digits.charAt(idx))) {
    		for(String comb : laterCombinations) {
    			combinations.add(c + comb);
    		}
    	}
    	return combinations;
    }

}