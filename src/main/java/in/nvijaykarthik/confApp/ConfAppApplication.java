package in.nvijaykarthik.confApp;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.util.StringUtils;

@SpringBootApplication
@EnableConfigServer
public class ConfAppApplication {

	
	private static final Logger log = LoggerFactory.getLogger(ConfAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConfAppApplication.class, args);
	}
	
	@Autowired
	private ConfProperties prop;
	
	@PostConstruct
	public void checkConfig() {
		String lsettl = ".000";
		log.debug("LSETTL value from FM:{}", lsettl);
		if (StringUtils.isEmpty(lsettl) || (!StringUtils.isEmpty(lsettl) && isNumber(lsettl)
				&& BigDecimal.ZERO.equals(new BigDecimal(lsettl.trim())))) {
			log.info("Validated");
		}
		log.info("Validated");
	}

	public static boolean isNumber(String string) {

		Pattern  pattern = Pattern.compile("\\d+");
		return pattern.matcher(string).matches();
	}
}
