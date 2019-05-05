package controller;

import cps.OperacjeNaPlikach;
import cps.PlotChart;
import cps.Sygnal;
import model.Model;
import view.View;

import javax.swing.*;
import java.io.File;

public class Controller {

    private View view;
    private  Model model;
    private JFileChooser wyborPliku;

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

        view.getList1().addListSelectionListener(e -> aktualizujPrzyciski());

//        Przyciski
        view.getGenerujButton().addActionListener(e -> generujSygnal());
        view.getWyświetlButton().addActionListener(e -> wyswietlSygnal());
        view.getZapiszButton().addActionListener(e -> zapisz());
        view.getWczytajButton().addActionListener(e -> wczytaj());

    }

    private void aktualizujPrzyciski() {
        view.getWyświetlButton().setEnabled(true);
        view.getZapiszButton().setEnabled(true);
    }

    private void generujSygnal() {
        Sygnal sygnal = model.generujSygnal();
        model.addSygnal(sygnal);
        view.addToList(sygnal.StringToJlist());
        PlotChart.plotChartAndHistogram(sygnal, model.getHistogram());
//        wyswietlWyniki(sygnal);
    }

    private void wyswietlSygnal() {
        int index = view.getList1().getSelectedIndex();
        Sygnal sygnal = model.getSygnaly().get(index);
        PlotChart.plotChartAndHistogram(sygnal, model.getHistogram());
    }

    private void wyborSygnalu(){
        model.setWybranySygnal(view.getWyborSygnalu().getSelectedIndex());
        view.aktualizujPrzyciski(model.getWybranySygnal());
        model.aktualizujParametry(model.getWybranySygnal());
    }

    private void utworzListeSygnalow(){
        view.getWyborSygnalu().setModel(new DefaultComboBoxModel(model.SYGNALY));
    }

    private void wczytaj() {
        wyborPliku = new JFileChooser();
        int ok = wyborPliku.showOpenDialog(view.getMainPanel());
        if (ok == JFileChooser.APPROVE_OPTION) {
            String wybranaSciezka = wyborPliku.getSelectedFile().getPath();
            Sygnal sygnal = OperacjeNaPlikach.importFromFile(new File(wybranaSciezka));
            model.addSygnal(sygnal);
            view.addToList(sygnal.StringToJlist());
        }
    }

    private void zapisz() {
        wyborPliku = new JFileChooser();
        int ok = wyborPliku.showSaveDialog(view.getMainPanel());
        if (ok == JFileChooser.APPROVE_OPTION) {
            int index = view.getList1().getSelectedIndex();
            Sygnal sygnal = model.getSygnaly().get(index);
            String wybranaSciezka = wyborPliku.getSelectedFile().getPath();
            OperacjeNaPlikach.saveToFile(sygnal, new File(wybranaSciezka));
        }
    }

}
