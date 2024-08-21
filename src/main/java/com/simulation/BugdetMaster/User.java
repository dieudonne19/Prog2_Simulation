package com.simulation.BugdetMaster;

import java.util.List;

public class User {
    private String name;
    private double budget;
    private List<Spent> spentList;

    public User(String name, double budget, List<Spent> spentList) {
        this.name = name;
        this.budget = budget;
        this.spentList = spentList;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", spentList=" + spentList +
                '}';
    }
}
