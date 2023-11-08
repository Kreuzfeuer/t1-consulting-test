package com.kreuzfeuer.test.service.impl;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class DecompositionServiceImplTest {
    @Autowired
    private DecompositionServiceImpl underTest;


    @Test
    void getStringDecompositionTest() {
        //given
        String str = "aaaf1 f #?";

        Map<Character, Integer> check = new LinkedHashMap<>();
        check.put('a', 3);
        check.put('f', 2);
        check.put('1', 1);
        check.put('#', 1);
        check.put('?', 1);

        var checkEntries = check.entrySet();
        var checkIterator = checkEntries.iterator();

        //when
        Map<Character, Integer> testResult = underTest.getStringDecomposition(str);
        //then
        assertEquals(check.size(), testResult.size());

        var testEntries = testResult.entrySet();

        testEntries.forEach(x -> {
            var checkEntry = checkIterator.next();
            assertEquals(checkEntry.getKey(), x.getKey());
            assertEquals(checkEntry.getValue(), x.getValue());
        });

    }
}