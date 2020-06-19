package com.jobSearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD"
    )
    private String keyword;
    @Parameter(
            names = {"--location","-l"},
            description = "Every search can include a locations"
    )
    private String location;
    @Parameter(
            names = {"---page -p"},
            description = "API return 50 results per page"
    )
    private int page=0;
    @Parameter(
            names = {"--full-time"},
            description = "Add if we want full-time job"
    )
    private boolean isFullTime = false;
    @Parameter(
            names = {"--markdown"},
            description = "Get results in markdown"
    )
    private boolean isMarkdown = false;
    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Show this help"
    )
    private boolean isHelp;

    CLIArguments(){ }

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
