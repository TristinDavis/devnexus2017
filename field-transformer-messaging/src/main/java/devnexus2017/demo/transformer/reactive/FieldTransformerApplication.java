package devnexus2017.demo.transformer.reactive;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication
@EnableBinding(Processor.class)
public class FieldTransformerApplication {

	@StreamListener(Processor.INPUT)
	@Output(Processor.OUTPUT)
	public Map<String, Object> transformFields(Map<String, Object> doc) {
		Map<String, Object> map = new HashMap<>();
		map.put("sensorId", doc.get("sensor_id"));
		map.put("temperature", doc.get("temp_val"));
		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(FieldTransformerApplication.class, args);
	}
}
