package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
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
    private List<String> stringArrayList;

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
        this.stringArrayList = new ArrayList<>();
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new ArrayList<>(stringList);
        if (stringArrayList.size() < period) {
            throw new IllegalArgumentException("Wrong period");
        }
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorGenerator(List<String> stringList) {
        var processorName = new StringBuilder();
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName.append(stringList.get(i)).append(" ");
        }
        this.processorName = processorName.toString();
        return this.processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        var processorVersion = new StringBuilder();
        while (informationScanner.hasNext()) {
            var nextLine = informationScanner.nextLine();
            if (nextLine == null) {
                throw new IllegalArgumentException("Wrong type");
            }
            processorVersion.append(informationScanner.nextLine());
        }
        this.processorVersion = processorVersion.toString();
    }
}
