package java_projects.expense.tracker.utils;

import jakarta.annotation.PostConstruct;
import java_projects.expense.tracker.model.Expense;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseDataLoader {

    private static List<Expense> expenseList = new ArrayList<>();

    @PostConstruct
    public void init() {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream is = getClass().getResourceAsStream("/expenses.json")) {
            if (is == null) {
                throw new RuntimeException("The expenses.json file has not beed found");
            }

            expenseList = objectMapper.readValue(
                    is,
                    new TypeReference<List<Expense>>() {}
            );

        } catch (Exception e) {
            throw new RuntimeException("The expenses.json file cannot be loaded", e);
        }
    }

    public static List<Expense> getExpenseList() {
        return expenseList;
    }
}