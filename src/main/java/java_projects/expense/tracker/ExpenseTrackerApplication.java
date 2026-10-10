package java_projects.expense.tracker;

import java_projects.expense.tracker.model.Expense;
import java_projects.expense.tracker.utils.ExpenseDataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ExpenseTrackerApplication implements CommandLineRunner {

	public static void main (String[] args){

		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Expense> expenseList = ExpenseDataLoader.getExpenseList();
		expenseList.forEach(System.out::println);
	}
}
