/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Calendar;
import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePK;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;
/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        EmployeTacheService ets = new EmployeTacheService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();

        // Création des employés
        Employe e1 = new Employe("anwar", "Bliout", "0667805006");
        Employe e2 = new Employe("mohamed", "fezzazi", "064572219");
        es.create(e1);
        es.create(e2);

        // Création d'un projet
        Calendar calendarDebut1 = Calendar.getInstance();
        calendarDebut1.set(2022, Calendar.OCTOBER, 5);
        Calendar calendarDebut2 = Calendar.getInstance();
        calendarDebut2.set(2022, Calendar.DECEMBER, 16);
        Projet p = new Projet("Finance", calendarDebut1.getTime(), calendarDebut2.getTime(), e2);
        ps.create(p);

        // Création de tâches
        Tache t = new Tache("Bilan", calendarDebut1.getTime(), calendarDebut2.getTime(), 20000, p);
        Tache t2 = new Tache("comptabilite", calendarDebut1.getTime(), calendarDebut2.getTime(), 10000, p);
        ts.create(t);
        ts.create(t2);

        // Attribution des tâches à "mohamed"
        Date dateAttribution = new Date();

        EmployeTachePK employeTachePK1 = new EmployeTachePK(e2.getId(), t.getId(), dateAttribution);
        EmployeTache employeTache1 = new EmployeTache(employeTachePK1);
        ets.create(employeTache1);

        EmployeTachePK employeTachePK2 = new EmployeTachePK(e2.getId(), t2.getId(), dateAttribution);
        EmployeTache employeTache2 = new EmployeTache(employeTachePK2);
        ets.create(employeTache2);
        //3
        es.getTasksByEmployee(e2);
        //4
        es.getProjectsByEmployee(e2);
        //5
        ps.getTachesByProjets(p);
        //6
        ps.getTasksByProjectOrdonne(p);
        //7
        ts.getTachesPlus1000(t2);
        //8
        Date d1 = new Date("2021/02/01");
        Date d2 = new Date("2024/02/01");
        System.out.println(ts.getBetweenDate(d1, d2));
        for (Tache y : ts.getBetweenDate(d1, d2)) {
            System.out.println(y);
        }

    }
}
