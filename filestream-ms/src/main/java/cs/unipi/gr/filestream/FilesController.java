package cs.unipi.gr.filestream;
/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


@RestController
public class FilesController {

    @LoadBalanced
    @RequestMapping(value="download", method= RequestMethod.POST)
    public void getDownload(HttpServletResponse response) throws IOException {

        // Get your file stream from wherever.
        InputStream inputstream = new FileInputStream("c:/image/sid.rar");

        // Set the content type and attachment header.

        response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);
        IOUtils.copy(inputstream, response.getOutputStream());
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        File convFile = new File("/opt/"+multipartFile.getOriginalFilename());
        multipartFile.transferTo(convFile);
        return "OK";
    }

}

