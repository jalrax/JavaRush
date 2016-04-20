package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor
{
    private static Map<Operation, Command> commands;

    static
    {
        commands = new HashMap<>();
        commands.put(Operation.DEPOSIT, new DepositCommand());
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.WITHDRAW, new WithdrawCommand());
        commands.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor()
    {
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        commands.get(operation).execute();
    }
}