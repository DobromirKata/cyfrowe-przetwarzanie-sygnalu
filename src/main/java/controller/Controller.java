package controller;

import cps.OperacjeNaPlikach;
import cps.PlotChart;
import cps.Sygnal;
import cps.SygnalOperacje;
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

        view.getDodajButton().addActionListener(e -> wykonajOperacje(0));
        view.getOdejmijButton().addActionListener(e -> wykonajOperacje(1));
        view.getMnozenieButton().addActionListener(e -> wykonajOperacje(2));
        view.getDzielenieButton().addActionListener(e -> wykonajOperacje(3));

    }

    private void aktualizujPrzyciski() {
        view.getWyświetlButton().setEnabled(true);
        view.getZapiszButton().setEnabled(true);

        int[] indicies = view.getList1().getSelectedIndices();
        if (indicies.length >= 2) {
            view.getDodajButton().setEnabled(true);
            view.getOdejmijButton().setEnabled(true);
            view.getMnozenieButton().setEnabled(true);
            view.getDzielenieButton().setEnabled(true);
        } else {
            view.getDodajButton().setEnabled(false);
            view.getOdejmijButton().setEnabled(false);
            view.getMnozenieButton().setEnabled(false);
            view.getDzielenieButton().setEnabled(false);
        }
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

    private void wykonajOperacje(int typ) {
        Sygnal wynik;

        int[] indices = view.getList1().getSelectedIndices();
        Sygnal sygnal1 = model.getSygnaly().get(indices[0]);
        Sygnal sygnal2 = model.getSygnaly().get(indices[1]);

        switch (typ) {
            case 1:
                wynik = SygnalOperacje.substractSignals(sygnal1, sygnal2, indices);
                break;
            case 2:
                wynik = SygnalOperacje.multiplySignals(sygnal1, sygnal2, indices);
                break;
            case 3:
                wynik = SygnalOperacje.divisionSignals(sygnal1, sygnal2, indices);
                break;
            default:
                wynik = SygnalOperacje.addingSignals(sygnal1, sygnal2, indices);
                break;
        }

        model.addSygnal(wynik);
        view.addToList(wynik.StringToJlist());
    }

}
