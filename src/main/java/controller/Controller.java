package controller;

import cps.PlotChart;
import cps.Sygnal;
import model.Model;
import view.View;

import javax.swing.*;

public class Controller {

    private View view;
    private  Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        utworzListeSygnalow();
        przypiszPrzyciski();
    }

    private void przypiszPrzyciski(){
        view.getWyborSygnalu().addActionListener(e->wyborSygnalu());
        view.getPoleAmplituda().addChangeListener(e -> model.setAmplituda((double) view.getPoleAmplituda().getValue()));
        view.getPoleCzasPocz().addChangeListener(e -> model.setCzaspocz((double) view.getPoleCzasPocz().getValue()));
        view.getPoleCzasSyg().addChangeListener(e -> model.setCzassyg((double) view.getPoleCzasSyg().getValue()));
        view.getPoleOkres().addChangeListener(e -> model.setOkres((double) view.getPoleOkres().getValue()));
        view.getPoleWspWyp().addChangeListener(e -> model.setWspWyp((double) view.getPoleWspWyp().getValue()));
        view.getPoleCzasSkoku().addChangeListener(e -> model.setCzasSkoku((double) view.getPoleCzasSkoku().getValue()));
        view.getPoleProbkaSkoku().addChangeListener(e -> model.setProbkaSkoku((int) view.getPoleProbkaSkoku().getValue()));
        view.getPoleIloscPr().addChangeListener(e -> model.setIloscProbek((int) view.getPoleIloscPr().getValue()));
        view.getPoleCzestotliwosc().addChangeListener(e -> model.setCzestotliwosc((int) view.getPoleCzestotliwosc().getValue()));
        view.getPolePrawdopodobienstwo().addChangeListener(e -> model.setPrawdopodobienstwo((int) view.getPolePrawdopodobienstwo().getValue()));
        view.getHistogramSlider().addChangeListener(e -> model.setHistogram(view.getHistogramSlider().getValue()));

//        Przyciski
        view.getGenerujButton().addActionListener(e -> generujSygnal());
    }

    private void generujSygnal() {
        Sygnal sygnal = model.generujSygnal();
        model.addSygnal(sygnal);
        view.addToList(sygnal.StringToJlist());
        PlotChart.plotChartAndHistogram(sygnal, model.getHistogram());
//        wyswietlWyniki(sygnal);
    }

    private void wyborSygnalu(){
        model.setWybranySygnal(view.getWyborSygnalu().getSelectedIndex());
        view.aktualizujPrzyciski(model.getWybranySygnal());
        model.aktualizujParametry(model.getWybranySygnal());
    }

    private void utworzListeSygnalow(){
        view.getWyborSygnalu().setModel(new DefaultComboBoxModel(model.SYGNALY));
    }



}
