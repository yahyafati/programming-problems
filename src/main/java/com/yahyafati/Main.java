package com.yahyafati;

import com.yahyafati.problems.IProblem;
import com.yahyafati.problems.OneDArray;

public class Main {
    public static void main(String[] args) {
        IProblem problem = new OneDArray();
        problem.solve();
    }
}