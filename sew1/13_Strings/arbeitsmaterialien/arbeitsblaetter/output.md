  --------------------------------------------------------------------------------------------------------
  Arbeitsblatt Array 1                                                                          
  ------------------ ------------ ------------- ---------------------- -------------- --------------------
  Themengebiet(e):                Strings                                             
                                  untersuchen                                         

  Ersteller:                      **Reinhold                                          
                                  Buchinger**                                         

                                                                                      

  **VERSION**        **DATUM**                  **AUTORIN/AUTOR**      **ÄNDERUNG**   

  v1.0               25.02.2019                 Reinhold Buchinger     Erstellung     

                                                                                      
  --------------------------------------------------------------------------------------------------------

Gegeben ist folgender String:

String **bspString** = **\"Die Welt der Strings\"**;

  -------------------------------------------------------------------------
       **Methode / Ausdruck**                    **Ergebnis    **Ergebnis
                                                 Datentyp**    Wert**
  ---- ----------------------------------------- ------------- ------------
  1    bspString.length();                                     

  2    bspString.charAt(1);                                    

  3    !bspString.equals(**\"Die Welt\"**);                    

  4    bspString.charAt(bspString.length()-2);                 

  5    bspString.indexOf(**\'w\'**);                           

  6    bspString.equalsIgnoreCase(**\"Die Welt                 
       der Strings\"**);                                       

  7    bspString.charAt(3) == **\' \';**                       

  8    bspString.indexOf(**\'o\'**);                           

  9    bspString.equals(**\"Die Welt der                       
       Strings\"**);                                           

  10   bspString.endsWith(**\"r Strings\"**);                  
  -------------------------------------------------------------------------

  ----------------------------------------------------------------------------------
       **Methode / Ausdruck**                              **Ergebnis   **Ergebnis
                                                           Datentyp**   Wert**
  ---- --------------------------------------------------- ------------ ------------
  11   !bspString.startsWith(**\"Die\"**);                              

  12   bspString.indexOf(**\'W\'**);                                    

  13   bspString.equalsIgnoreCase(**\"Die welt der                      
       strings\"**);                                                    

  14   bspString.equals(**\"Die Welt\"**);                              

  15   bspString.indexOf(**\'e\'**,3);                                  

  16   bspString.indexOf(**\' \'**);                                    

  17   bspString.indexOf(**\'t\'**,6);                                  

  18   bspString.indexOf(**\"der\"**);                                  

  19   bspString.indexOf(**\"der\"**,10);                               

  20   bspString.indexOf(**\'S\'**) == -1                               

  21   bspString.indexOf(**\'r\'**) \> 5                                

  22   bspString.length() + **\"Semmel\"**.length()                     

  23   bspString.charAt(bspString.indexOf(**\'e\'**,3) +                
       2);                                                              

  24   bspString.contains(**\"der\"**);                                 
  ----------------------------------------------------------------------------------
