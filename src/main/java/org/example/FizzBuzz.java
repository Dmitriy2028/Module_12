package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class FizzBuzz {
    private CopyOnWriteArrayList<String> concurArr = new CopyOnWriteArrayList<>();

    public String NumberPrinter(int number) {
        NumberProcessor np1 = new NumberProcessor((n) -> {
            if (n % 3 == 0 && n % 5 != 0) {
                concurArr.add("fizz");
            }
        });
        NumberProcessor np2 = new NumberProcessor((n) -> {
            if (n % 3 != 0 && n % 5 == 0) {
                concurArr.add("buzz");
            }
        });
        NumberProcessor np3 = new NumberProcessor((n) -> {
            if (n % 5 == 0 && n % 3 == 0) {
                concurArr.add("fizzbuzz");
            }
        });
        NumberProcessor np4 = new NumberProcessor((n) -> {
            if (n % 5 != 0 && n % 3 != 0) {
                concurArr.add(String.valueOf(n));
            }
        });

        List<NumberProcessor> nps = new ArrayList<>();
        nps.add(np1);
        nps.add(np2);
        nps.add(np3);
        nps.add(np4);

        for (NumberProcessor np : nps) {
            np.start();
        }

        for (int i = 0; i <= number; i++) {
            for (NumberProcessor np : nps) {
                np.process(i);
            }

            while (true) {
                int processedNumbersCount = 0;
                for (NumberProcessor np : nps) {
                    if (np.isNumberProcessed()) {
                        processedNumbersCount++;
                    }
                }
                if (processedNumbersCount == 4) {
                    break;
                }
            }
        }
        for (NumberProcessor np : nps) {
            //np.stop();
            np.interrupt();
        }
        return concurArr.toString();
    }
}
