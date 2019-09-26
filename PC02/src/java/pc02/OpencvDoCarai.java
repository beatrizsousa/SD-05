/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc02;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Tiago
 */
public class OpencvDoCarai {

    private String img;

    public OpencvDoCarai(String img) {
        this.img = img;
    }

    public void deteccao() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Reading the Image from the file and storing it in to a Matrix object
        //String file = "C:\\Users\\ds799\\OneDrive\\Imagens\\CSGO_GEEK\\IMG_9581.jpg";
        Mat src = Imgcodecs.imread(img);

        // Instantiating the CascadeClassifier
        String xmlFile = "C:\\Program Files\\opencv\\sources\\samples\\android\\face-detection\\res\\raw\\lbpcascade_frontalface.xml";
        CascadeClassifier classifier = new CascadeClassifier(xmlFile);

        // Detecting the face in the snap
        MatOfRect faceDetections = new MatOfRect();
        classifier.detectMultiScale(src, faceDetections);
        System.out.println(String.format("Detected %s faces",
                faceDetections.toArray().length));

        // Drawing boxes
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(
                    src, // where to draw the box
                    new Point(rect.x, rect.y), // bottom left
                    new Point(rect.x + rect.width, rect.y + rect.height), // top right
                    new Scalar(0, 0, 255),
                    3 // RGB colour
            );
        }

        // Writing the image
        Imgcodecs.imwrite("C:\\Users\\ds799\\OneDrive\\Documentos\\Quinto Periodo\\danie1.jpg", src);

        System.out.println("Image Processed");
    }
}
