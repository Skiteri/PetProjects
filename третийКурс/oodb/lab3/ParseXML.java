import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ParseXML {
    public static <T> T readXML(File file, Class<T> tClass) throws IOException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (T) un.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> void rewriteXML(T t, File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(t, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static <T> void writeXML(T[] item) {
        Arrays.sort(item);
    }


    public static User findObject(User[] item, int id) {
        for (User t: item){
            if (t.getId() == id) return t;
        }
        return null;
    }
}
