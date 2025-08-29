
void setup(){
  //Rückgabewert in einer neuen Variable speichern.
  //Die Variable kann dann im weiteren Programm verwendet werden
  float totalPrice = calculateTotalPrice(12.5, 3.99);
  println(totalPrice);
  
  //Rückgabewert nicht speichern, sondern direkt mit println ausgeben
  println(calculateTotalPrice(3, 4.5));
}


float calculateTotalPrice(float kg, float price) {
  return kg*price;
}
