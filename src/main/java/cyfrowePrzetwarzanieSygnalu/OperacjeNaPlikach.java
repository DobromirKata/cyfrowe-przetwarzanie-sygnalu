package cyfrowePrzetwarzanieSygnalu;


import java.io.DataInputStream;             // wczytywanie plików binarnych
import java.io.DataOutputStream;            // zapis binarny
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;            // zapis danych bajt po bajcie
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class OperacjeNaPlikach {

    public static void saveToFile(Sygnal signal, File fileName) {

        try {
            DataOutputStream saveSignal = new DataOutputStream(new FileOutputStream(fileName));

            saveSignal.writeUTF(signal.type.name());
            saveSignal.writeUTF(signal.signalName);
            saveSignal.writeDouble(signal.Amplitude);
            saveSignal.writeDouble(signal.tBegin);
            saveSignal.writeDouble(signal.signalTime);
            saveSignal.writeDouble(signal.interval);            // okres
            saveSignal.writeDouble(signal.kw);                  // wspolczynnik wypelnienia
            saveSignal.writeDouble(signal.ts);                  // czas skoku
            saveSignal.writeInt(signal.jumpSample);             // probka skoku
            saveSignal.writeInt(signal.numberOfSamples);        //
            saveSignal.writeInt(signal.samplingFrequency);      // czestotliwosc probkowania
            saveSignal.writeDouble(signal.probability);         //
            saveSignal.writeDouble(signal.timeOffset);          //

            saveSignal.writeInt(signal.pointsList[0].length);   // zmienna do odtworzenia tablicy

            for (int i = 0; i < signal.pointsList[0].length; i++) {
                saveSignal.writeDouble(signal.pointsList[0][i]);
                saveSignal.writeDouble(signal.pointsList[1][i]);
            }

            saveSignal.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku. [File not found]");
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException.");
            Logger.getLogger(OperacjeNaPlikach.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Sygnal importFromFile(File fileToOpen) {
        Sygnal openSignal = new Sygnal();

        try {
            DataInputStream readFile = new DataInputStream(new FileInputStream(fileToOpen));

            openSignal.type = Sygnal.signalType.valueOf(readFile.readUTF());
            openSignal.signalName = readFile.readUTF();
            openSignal.Amplitude = readFile.readDouble();
            openSignal.tBegin = readFile.readDouble();
            openSignal.signalTime = readFile.readDouble();
            openSignal.interval = readFile.readDouble();
            openSignal.kw = readFile.readDouble();
            openSignal.ts = readFile.readDouble();
            openSignal.jumpSample = readFile.readInt();
            openSignal.numberOfSamples = readFile.readInt();
            openSignal.samplingFrequency = readFile.readInt();
            openSignal.probability = readFile.readDouble();
            openSignal.timeOffset = readFile.readDouble();

            int tableSize = readFile.readInt();
            openSignal.pointsList = new double[2][tableSize];

            for (int i = 0; i < tableSize; i++) {
                openSignal.pointsList[0][i] = readFile.readDouble();
                openSignal.pointsList[1][i] = readFile.readDouble();
            }

            readFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku. [Eror-404] File not found.");
        } catch (IOException ex) {
            System.out.println("IOException.");
        }

        return openSignal;
    }
}
