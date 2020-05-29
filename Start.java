import Controllers.BankController;

public class Start {
  public static void main(String[] args) {
    System.console().flush();
    BankController bc = new BankController();
    bc.Run();
  }
}