//심규원

package JavaPractice.EventTask1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PropertyHtml {
    public static void main(String[] args) {
        String str = "<head><meta charset=\"UTF-8\"/><style>table{border-collapse: collapse; width: 100%}" +
                "th,td {border: solid 1px #000;}</style></head><body>";
        str += "<h1>자바 환경정보</h1><table><th>키</th><th></th>";

        for(Object k: System.getProperties().keySet()){
            String key = k.toString();
            String value = System.getProperty(key);
            str += "<tr><td>"+key+"</td><td>"+value+"</td></tr>";
        }
        str += "</table></body>";

        try{
            File file = new File("index.html");
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.write(str);
            br.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
