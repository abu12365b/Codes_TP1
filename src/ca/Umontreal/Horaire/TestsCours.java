package ca.Umontreal.Horaire;

import java.util.ArrayList;

public class TestsCours {

    public static void main(String[] args) {

        ArrayList<String> datesCoursTheoriques=new ArrayList<>(); //jours des cours theoriques
        datesCoursTheoriques.add("2022-07-01");
        ArrayList<String> datesCoursPratiques=new ArrayList<>();   //debut fins
        datesCoursPratiques.add("2022-07-01");
        ArrayList<String> datesExams=new ArrayList<>();
        datesExams.add("2022-07-13");
        ArrayList<String> heuresCoursTheoriques=new ArrayList<>(); //{debut:fin}
        heuresCoursTheoriques.add("12:00:2:00");
        ArrayList<String> heuresCoursPratiques=new ArrayList<>();  //{debut:fin}
        heuresCoursPratiques.add("5:00:8:00");
        ArrayList<String> heuresExams=new ArrayList<>();
        heuresExams.add("8:00:12:00");

        Cours info=new Cours(3,"1575","IFT", datesCoursTheoriques,datesCoursPratiques,datesExams,heuresCoursTheoriques,heuresCoursPratiques,heuresExams);
        System.out.println(info.getDebutTheoriques().get(0).getTime());
        System.out.println(info.getFinTheoriques().get(0).getTime());
        System.out.println("\n"+info.getDebutPratiques().get(0).getTime());
        System.out.println(info.getFinPratiques().get(0).getTime());
        System.out.println("\n"+info.getDebutExams().get(0).getTime());
        System.out.println(info.getFinExams().get(0).getTime());


        //Test du get et set de Matiere
        System.out.println("\nTest du get et set de Matiere");
        System.out.println(info.getMatiere());
        info.setMatiere("PHY");
        System.out.println(info.getMatiere());


        //Test du get et set de numero
        System.out.println("\n Test du get et set du Numero");
        System.out.println(info.getNumero());
        info.setNumero("1000");
        System.out.println(info.getNumero());


        //Test du get et set du nb de Credit
        System.out.println("\n Test du get et set du nb de credit");
        System.out.println(info.getNbCredit());
        info.setNbCredit(2);
        System.out.println(info.getNbCredit());



    }

}
