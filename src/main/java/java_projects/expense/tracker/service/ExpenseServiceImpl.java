package java_projects.expense.tracker.service;

import java_projects.expense.tracker.model.Expense;
import java_projects.expense.tracker.utils.ExpenseDataLoader;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Profile("json")
public class ExpenseServiceImpl implements ExpenseService {

    private static final AtomicLong idCounter = new AtomicLong(
            ExpenseDataLoader.getExpenseList().stream()
                    .mapToLong(Expense::getId)
                    .max()
                    .orElse(0L)
    );

    @Override
    public List<Expense> getExpenseByDay(String date) {
        return ExpenseDataLoader.getExpenseList().stream()
                .filter(expense -> expense.getDate().equalsIgnoreCase(date))
                .toList();
    }

    @Override
    public List<Expense> getExpenseByCategoryAndMonth(String category, String month) {
        return ExpenseDataLoader.getExpenseList().stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category)
                        && expense.getDate().startsWith(month))
                .toList();
    }

    @Override
    public List<String> getAllExpenseCategories() {
        return ExpenseDataLoader.getExpenseList().stream()
                .map(Expense::getCategory)
                .distinct()
                .toList();
    }

    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return ExpenseDataLoader.getExpenseList().stream()
                .filter(expense -> expense.getId().equals(id))
                .findFirst();
    }

    @Override
    public Expense addExpense(Expense expense) {
        expense.setId(idCounter.incrementAndGet());
        ExpenseDataLoader.getExpenseList().add(expense);
        return expense;
    }

    @Override
    public boolean updateExpense(Expense updatedExpense) {
        Optional<Expense> existingExpense = getExpenseById(updatedExpense.getId());

        if (existingExpense.isPresent()) {
            ExpenseDataLoader.getExpenseList().remove(existingExpense.get());
            ExpenseDataLoader.getExpenseList().add(updatedExpense);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteExpense(Long id) {
        Optional<Expense> existingExpense = getExpenseById(id);

        if (existingExpense.isPresent()) {
            ExpenseDataLoader.getExpenseList().remove(existingExpense.get());
            return true;
        }

        return false;
    }
}