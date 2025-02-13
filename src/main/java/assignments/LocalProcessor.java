package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
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
    private LinkedList<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
        this.stringArrayList = new LinkedList<>();
        ;
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorGenerator(LinkedList<String> stringList) {
        var processorName = new StringBuilder();
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName.append(stringList.get(i)).append(" ");
        }
        return processorName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        var processorVersion = new StringBuilder();
        while (informationScanner.hasNext()) {
            processorVersion.append(informationScanner.nextLine());
        }
        this.processorVersion = processorVersion.toString();
    }
}
