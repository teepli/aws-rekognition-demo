package fi.academy.rekognitiondemo.controller;

import com.amazonaws.services.rekognition.model.DetectFacesResult;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import fi.academy.rekognitiondemo.AwsRekognitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class RekognitionController {


    private AwsRekognitionService awsRekognitionService;

    public RekognitionController(AwsRekognitionService awsRekognitionService) {
        this.awsRekognitionService = awsRekognitionService;
    }
    @GetMapping("/labels")
    public ResponseEntity<DetectLabelsResult> test() {
        return ResponseEntity.ok(awsRekognitionService.test());
    }

    @PostMapping("/images/moderation-labels")
    public Object detectModerationLabels(@RequestParam MultipartFile image) throws IOException {
        return ResponseEntity.ok(awsRekognitionService.detectModerationLabels(image));
    }

    @PostMapping("/images/labels")
    public ResponseEntity<DetectLabelsResult> detectLabels(@RequestParam MultipartFile image) throws IOException {
        return ResponseEntity.ok(awsRekognitionService.detectLabelsResult(image));
    }

    @PostMapping("/images/faces")
    public ResponseEntity<DetectFacesResult> detectFaces(@RequestParam MultipartFile image) throws IOException {
        return ResponseEntity.ok(awsRekognitionService.detectFacesResult(image));
    }
}
