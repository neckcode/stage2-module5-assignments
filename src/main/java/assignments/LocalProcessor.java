package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList = new ArrayList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = stringList;
        if (stringArrayList.size() > period) {
            throw new IllegalArgumentException("Wrong period");
        }
        for (int i = 0; i < period; i++) {
            var nextLine = stringArrayList.get(i);
            if (nextLine == null) {
                throw new IllegalStateException();
            }
            System.out.println(nextLine.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorGenerator(List<String> stringList) {
        StringBuilder processorName = new StringBuilder();
        for (String nextLine : stringList) {
            if (nextLine == null) {
                throw new IllegalStateException();
            }
            processorName.append(nextLine).append(" ");
        }
        this.processorName = processorName.toString();
        return this.processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder processorVersion = new StringBuilder();
        try {
            while (informationScanner.hasNext()) {
                var nextLine = informationScanner.nextLine();
                if (nextLine == null) {
                    continue;
                }
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (InputMismatchException e) {
            System.out.println("wrong data");
        }
        this.processorVersion = processorVersion.toString();
    }
}
