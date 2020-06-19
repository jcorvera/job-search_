package com.jobSearch;

import com.beust.jcommander.JCommander;
import com.jobSearch.api.IApiJob;
import com.jobSearch.cli.CLIArguments;
import com.jobSearch.cli.CLIFunction;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.jobSearch.CommanderFunction.buildCommanderWithName;
import static com.jobSearch.CommanderFunction.parseArguments;
import static com.jobSearch.api.IApiFunction.buildAPI;

public class Main {
    public static void main(String[] args) {

        JCommander jCommander = buildCommanderWithName("job-search",CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
                        parseArguments(jCommander, args, JCommander::usage)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArguments = streamOfCLI
                .filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();



        cliArguments.map(CLIFunction::toMap)
        .map(Main::executeRequest)
        .orElse(Stream.empty())
        .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        IApiJob api = buildAPI(IApiJob.class,"https://jobs.github.com");
        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
