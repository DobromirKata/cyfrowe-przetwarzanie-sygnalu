package controller;

import model.Model;
import view.View;

import javax.swing.*;

public class Controller {

    private View widok;
    private  Model model;

    public Controller(View widok, Model model) {
        this.widok = widok;
        this.model = model;
        utworzListeSygnalow();
        przypiszPrzyciski();
    }

    private void przypiszPrzyciski(){
        widok.getWyborSygnalu().addActionListener(e->wyborSygnalu());
    }

    private void wyborSygnalu(){
        model.setWybranySygnal(widok.getWyborSygnalu().getSelectedIndex());
        widok.aktualizujPrzyciski(model.getWybranySygnal());
    }

    private void utworzListeSygnalow(){
        widok.getWyborSygnalu().setModel(new DefaultComboBoxModel(model.SYGNALY));
    }



}
