/**
 * 
 */
package gpschallenge.componentes.utililidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author delpinor
 *
 */
public abstract class XML {
	public static Object obtenerObjeto(String url) {
		XStream xstream = new XStream(new DomDriver());
		File file = new File(url);
		Object obj = xstream.fromXML(file);
		return obj;
	}
	public static void guardarObjeto(Object obj, String url) {
		XStream xstream = new XStream(new DomDriver());
		PrintWriter pwObj = null;
		try {
			pwObj = new PrintWriter(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		xstream.toXML(obj,pwObj);
		pwObj.close();
	}
}
