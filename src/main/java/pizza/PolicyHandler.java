package pizza;

import pizza.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    GradeRepository GradeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_CancelGrade(@Payload DeliveryCanceled deliveryCanceled){

        if(deliveryCanceled.isMe()){

            if("Canceled".equals(deliveryCanceled.getDeliveryStatus())){
                Grade grade = new Grade();
                grade.setOrderId(deliveryCanceled.getOrderId());
                grade.setGradeStatus(deliveryCanceled.getDeliveryStatus());

                GradeRepository.save(grade);
            }

            System.out.println("##### listener CancelGrade : " + deliveryCanceled.toJson());
        }
    }

}
