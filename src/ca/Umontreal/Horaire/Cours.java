package ca.Umontreal.Horaire;
import java.util.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Class qui represente un cours
 */
public class Cours extends Calendar {
  private String numero;
  private int nbCredit;
  private String matiere;
  private ArrayList<String> datesCoursTheoriques; //jours des cours theoriques
  private ArrayList<String> datesCoursPratiques;   //debut fins
  private ArrayList<String> datesExams;
  private ArrayList<String> heuresCoursTheoriques; //{debut:fin}
  private ArrayList<String> heuresCoursPratiques;  //{debut:fin}
  private ArrayList<String> heuresExams;           //{debut:fin}



  //Theoriques contient les infos pour les  debut cours theoriques
  private ArrayList<Calendar> DebutTheoriques=new ArrayList<Calendar>();//Dates des cours theo avec heures de debut
  private ArrayList<Calendar> FinTheoriques=new ArrayList<Calendar>(); // Dates cours theoriques avec heures fin cours

  private ArrayList<Calendar> DebutPratiques=new ArrayList<Calendar>();//Dates des cours theo avec heures de debut

  private ArrayList<Calendar> FinPratiques=new ArrayList<Calendar>(); // Dates cours Pratiques avec heures fin cours

  private ArrayList<Calendar> DebutExams=new ArrayList<Calendar>();//Dates des cours theo avec heures de debut

  private ArrayList<Calendar> FinExams=new ArrayList<Calendar>(); // Dates cours Pratiques avec heures fin cours

  /**
   * Constructeur de la classe ccours
   * @param nbCredit
   * @param numero
   * @param matiere
   * @param datesCoursTheoriques
   * @param datesCoursPratiques
   * @param datesExams
   * @param heuresCoursTheoriques
   * @param heuresCoursPratiques
   * @param heuresExams
   */
  public Cours(int nbCredit, String numero, String matiere, ArrayList<String> datesCoursTheoriques, ArrayList<String> datesCoursPratiques, ArrayList<String> datesExams, ArrayList<String> heuresCoursTheoriques, ArrayList<String> heuresCoursPratiques, ArrayList<String> heuresExams){
    this.numero=numero;
    this.nbCredit=nbCredit;
    this.matiere=matiere;
    this.datesCoursTheoriques=datesCoursTheoriques;
    this.datesCoursPratiques=datesCoursPratiques;
    this.datesExams=datesExams;
    this.heuresCoursTheoriques=heuresCoursTheoriques;
    this.heuresCoursPratiques=heuresCoursPratiques;
    this.heuresExams=heuresExams;




    this.DebutTheoriques=InfoDebut(datesCoursTheoriques,heuresCoursTheoriques);
    this.FinTheoriques=InfoFin(datesCoursTheoriques,heuresCoursTheoriques);
    this.DebutPratiques=InfoDebut(datesCoursPratiques,heuresCoursPratiques);
    this.FinPratiques=InfoFin(datesCoursPratiques,heuresCoursPratiques);
    this.DebutExams=InfoDebut(datesExams,heuresExams);
    this.FinExams=InfoFin(datesExams,heuresExams);




  }

  public ArrayList<Calendar> InfoFin(ArrayList<String> datesCoursTheoriques,ArrayList<String> heuresCoursTheoriques) {
    ArrayList<Calendar> FinTheoriques=new ArrayList<Calendar>(); // Dates cours theoriques avec heures fin cours

    for (int i = 0; i <datesCoursTheoriques.size() ; i++) {//Ajout date cours theoriques
      String[] partieDate=datesCoursTheoriques.get(i).split("-");

      //instancie un calendrier pour ajd mais on le vide

      Calendar joursFin=Calendar.getInstance();
      joursFin.clear();

      //on prend instancie les jours de cours et on indique aussi les heures de debut et fin de cours

      joursFin.set(parseInt(partieDate[0]),parseInt(partieDate[1])-1,parseInt(partieDate[2]));

      //ajoute info sur cours theoriques dans une arraylist

      FinTheoriques.add(joursFin);

      String[] partieHeure=heuresCoursTheoriques.get(i).split(":");
      joursFin.set(Calendar.HOUR,parseInt(partieHeure[2]));
      joursFin.set(Calendar.MINUTE,parseInt(partieHeure[3]));


    }
    return FinTheoriques;}



