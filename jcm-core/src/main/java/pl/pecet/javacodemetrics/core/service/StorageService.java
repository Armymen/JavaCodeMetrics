package pl.pecet.javacodemetrics.core.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StorageService {

	private final GridFsTemplate gridFsTemplate;

	public String store(final String name, final MultipartFile file) throws IOException {
		final InputStream fileAsStream = new ByteArrayInputStream(file.getBytes());
		return gridFsTemplate.store(fileAsStream, name).getId().toString();
	}
}
