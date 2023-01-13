package com.ensao.gi5.lint.runner;

import com.ensao.gi5.lint.Linter;
import com.ensao.gi5.lint.printer.ConsolePrinter;
import com.ensao.gi5.lint.rules.*;

public class Runner {
    public static void main(String[] args) {

        String directory = "testFiles/normalExecution/Example.java";

        for (int i = 0; i < args.length; i++) {
            String argument = args[i];
            if (argument.equals("-s")) {
                if (i == args.length - 1 || (directory = args[i + 1]).isEmpty()) {
                    System.out.println("Usage example : -s  D:/Test/Example.java");
                    throw new IllegalStateException("The directory or file are not specified");
                }
            }
        }

        final Linter linter = new Linter();
        linter.registerRule(new UnusedImportsRule());
        linter.registerRule(new CheckExpression());
        linter.registerRule(new TypeStartWIthMajWithoutUnderscore());
        linter.registerRule(new NumberParametersRule());
        linter.registerRule(new ClearVisibilityOfClasses());
        linter.registerRule(new MethodBody());
        linter.registerRule(new MethodsNumbersLessThanTwinty());
        linter.registerPrinter(new ConsolePrinter());
        linter.registerSource(directory);
        linter.run();
    }
}
