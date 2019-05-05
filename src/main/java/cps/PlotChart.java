package cps;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public abstract class PlotChart {

    // WYKRES DLA SYGNALU CIAGLEGO
    public static JFreeChart plotChart(Sygnal signal) {

        XYSeries dataSet = new XYSeries(signal.getClass().getSimpleName());

        // wypelnianie tabeli do wykresu wartosciami przekazanej tabeli punktow sygnalu
        for (int i = 0; i < signal.pointsList[0].length; i++) {
            dataSet.add(signal.pointsList[0][i], signal.pointsList[1][i]);
        }

        // Tworzenie kolekcji serii zawierajacej serie dataSet
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection(dataSet);

        // tworzenie XYDataSet
        XYDataset xyDataset = xySeriesCollection;

        // tworzenie wykresu
        JFreeChart lineGraph;

        if (signal.type == Sygnal.signalType.CIAGLY) {
            lineGraph = ChartFactory.createXYLineChart(signal.getSignalName() + " - wykres", // Title
                    "t [s]", // X-Axis label
                    "A", // Y-Axis label
                    xyDataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot orientation
                    true, // show legend
                    true, // Show tooltips
                    false // url show
            );

        } else {
            lineGraph = ChartFactory.createScatterPlot(signal.getSignalName() + " - wykres sygnalu", // Title
                    "t [s]", // X-Axis label
                    "A", // Y-Axis label
                    xyDataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot orientation
                    true, // show legend
                    true, // Show tooltips
                    false // url show
            );
        }

        return lineGraph;
    }

    // HISTOGRAM DLA SYGNALU CIAGLEGO

    public static JFreeChart plotHistogram(Sygnal signal, int histogramCompartments) {

        HistogramDataset dataSet = new HistogramDataset();
        dataSet.setType(HistogramType.FREQUENCY);

        double[] tabela = new double[5];

        dataSet.addSeries("H1", signal.pointsList[1], histogramCompartments);

        // TWORZENIE WYKRESU

        JFreeChart histogram = ChartFactory.createHistogram(signal.getSignalName() + " - histogram", // Title
                "Wartosci sygnalu", // X-Axis label
                "Liczebnosc", // Y-Axis label
                dataSet, // Dataset
                PlotOrientation.VERTICAL, // Plot orientation
                true, // show legend
                true, // Show tooltips
                false // url show
        );

        return histogram;

    }

    // WYSWIETLENIE WYKRESU I HISTOGRAMU SYGNALU CIAGLEGO

    public static void plotChartAndHistogram(Sygnal signal, int histogramCompartments) {

        JFreeChart chart = plotChart(signal);

        JFreeChart histogram = plotHistogram(signal, histogramCompartments);

        JTextArea paramArea = new JTextArea(4, 2);
        paramArea.setText("Wartosc srednia sygnalu: \t\t\t" + signal.oblSredniaWartoscSygnalu()
                + "\nWartosc srednia(bezwzgledna) sygnalu: \t\t\t" + signal.oblWartoscSredniaBezwzglednaSygnalu()
                + "\nMoc srednia sygnalu: \t\t\t" + signal.oblMocSygnalu() + "\nWariancja sygnalu: \t\t\t"
                + signal.oblWariancjaSygnalu() + "\nWartosc skuteczna sygnalu: \t\t\t"
                + signal.oblWartoscSkutecznaSygnalu());

        JFrame jframe = new JFrame(signal.getClass().getSimpleName());
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.getContentPane().setLayout(new GridLayout(3, 1));
        jframe.setSize(800, 720);
        ChartPanel chartPanel01 = new ChartPanel(chart);
        ChartPanel chartPanel02 = new ChartPanel(histogram);

        jframe.getContentPane().add(chartPanel01);
        jframe.getContentPane().add(chartPanel02);
        jframe.add(paramArea);
        jframe.setVisible(true);

    }

    // wykres sygnalu oryginalnego i zrekonstruowanego Zero-Order Hold (schody)
    public static JFreeChart plotOrgAndReconstructZOH(Sygnal signal) {

        XYSeries dataSet = new XYSeries("Sygnal oryginalny");
        XYSeries dataSet2 = new XYSeries("Rekonstrukcja sygnalu", false, true);

        // wypelnianie tabeli do wykresu wartosciami przekazanej tabeli punktow sygnalu
        for (int i = 0; i < signal.pointsList[0].length; i++) {
            dataSet.add(signal.pointsList[0][i], signal.pointsList[1][i]);
        }
        // for (int i = 0; i < signal.pointsList2[0].length - 1; i++) {
        // dataSet2.add(signal.pointsList2[0][i], signal.pointsList2[1][i]);
        // dataSet2.add(signal.pointsList2[0][i + 1], signal.pointsList2[1][i]);
        // }

        // Tworzenie kolekcji serii zawierajacej serie dataSet
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection(dataSet);
        xySeriesCollection.addSeries(dataSet2);

        // tworzenie XYDataSet
        XYDataset xyDataset = xySeriesCollection;

        // tworzenie wykresu
        JFreeChart lineGraph;

        if (signal.type == Sygnal.signalType.CIAGLY) {
            lineGraph = ChartFactory.createXYLineChart(signal.getSignalName() + " - wykres", // Title
                    "t [s]", // X-Axis label
                    "A", // Y-Axis label
                    xyDataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot orientation
                    true, // show legend
                    true, // Show tooltips
                    false // url show
            );

        } else {
            lineGraph = ChartFactory.createScatterPlot(signal.getSignalName() + " - wykres sygnalu", // Title
                    "t [s]", // X-Axis label
                    "A", // Y-Axis label
                    xyDataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot orientation
                    true, // show legend
                    true, // Show tooltips
                    false // url show
            );
        }

        return lineGraph;
    }

    // ZADANIE 2
    // -----------------------------------------------------------------------

    // wykres dla sygnalu dyskretnego
    // public static JFreeChart plot1Chart(SygnalDyskretny signal) {
    //
    // XYSeries dataSet = new XYSeries(signal.getClass().getSimpleName());
    //
    // //wypelnianie tabeli do wykresu wartosciami przekazanej tabeli punktow
    // sygnalu
    // for (int i = 0; i < signal.pointsList[0].length; i++) {
    // dataSet.add(signal.pointsList[0][i], signal.pointsList[1][i]);
    // }
    //
    // // Tworzenie kolekcji serii zawierajacej serie dataSet
    // XYSeriesCollection xySeriesCollection = new XYSeriesCollection(dataSet);
    //
    // // tworzenie XYDataSet
    // XYDataset xyDataset = xySeriesCollection;
    //
    // // tworzenie wykresu
    // JFreeChart lineGraph = ChartFactory.createScatterPlot(signal.getSignalName()
    // + " - wykres sygnalu", // Title
    // "t [s]", // X-Axis label
    // "A", // Y-Axis label
    // xyDataset, // Dataset
    // PlotOrientation.VERTICAL, //Plot orientation
    // true, //show legend
    // true, // Show tooltips
    // false //url show
    // );
    // return lineGraph;
    // }
    // histogram dla sygnalu dyskretnego
    // public static JFreeChart plotHistogram(SygnalDyskretny signal) {
    //
    // HistogramDataset dataSet = new HistogramDataset();
    // dataSet.setType(HistogramType.FREQUENCY);
    //
    // double[] tabela = new double[5];
    //
    // dataSet.addSeries("H1", signal.pointsList[1], 2);
    //
    // // tworzenie wykresu
    // JFreeChart histogram = ChartFactory.createHistogram(signal.getSignalName() +
    // " - histogram", // Title
    // "Wartosci sygnalu", // X-Axis label
    // "Liczebnosc", // Y-Axis label
    // dataSet, // Dataset
    // PlotOrientation.VERTICAL, //Plot orientation
    // true, //show legend
    // true, // Show tooltips
    // false //url show
    // );
    //
    // return histogram;
    // }
    // wyswietlanie wykresu i histogramu dla sygnalu dyskretnego
    // public static void plotChartAndHistogram(SygnalDyskretny signal) {
    // JFreeChart chart = plot1Chart(signal);
    // JFreeChart histogram = plotHistogram(signal);
    //
    // JTextArea paramArea = new JTextArea(4, 2);
    // paramArea.setText("Wartosc srednia sygnalu: \t\t\t" +
    // signal.oblSredniaWartoscSygnalu()
    // + "\nWartosc srednia(bezwzgledna) sygnalu: \t\t" +
    // signal.oblWartoscSredniaBezwzglednaSygnalu()
    // + "\nMoc srednia sygnalu: \t\t\t" + signal.oblMocSygnalu()
    // + "\nWariancja sygnalu: \t\t\t" + signal.oblWariancjaSygnalu()
    // + "\nWartosc skuteczna sygnalu: \t\t\t" +
    // signal.oblWartoscSkutecznaSygnalu());
    //
    // JFrame jframe = new JFrame(signal.getClass().getSimpleName());
    // jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    // jframe.getContentPane().setLayout(new GridLayout(3, 1, 10, 10));
    // jframe.setSize(800, 720);
    // ChartPanel chartPanel01 = new ChartPanel(chart);
    // ChartPanel chartPanel02 = new ChartPanel(histogram);
    //
    // jframe.getContentPane().add(chartPanel01);
    // jframe.getContentPane().add(chartPanel02);
    // jframe.getContentPane().add(paramArea);
    // jframe.setVisible(true);
    // }
}
