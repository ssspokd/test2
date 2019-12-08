import com.company.domain.PointOfSale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class fileIOTest {

    private List<PointOfSale> pointOfSaleList;
    private File file;


    @BeforeEach
    public void init() {
        file = new File(getClass().getClassLoader().getResource("test/resources/offices.txt").getFile());
        pointOfSaleList = new ArrayList<>();
    }



    @Test
    public void readFromFile() {
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
             String line;
             while ((line = br.readLine()) != null) {
                pointOfSaleList.add(new PointOfSale(line));
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRandomPointOfSale(){
        readFromFile();
        Random random =  new Random();
        for(int i = 0; i < 100; i++) {
            System.out.println(pointOfSaleList.get(random.nextInt(pointOfSaleList.size())).getIdPointOfSale());
        }
    }
}