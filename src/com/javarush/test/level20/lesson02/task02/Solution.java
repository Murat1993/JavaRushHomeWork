package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Viktor");
            user.setLastName("Vasiliev");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);

            User user2 = new User();
            user2.setFirstName("Boris");
            user2.setLastName("Maiseev");
            user2.setBirthDate(new Date());
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Artem");
            user3.setLastName("Greenberg");
            user3.setBirthDate(new Date());
            user3.setMale(false);
            user3.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user);
            javaRush.users.add(user2);
            javaRush.users.add(user3);



            javaRush.save(outputStream);
            outputStream.flush();



            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            for (User user1 : loadedObject.users)
            {
                System.out.println(user1.getFirstName() + " " + user1.getLastName());
                System.out.println(user1.getBirthDate().toString());
                System.out.println(user1.isMale());
                System.out.println(user1.getCountry().getDisplayedName());
            }



            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            String pattern = "dd/MM/yyyy";
            SimpleDateFormat format = new SimpleDateFormat(pattern);

            for (User user : users)
            {
                writer.write(user.getFirstName() + " " + user.getLastName() + '\n');
                writer.write(format.format(user.getBirthDate()) + '\n');
                writer.write(user.isMale() + "" + '\n');
                writer.write(user.getCountry().getDisplayedName() + '\n');
                writer.flush();
            }
            writer.write('\n');
            writer.flush();

        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            List<String> list = new ArrayList<>();

            String stringInFile;
            while (!(stringInFile = reader.readLine()).equals(""))
            {
                list.add(stringInFile);
            }


            String[] fullName = new String[0];
            Date date = new Date();
            boolean male = false;
            User.Country country;

            int i = 0;
            while (!list.isEmpty()) {
                if (i == 0)
                {
                    fullName = list.get(i).split(" ");
                    i++;
                }

                if (i == 1)
                {
                    String pattern = "dd/MM/yyyy";
                    SimpleDateFormat format = new SimpleDateFormat(pattern);
                    date = format.parse(list.get(i));
                    i++;
                }

                if (i == 2)
                {
                    male = list.get(i).equals("true");
                    i++;
                }

                if (i == 3)
                {
                    String country1 = list.get(i);
                    switch (country1)
                    {
                        case "Russia":
                            country = User.Country.RUSSIA;
                            break;
                        case "Ukraine":
                            country = User.Country.UKRAINE;
                            break;
                        default:
                            country = User.Country.OTHER;
                            break;
                    }
                    User user = new User();
                    user.setFirstName(fullName[0]);
                    user.setLastName(fullName[1]);
                    user.setBirthDate(date);
                    user.setMale(male);
                    user.setCountry(country);


                    users.add(user);
                    i = 0;
                    list.remove(0);
                    list.remove(0);
                    list.remove(0);
                    list.remove(0);
                }
            }

        }
    }
}
