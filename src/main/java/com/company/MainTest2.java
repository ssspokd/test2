package com.company;


import com.company.nio.ReadFile;
import com.company.nio.WriteToFile;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainTest2 {


     private final static Logger LOGGER = Logger.getLogger(MainTest2.class);



    public static void main(String[] args) throws IOException {
        if(args.length  != 3){
            LOGGER.error("missing count arguments, only 3\n " +
                    "1 argument: input file with data \n " +
                    "2 argument: outputfile stats date \n" +
                    "3 argument: outputfile stats office" );
            return;
        }
	// write your code here
        MainTest2 mainTest2 = new MainTest2();
        mainTest2.runTask2(args[1],args[2],args[0]);
    }

    private void runTask2(String nameFileInput,String nameFileOutputStatsOffice, String nameFileOutputStatsDate ) throws IOException {
        ReadFile readFile = new ReadFile(new File(nameFileInput));

        WriteToFile writeToFile =  new WriteToFile(new File(nameFileOutputStatsOffice));

        writeToFile.writeStreamToFile(readFile.getPaymentsOfPointSaleDTO().stream()
                .collect(Collectors.groupingBy(paymentsOfPointSaleDTO -> paymentsOfPointSaleDTO.getPayment().getDateOperation(),
                        Collectors.summingDouble(value -> value.getPayment().getSumOperation())))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new)));


        writeToFile= new WriteToFile(new File(nameFileOutputStatsDate));
        writeToFile.writeStreamToFile(readFile.getPaymentsOfPointSaleDTO().stream()
                .collect(Collectors.groupingBy(paymentsOfPointSaleDTO -> paymentsOfPointSaleDTO.getPointOfSale().getIdPointOfSale(),
                        Collectors.summingDouble(value -> value.getPayment().getSumOperation())))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new)));
    }


}
