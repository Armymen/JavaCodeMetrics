package pl.pecet.javacodemetrics.core.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	@PostMapping("upload")
	public String handleFileUpload(@RequestParam("file") final MultipartFile file) {
		final String name = file.getName();
		if (!file.isEmpty()) {
			try {
				final byte[] bytes = file.getBytes();
				final BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(name + "-uploaded")));
				stream.write(bytes);
				stream.close();
				return "You successfully uploaded " + name + " into " + name + "-uploaded!";
			} catch (final Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}
}
