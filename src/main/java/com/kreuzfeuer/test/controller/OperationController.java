package com.kreuzfeuer.test.controller;

import com.kreuzfeuer.test.service.DecompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OperationController {

    private final DecompositionService decompositionService;

    /**
     * @param str - a not empty string argument storing the string to be decomposed
     * @return a map containing information about the decomposition of strings according to a given condition.
     */

    @PostMapping(path = "/decomposition", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Character, Integer>> getStringDecomposition(@RequestBody @NonNull String str) {

        return ResponseEntity.ok(decompositionService.getStringDecomposition(str));
    }
}
