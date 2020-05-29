package Controllers;

//NOTE Imported Libraries
import Services.BankService;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

public class BankController {
  private BankService _bs;
  private Boolean running = true;

  public void Run() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to the Banker9000TM");
    System.out.println("What is your name?");
    String name = sc.nextLine();
    _bs = new BankService(name);
    System.out.println("Welcome " + name + ". Your balance is $" + _bs.Balance() + ". What would you like to do?");
    while (running) {
      takeInput(sc);
      Print();
    }
    sc.close();
  }

  public void takeInput(Scanner scanner) {
    System.out.println("Input here: ");
    String response = scanner.next();
    String command = response.split(" ")[0];
    String option = "";
    // if (response.split(" ")[1] != null) {
    // option = response.split(" ")[1];
    // }
    switch (command) {
      case "stop":
        running = false;
        break;
      case "add":
        Float amount = Float.parseFloat(option);
        _bs.AddBalance(amount);
        break;
      case "take":
        Float take = Float.parseFloat(option);
        _bs.AddBalance(take);
        break;
      default:
        _bs.Messages.add("Not a recognized command");
    }
  }

  public void Print() {
    System.console().flush();
    _bs.Messages.forEach((message) -> {
      System.out.println(message);
    });
  }
}