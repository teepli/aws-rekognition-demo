package fi.academy.rekognitiondemo;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;

@Service
public class AwsRekognitionService {

    String bucket = "S3-BUCKET";
    String photo = "KUVA.png";


    private AmazonRekognition client;

    public AwsRekognitionService(AmazonRekognition client) {
        this.client = client;
    }

    public DetectModerationLabelsResult detectModerationLabels(MultipartFile imageToCheck) throws IOException {
        DetectModerationLabelsRequest request = new DetectModerationLabelsRequest()
                .withImage(new Image().withBytes(ByteBuffer.wrap(imageToCheck.getBytes())));

        return client.detectModerationLabels(request);
    }

    public DetectLabelsResult detectLabelsResult(MultipartFile imageToCheck) throws IOException {
        DetectLabelsRequest request = new DetectLabelsRequest()
                .withImage(new Image().withBytes(ByteBuffer.wrap(imageToCheck.getBytes())));

        return client.detectLabels(request);
    }

    public DetectFacesResult detectFacesResult(MultipartFile imageToCheck) throws IOException {
        DetectFacesRequest request = new DetectFacesRequest()
                .withImage(new Image().withBytes(ByteBuffer.wrap(imageToCheck.getBytes()))).withAttributes(Attribute.ALL);

        return client.detectFaces(request);
    }

    public DetectLabelsResult test() {
        DetectLabelsRequest request = new DetectLabelsRequest()
                .withImage(new Image()
                        .withS3Object(new S3Object()
                                .withName(photo).withBucket(bucket)))
                .withMaxLabels(10)
                .withMinConfidence(75F);

        return client.detectLabels(request);
    }

}

