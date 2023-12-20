package com.kingdom.manager.models;

import java.util.UUID;

public record BankAccount(
        UUID id,
        String bankName,
        String bankAccount,
        String agency,
        String account,
        BankAccountTypes accountType,
        Person owner
) {
    public enum BankAccountTypes {
        SALARY,
        SAVING,
        CURRENT,
    }
}
