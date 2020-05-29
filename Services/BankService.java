package Services;

//imported libraries
import java.util.ArrayList;
import java.util.List;

import Models.Bank;

public class BankService {
  private Bank bank = new Bank();
  private String Name;

  // getter
  public String Name() {
    return Name;
  }

  public Float Balance() {
    return bank.Balance;
  }

  public List<String> Messages = new ArrayList<String>();

  public BankService(String name) {
    Name = name;
  }

  public void AddBalance(Float amount) {
    if (amount != null) {
      bank.Balance += amount;
    }
    Messages.add("Your balance is $" + Balance() + ".");
  }

  public void WithDraw(Float amount) {
    if (amount != null) {
      bank.Balance -= amount;
    }
    Messages.add("Your balance is $" + Balance() + ".");
  }

}