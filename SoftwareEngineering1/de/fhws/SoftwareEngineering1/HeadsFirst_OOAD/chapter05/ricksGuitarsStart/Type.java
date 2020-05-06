package de.fhws.SoftwareEngineering1.HeadsFirst_OOAD.chapter05.ricksGuitarsStart;
public enum Type { 

  ACOUSTIC, ELECTRIC;

  public String toString() {
    switch(this) {
      case ACOUSTIC: return "acoustic";
      case ELECTRIC: return "electric";
      default:       return "unspecified";
    }
  }
}
