package com.simulation.BugdetMaster;

import java.util.List;

public class User {
    private String name;
    private double monthlyBudget;
    private List<Expense> expenseList;

    public User(String name, double monthlyBudget, List<Expense> expenseList) {
        this.name = name;
        this.monthlyBudget = monthlyBudget;
        this.expenseList = expenseList;
    }


    public void addExpense (Expense newExpense){
        if (newExpense.getAmount() < 0) {
            System.out.println("Expense amount must be a positive number");
        }
        this.expenseList.add(newExpense);
    }

    public List<Expense> getExpenseByCategory(Categories category) {
        return (List<Expense>) this.expenseList.stream().filter(expense -> expense.getCategory() == category);
    }



    public String getName() {
        return name;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", budget=" + monthlyBudget +
                ", spentList=" + expenseList +
                '}';
    }
}
