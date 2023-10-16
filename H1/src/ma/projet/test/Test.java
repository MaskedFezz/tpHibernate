/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = null;
        Date dateFin = null;
        ProduitService ps = new ProduitService();
        Produit p1 = new Produit("adidas", "superstar", "chaussure", new Date(), 900);
        Produit p2 = new Produit("adidas", "yeezy", "chaussure", new Date(), 1900);
        Produit p3 = new Produit("nike", "mercurial", "chaussure", new Date(), 1200);
        Produit p4 = new Produit("nike", "airforce", "chaussure", new Date(), 2000);
        Produit p5 = new Produit("audi", "a6", "voiture", new Date(), 500000);
//        ps.create(p1);
//        ps.create(p2);
//        ps.create(p3);
//        ps.create(p4);
//        ps.create(p5);
        for (Produit p : ps.findAll()) {
            System.out.println(p);
        }
        System.out.println(ps.findById(2));
      //  ps.delete(ps.findById(3));
     Produit pu = ps.findById(1);
         Calendar calendar = Calendar.getInstance();
 pu.setDate(new Date("2022/10/5"));
        ps.update(pu);
        
        for (Produit p : ps.findAll()) {
            if (p.getPrix() > 100) {
                System.out.println(p);
            }
        }
        System.out.println("entrez la date de debut de recherche");
        try {
            dateDebut = dateFormat.parse(s.nextLine());
        } catch (ParseException ex) {
            System.out.println("date invalide");
        }
        System.out.println("entrez la date de fin de recherche");
        try {
            dateFin = dateFormat.parse(s.nextLine());
        } catch (ParseException ex) {
            System.out.println("date invalide");
        }
        for (Produit p : ps.findAll()) {
            if (p.getDate().after(dateDebut) && p.getDate().before(dateFin)) {
                System.out.println(p);
            }
        }
    
    }
}
