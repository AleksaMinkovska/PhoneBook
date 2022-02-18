package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginValidData() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginValidDataCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader((new FileReader(new File("src/test/resources/loginstring.csv"))));
        String line = reader.readLine();

        while(line != null){

            String [] split = line.split(";");
            list.add(new Object[]{split[0], split[1]});
            line = reader.readLine();
        }

        return list.iterator();

    }




    @DataProvider
    public Iterator<Object[]> contactValidData() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Tom", "Flow", "+7852342343", "abc@mail.ru", "London", "Kto eto?"});
        list.add(new Object[]{"Tom", "Flow", "+7852342343", "abc@mail.ru", "London", "Kto eto?"});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginValidDataModel() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> addContactValidDataModel() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder().name("Mike").lastName("Wix").phone("98761111").email("").address("mike@google.com").description("-")});
        list.add(new Object[]{Contact.builder().name("Sawa").lastName("Klick").phone("785123124").email("sss@fly.lv").address("").description("-")});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> addContactValidDataCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();     // Nicola,Large,+37163552307,nico@gmail.com,France,uncle                                                                                                                                    `e();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});

            line=reader.readLine();
        }

        return list.iterator();


    }


}

