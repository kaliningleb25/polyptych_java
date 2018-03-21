package Ex3;

/*
    Создать приложение, позволяющее читать значение по ключу из *.properties-файлов.
	В качестве входных параметров (в консоли) задаются: имя файла и ключ, для которого нужно получить значение.
	Обработать все возможные исключительные ситуации.
 */

// fileName = src/Ex3/resources/config.properties
// key = keyTest

import java.io.*;
import java.util.Properties;

public class ReadValueFromKeyInProperty {
    private BufferedReader in;
    private String fileName;
    private String key;
    private Properties properties;

    public ReadValueFromKeyInProperty() throws IOException {
        properties = new Properties();
        in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter filename:");
        fileName = in.readLine();
        System.out.println("Enter key:");
        key = in.readLine();
    }

    private String getValueByKey() {
        try (FileInputStream fis = new FileInputStream(fileName)){
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Key = " + key + " : Value = " + properties.getProperty(key);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new ReadValueFromKeyInProperty().getValueByKey());
    }


}
