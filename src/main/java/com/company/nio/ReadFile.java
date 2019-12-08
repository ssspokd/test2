package com.company.nio;

import com.company.domain.Payment;
import com.company.domain.PointOfSale;
import com.company.dto.PaymentsOfPointSaleDTO;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ReadFile {
    private final static Logger LOGGER = Logger.getLogger(ReadFile.class);

    private List<PaymentsOfPointSaleDTO> paymentsOfPointSaleDTO = new ArrayList<>();
    private File file;


    public ReadFile(File file){
        this.file = file;
        readFileStream();
    }

    private  void  readFileStream(){
        Path path =  file.toPath();
        Stream<String> lineStream = Stream.generate(() -> "");
        try
        {
            lineStream = Files.lines(path);
            lineStream.forEach(this::initPaymentsOfPointSaleDTO);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private void initPaymentsOfPointSaleDTO(String s) {
        String[] str  = s.split(" ");
        try {
            Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(str[0]);
            Payment payment =  new Payment(
                    Float.valueOf(str[4]), str[3], date1);
            PointOfSale pointOfSale =  new PointOfSale(str[2]);
            paymentsOfPointSaleDTO.add(new PaymentsOfPointSaleDTO(payment,pointOfSale));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<PaymentsOfPointSaleDTO> getPaymentsOfPointSaleDTO() {
        return paymentsOfPointSaleDTO;
    }
}
