package com.kreuzfeuer.test.service.impl;

import com.kreuzfeuer.test.service.DecompositionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Service class with application business logic.
 *
 * @author Kreuzfeuer
 */
@Service
public class DecompositionServiceImpl implements DecompositionService {
    /**
     * Method of string decomposition and transformation according to the format specified by
     * the task conditions. The method does not take into account spaces and some control characters.
     *
     * @param string - a string argument storing the string to be decomposed
     * @return - a map containing the result of string decomposition in the required order
     */

    @Override
    public Map<Character, Integer> getStringDecomposition(final String string) {
        Map<Character, Integer> hm = new HashMap<>();
        Map<Character, Integer> resultMap = new LinkedHashMap<>();

        String str = Pattern.compile("[\\h\\v]", Pattern.UNICODE_CHARACTER_CLASS).matcher(string).replaceAll("");

        for (int i = 0; i < str.length(); i++) {
            hm.put((str.charAt(i)), hm.getOrDefault(str.charAt(i), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hm.entrySet().stream().toList());
        list.sort((cur, other) -> other.getValue() - cur.getValue());

        list.forEach(x -> resultMap.put(x.getKey(), x.getValue()));
        return resultMap;
    }
}
