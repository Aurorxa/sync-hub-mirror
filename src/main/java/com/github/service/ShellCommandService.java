package com.github.service;

import com.github.rest.ShellCommandResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class ShellCommandService {

    public ShellCommandResult executeCommand(String command) {
        return executeCommand(command, "/bin/ash");
    }

    public ShellCommandResult executeCommand(String command, String shell) {
        log.info("Executing command: {}", command);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        CommandLine commandLine = new CommandLine(shell);
        commandLine.addArgument("-c");
        commandLine.addArgument(command, false);
        DefaultExecutor executor = DefaultExecutor
                .builder()
                .get();
        executor.setStreamHandler(new PumpStreamHandler(outputStream, errorStream));
        int exitCode;
        try {
            exitCode = executor.execute(commandLine);
        } catch (Exception e) {
            exitCode = -1;
            try {
                errorStream.write(("Error: " + e.getMessage()).getBytes());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        ShellCommandResult result = new ShellCommandResult(exitCode, outputStream.toString(), errorStream.toString());
        log.info("Command result: {}", result);
        return result;
    }
}
