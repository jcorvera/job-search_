package com.jobSearch.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunction {
    public static Map<String, Object> toMap(CLIArguments cliArguments) {
        Map<String, Object> params =  new HashMap<>();
        params.put("description",cliArguments.getKeyword());
        params.put("location", cliArguments.getLocation());
        params.put("full_time",cliArguments.isFullTime());
        if (cliArguments.isMarkdown()) {
            params.put("markdown",true);
        }
        return params;
    }
}
