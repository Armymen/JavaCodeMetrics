package pl.pecet.javacodemetrics.core.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import pl.pecet.javacodemetrics.core.service.StorageService;

@RestController
@AllArgsConstructor
public class FileUploadController {

	private static final String ZIP_EXTENSION = ".zip";

	private static final String SUCCESS_STATUS = "success";

	private static final String ERROR_STATUS = "error";

	private final StorageService storageService;

	@PostMapping("upload/{name}")
	public FileUploadStatus handleFileUpload(@RequestParam final MultipartFile file, @PathVariable final String name) {
		final String originalFileName = file.getOriginalFilename();
		final String resultFileName = name + ZIP_EXTENSION;

		if (!originalFileName.toLowerCase().endsWith(ZIP_EXTENSION)) {
			return new FileUploadStatus(ERROR_STATUS,
					String.format("You failed to upload %s because this file is not ZIP archive", originalFileName));
		} else if (file.isEmpty()) {
			return new FileUploadStatus(ERROR_STATUS,
					String.format("You failed to upload %s because this file was empty", originalFileName));
		} else {
			try {
				storageService.store(resultFileName, file);
				return new FileUploadStatus(SUCCESS_STATUS,
						String.format("You successfully uploaded %s into %s", originalFileName, resultFileName));
			} catch (final IOException e) {
				return new FileUploadStatus(ERROR_STATUS,
						String.format("You failed to upload %s due to %s", originalFileName, e.getMessage()));
			}
		}
	}
}
