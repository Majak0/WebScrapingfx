package View;

import com.webscraping.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class TestCategoriesCollector {

    Scanner input;
    {
        try {
            input = new Scanner(new File("src/main/resources/com/webscraping/input_txt/cat_Pizzato.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectingCategoriesOfPizzato(){
        HashSet<Category> categories = new HashSet<>();
        String[] categoriesSplitter;
        int maxSize = 0;
        while (input.hasNext()){
            categoriesSplitter = input.nextLine().split("https://www.pizzato.com/fr/catalogue/");
            categories.add(new Category(categoriesSplitter[1]));
        }
        for (Category cat :
                categories) {
            int size = (cat.getUrl().split("/")).length;
            if (size>maxSize)maxSize=size;
            cat.print();
        }
        Assertions.assertEquals(3,maxSize);
    }
}