  //Info sur Debut COurs date et heure debut
  public ArrayList<Calendar> InfoDebut(ArrayList<String> datesCoursTheoriques,ArrayList<String> heuresCoursTheoriques) {
    ArrayList<Calendar> DebutTheoriques = new ArrayList<Calendar>();//Dates des cours theo avec heures de debut


    for (int i = 0; i < datesCoursTheoriques.size(); i++) {//Ajout date cours theoriques
      String[] partieDate = datesCoursTheoriques.get(i).split("-");

      //instancie un calendrier pour ajd mais on le vide
      Calendar jours = Calendar.getInstance();
      jours.clear();


      //on prend instancie les jours de cours et on indique aussi les heures de debut et fin de cours
      jours.set(parseInt(partieDate[0]), parseInt(partieDate[1]) - 1, parseInt(partieDate[2]));


      //ajoute info sur cours theoriques dans une arraylist
      DebutTheoriques.add(jours);

      //Ajoute info sur les heures de debut et fin d'un cours
      String[] partieHeure=heuresCoursTheoriques.get(i).split(":");
      jours.set(Calendar.HOUR,parseInt(partieHeure[0]));
      jours.set(Calendar.MINUTE,parseInt(partieHeure[1]));


    }
    return DebutTheoriques;}



  @Override
  protected void computeTime() {

  }

  @Override
  protected void computeFields() {

  }

  @Override
  public void add(int field, int amount) {

  }

  @Override
  public void roll(int field, boolean up) {

  }

  @Override
  public int getMinimum(int field) {
    return 0;
  }

  @Override
  public int getMaximum(int field) {
    return 0;
  }

  @Override
  public int getGreatestMinimum(int field) {
    return 0;
  }

  @Override
  public int getLeastMaximum(int field) {
    return 0;
  }





  /**
   * Getter pour numero du cours
   * @return
   */
  public String getNumero(){
    return numero;
  }

  /**
   * Setter du numero de cours
   * @param nouveauNum
   */
  public void setNumero(String nouveauNum){
    this.numero=nouveauNum;
  }

  /**
   * Getter de nom de matiere
   * @return
   */
  public String getMatiere(){
    return matiere;
  }

  public void setMatiere(String nouveauMatiere){
    this.matiere=nouveauMatiere;
  }
  /**
   * Getter de nombre de credits
   * @return
   */
  public int getNbCredit(){
    return nbCredit;
  }

  /**
   * Setter du nombre de credit
   * @param newNbCredit
   */
  public void setNbCredit(int newNbCredit){
    this.nbCredit=newNbCredit;
  }

  /**
   * Getter ArrayList<Calendar> du getDebutTheoriques
   * @return
   */
  public ArrayList<Calendar> getDebutTheoriques(){
    return DebutTheoriques;
  }

  /**
   * Getter ArrayList<Calendar> du getFinTheoriques
   * @return
   */
  public ArrayList<Calendar> getFinTheoriques(){
    return FinTheoriques;
  }

  /**
   * Getter ArrayList<Calendar> du getDebutPratiques
   * @return
   */
  public ArrayList<Calendar> getDebutPratiques(){
    return DebutPratiques;
  }

  /**
   * Getter ArrayList<Calendar> du getFinPratiques
   * @return
   */
  public ArrayList<Calendar> getFinPratiques(){
    return FinPratiques;
  }

  /**
   * Getter ArrayList<Calendar> du getDebutExams
   * @return
   */
  public ArrayList<Calendar> getDebutExams(){
    return DebutExams;
  }

  /**
   * Getter ArrayList<Calendar> du getFinExams
   * @return
   */
  public ArrayList<Calendar> getFinExams(){
    return FinExams;
  }




}
