package cs.unipi.gr.filestream;
/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;


@RestController
public class FilesController {

    @LoadBalanced
    @RequestMapping(value = "/secure/api/v1_0/filestream/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        File convFile = new File("/opt/"+multipartFile.getOriginalFilename());
        multipartFile.transferTo(convFile);
        return "OK";
    }

}

