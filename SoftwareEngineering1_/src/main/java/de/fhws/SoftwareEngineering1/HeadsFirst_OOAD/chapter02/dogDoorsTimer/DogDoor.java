package de.fhws.SoftwareEngineering1.HeadsFirst_OOAD.chapter02.dogDoorsTimer;
public class DogDoor {

  private boolean open;

  public DogDoor() {
    this.open = false;
  }

  public void open() {
    System.out.println("The dog door opens.");
    open = true;
  }

  public void close() {
    System.out.println("The dog door closes.");
    open = false;
  }

  public boolean isOpen() {
    return open;                      
  }                  
}
