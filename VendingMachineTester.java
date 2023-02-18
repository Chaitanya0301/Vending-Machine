// Vending Machine class tester

import java.util.Arrays;

/**
 * This is the vending machine tester class which contains tester methods
 * for the vending machine class.
 *
 * @author Chaitanya Sharma
 */
public class VendingMachineTester {
  /**
   * Test cases for getIndexNextItem method. Tests whether the item is in the array,
   * the method does not alter the contents and returns the correct output.
   *
   * @return false if any of the test cases fail and true if all pass.
   */
  public static boolean testGetIndexNextItem() {
    //Next item to be dispensed is NOT found: the expected output is -1
    {
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;
      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    //Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  /**
   * Checks the correctness of containsItem defined in the VendingMachine class.
   *
   * @return false if any of the test cases fail and true if all pass.
   */

  public static boolean testContainsItem() {
    //(1) successful search returning true
    String[][] items = new String[][] {{"Zombie cap", "15"}, {"Lava Bucket", "10"}, {"Juice", "20"}, {"Water", "5"},
                    {"Teddy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if(VendingMachine.containsItem("Juice",items,7) != true){
      return false;
    }
    // unsuccessful search returning false.
    if(VendingMachine.containsItem("Ice",items,7) == true){
      return false;
    }
    return true; // no bug detected
  }

  /**
   * Checks the correctness of getItemAtIndex defined in the VendingMachine class.
   *
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */

  public static boolean testGetItemAtIndex() {
    // (1) the provided index is out of the range 0..itemsCount-1
    String[][] items = new String[][] {{"Water Bottle", "15"}, {" Dark Chocolate", "10"}, {"Juice", "20"}, {"Water Box", "5"},
                    {"Pink Candy", "30"}, {"Water Can", "15"}, {"Chocolate cake", "10"}, null, null};
    {
      if(!VendingMachine.getItemAtIndex(11,items,7).equals("ERROR INVALID INDEX")){
        return false;
      }
    }
    //2) the provided index is in bounds [0..itemsCount-1].
    {
      if(!VendingMachine.getItemAtIndex(2,items,7).equals("Juice (20)")){
        return false;
      }
    }
    return true; // no bug detected
  }

  /**
   * Checks the correctness of getItemOccurrences defined in the VendingMachine class.
   *
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */

  public static boolean testGetItemsOccurrences() {
    String[][] items = new String[][] {{"Water can", "15"}, {"Chocolate muffin", "10"}, {"Juice", "20"}, {"Water can", "5"},
            {"Candy box", "30"}, {"Water can", "15"}, {"Chocolate muffin", "10"}, null, null};
  // (1) no match found so that the method returns zero,
    if(VendingMachine.getItemOccurrences("Ice",items,7) != 0){
      return false;
    }
    // (2) the items array contains multiple occurrences of the provided item description.
    if(VendingMachine.getItemOccurrences("Water can",items,7) != 3){
      return false;
    }
    return true; // no bug detected
  }

  /**
   * Checks the correctness of addItem defined in the VendingMachine class.
   *
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testAddItem() {
    // (1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0)
    {
      String[][] items = new String[0][0];
      if (VendingMachine.addItem("Soda", "10", items, 0) != 0) {
        return false;
      }
    }
    //(2) adding a new item to a non-empty non-full vending machine
    {
      String[][] item = new String[][]{{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null};
      if (VendingMachine.addItem("Soda", "10", item, 3) != 4) {
        return false;
      }
    }
    // (3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.
    {
      String[][] iteM = new String[][]{{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}};
      if (VendingMachine.addItem("Soda", "10", iteM, 3) != 3) {
        return false;
      }
    }
    return true; // no bug detected
  }

  /**
   *  Checks the correctness of removeNextItem defined in the VendingMachine class.
   *
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testRemoveNextItem() {
    String[][] items = new String[][]{{"Water", "15"},{"Chocolate", "10"}, {"Juice", "20"},{"Water","20"},{"Juice","13"},null,null};
    //(1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not)
    if(VendingMachine.removeNextItem("Soda",items,5) != 5){
      return false;
    }
    // (2) the next item to be removed matching the provided description is at index 0 of the array
    if(VendingMachine.removeNextItem("Water",items,5) != 4 ){
      return false;
    }
    // (3) the next item to be removed is at index itemsCount of the array (at the end of the array)
    String[][] item = new String[][]{{"Water", "15"},{"Chocolate", "10"}, {"Juice", "20"},{"Water","20"},{"Juice","13"},null,null};
    if(VendingMachine.removeNextItem("Juice",item,5) != 4){
      return false;
    }
    // (4) the next item to be removed is at a middle index of the provided items array.
    String[][] iteM = new String[][]{{"Water", "15"},{"Chocolate", "10"}, {"Juice", "20"},{"Water","20"},{"Juice","13"},null,null};
    if(VendingMachine.removeNextItem("Chocolate",iteM,5) != 4){
      return false;
    }
    return true; // no bug detected
  }

  /**
   * Checks the correctness of getItemsSummary defined in the VendingMachine class.
   *
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */

  public static boolean testGetItemsSummary() {
    String[][] items = new String[][]{{"Water", "15"}, {"Chocolate", "10"}, {"Water", "5"}, {"Juice", "20"}};
    String[][] item = new String[][]{null};
    String[][] iteM = new String[][]{{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}};
    // (1) the vending machine is empty
    if (!VendingMachine.getItemsSummary(item, 0).equals("")){
      return false;
    }
    // (2) the vending machine contains non duplicate items (no multiple items with the same description)
    if (!VendingMachine.getItemsSummary(iteM, 3).equals("Water (1)\nChocolate (1)\nJuice (1)\n")) {
      return false;
    }
    // (3) the vending machine contains multiple items with the same description at various index locations.
    if (!VendingMachine.getItemsSummary(items, 4).equals("Water (2)\nChocolate (1)\nJuice (1)\n")){
      return false;
    }
    return true; // no bugs detected
  }

  /**
   * Calls all tester methods for the vending machine class and tests the entire program.
   * @return false if any of the tester methods defined in this class fails, and true if no bug detected.
   */
  public static boolean runAllTests() {
    if(testAddItem()== false){
      return false;
    }
    if(testGetItemAtIndex() == false){
      return false;
    }
    if(testContainsItem() == false){
      return false;
    }
    if(testGetItemsOccurrences()== false){
      return false;
    }
    if(testRemoveNextItem()== false){
      return false;
    }
    if(testGetItemsSummary()== false){
      return false;
    }

    return true; // no bugs detected in the program
  }

  /**
   * main method to call the tester methods defined in this class
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
    System.out.println("runAllTests(): " + runAllTests());
  }

}
