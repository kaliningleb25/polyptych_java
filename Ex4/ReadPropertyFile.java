package Ex4;

/*
Создать приложение, позволяющее читать *.properties-файлы. Физическое чтение файла должно происходить только один раз.
	Результаты чтения храните в коллекции типа Map. После прочтения файла, пользователь может работать с ним через консоль,
	запрашивая значения по ключам, пока не нажата клавиша ESC.
 */

import java.io.*;
import java.util.*;

/*
propertiesMap = {password=admin, login=admin, keyTest1=valueTest1, keyTest2=valueTest2}
 */

public class ReadPropertyFile {
    static void getValueByKey() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> propertiesMap = getPropertiesMap();

        while (true) {
            String key = in.readLine();
            if (key.equals("q")) {
                System.exit(0);
            }
            if (propertiesMap.containsKey(key)) {
                System.out.println("Key = " + key + " : Value = " + propertiesMap.get(key));
            }
            else {
                System.out.println("propertiesMap does not have key '" + key + "'");
            }
        }
    }

    static Map<String, String> getPropertiesMap() {
        List<File[]> propertiesFileList = getFileProperties();
        Properties properties = new Properties();
        Map<String, String> propertiesMap = new HashMap<>();

        for (int i = 0; i < propertiesFileList.get(0).length; i++) {
            try (FileInputStream fis = new FileInputStream(propertiesFileList.get(0)[i])) {
                properties.load(fis);
                for (String propertyKey : properties.stringPropertyNames()) {
                    propertiesMap.put(propertyKey, properties.getProperty(propertyKey));
                }
                properties.clear();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(propertiesMap);

        return propertiesMap;
    }

    static List<File[]> getFileProperties() {
        File file = new File("src/Ex4/resources");
        List<File[]> propertiesFileList = new ArrayList<>();

        propertiesFileList.add(file.listFiles((dir, name) -> name.endsWith("properties")));

        return propertiesFileList;
    }

    public static void main(String[] args) throws IOException {
        getValueByKey();
    }
}
