import com.company.domain.Payment;
import com.company.domain.PointOfSale;
import com.company.dto.PaymentsOfPointSaleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class statsTest {

    private List<PaymentsOfPointSaleDTO> paymentsOfPointSaleDTO;
    private  List<PaymentStats> paymentStatsList;
    private  File file;


    @BeforeEach
    public void init(){
        paymentStatsList =  new ArrayList<>();
        paymentsOfPointSaleDTO = new ArrayList<>();
        file = new File("e:/file1.txt");
    }

    @Test
    public void ReadDataFromFile() throws IOException {
        Path path =  file.toPath();
        try (Stream<String> lineStream = Files.lines(path)) {
            lineStream.forEach(this::initPaymentsOfPointSaleDTO);

            Map<Date,Double>  maps = paymentsOfPointSaleDTO.stream()
                    .collect(Collectors.groupingBy(paymentsOfPointSaleDTO -> paymentsOfPointSaleDTO.getPayment().getDateOperation(),
                            Collectors.summingDouble(value -> value.getPayment().getSumOperation())));

            Map<String,Double>  maps2 = paymentsOfPointSaleDTO.stream()
                    .collect(Collectors.groupingBy(paymentsOfPointSaleDTO -> paymentsOfPointSaleDTO.getPointOfSale().getIdPointOfSale(),
                            Collectors.summingDouble(value -> value.getPayment().getSumOperation())));
        }
    }

    private void initPaymentsOfStat(String s) {
        String[] str  = s.split(" ");
        try {
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(str[0]);
            PaymentStats paymentStats = new PaymentStats(date,Float.valueOf(str[4]),str[3],str[2]);
            paymentStatsList.add(paymentStats);
        } catch (ParseException e) {
            e.printStackTrace();
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

}
