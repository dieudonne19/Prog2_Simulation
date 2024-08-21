package com.simulation.BugdetMaster;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

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
        return this.expenseList.stream().filter(expense -> expense.getCategory() == category).toList();
    }

    public double getTotalSpentThisMonth() {

        double total = 0.0;
        int currentMonth = LocalDate.now().getMonthValue();

        List<Expense> expenseFiltered = this.expenseList
                .stream().filter(expense -> expense.getDate().getMonthValue() == currentMonth).toList();
        for (Expense expense : expenseFiltered) {
            total += expense.getAmount();
        }
        return total;
    }

    public double getRemainingBudget() {
        int currentMonth = LocalDate.now().getMonthValue();
        double totalExpenseValue = 0.0;
        for (Expense e : this.expenseList) {
            if (e.getDate().getMonthValue() == currentMonth) {
                totalExpenseValue += e.getAmount();
            }
        }
        return this.monthlyBudget - totalExpenseValue;
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
