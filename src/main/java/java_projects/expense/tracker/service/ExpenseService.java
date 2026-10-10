package java_projects.expense.tracker.service;

import java_projects.expense.tracker.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    List<Expense> getExpenseByDay(String date);
    List<Expense> getExpenseByCategoryAndMonth(String category, String month);
    List<String> getAllExpenseCategories();
    Optional<Expense> getExpenseById(Long id);
    Expense addExpense(Expense expanse);
    boolean updateExpense(Expense expense);
    boolean deleteExpense(Long id);

}
