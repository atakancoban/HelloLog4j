package bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = -4823295172962937652L;

	static Logger logger;
	private String message = "www.atakancoban.com";

	@PostConstruct
	public void init() {
		// Log4j kütüphanemizi etkinleştir
		loadLog4jConfig();
		System.out.println("init()");
	}

	public void onClick() {
		System.out.println("bu mesaj > system.out.print");
		logger.trace("Bu bir TRACE mesajı ");
		logger.debug("Bu bir DEBUG mesajı ");
		logger.info("Bu bir INFO mesajı ");
		logger.warn("Bu bir WARN mesajı ");
		logger.error("Bu bir ERROR mesajı ");
		logger.fatal("Bu bir FATAL mesajı ");
		
		exceptionTest();

	}

	private static void loadLog4jConfig() {
		DOMConfigurator.configureAndWatch("src/main/webapp/WEB-INF/log4jconfig.xml");
		logger= Logger.getLogger(HelloBean.class);
	}

	public void exceptionTest() {
		try {
			ArrayList<String> testArray = new ArrayList<>();
			testArray.get(10);//Hata oluşsun
		
		} catch (Exception e) {
			logger.error("exceptionTest() mesajı oluştu. "+e.getMessage(),e);
		}
	}

	// Getter Setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
